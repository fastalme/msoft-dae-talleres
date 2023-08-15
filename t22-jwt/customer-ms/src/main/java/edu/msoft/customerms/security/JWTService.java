package edu.msoft.customerms.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.time.Instant;

@Component
public class JWTService {

    public static final String JWT_ISSUER = "restapi";
    public static final int TTL = 30;
    @Value("classpath:restapi.pub")
    Resource publicKeyResource;
    @Value("classpath:restapi.key")
    Resource privateKeyResource;

    public String generate (User user) {

        String result;
        try {
            Algorithm
                    algorithm =
                    Algorithm.RSA256(readPublicKey(publicKeyResource.getFile()),
                            readPrivateKey(privateKeyResource.getFile()));
            result =
                    JWT.create()
                            .withIssuer(JWT_ISSUER)
                            .withSubject(user.getId())
                            .withAudience(JWT_ISSUER)
                            .withIssuedAt(Instant.now())
                            .withExpiresAt(Instant.now().plusSeconds(TTL))
                            .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error creating JWT");
        } catch (IOException e) {
            throw new RuntimeException("Error reading key file");
        }

        return result;

    }

    private RSAPublicKey readPublicKey (File file) throws IOException {
        try (FileReader keyReader = new FileReader(file)) {
            PEMParser pemParser = new PEMParser(keyReader);
            JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
            SubjectPublicKeyInfo publicKeyInfo = SubjectPublicKeyInfo.getInstance(pemParser.readObject());
            return (RSAPublicKey) converter.getPublicKey(publicKeyInfo);
        }
    }

    private RSAPrivateKey readPrivateKey (File file) throws IOException {
        try (FileReader keyReader = new FileReader(file)) {
            PEMParser pemParser = new PEMParser(keyReader);
            JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
            PrivateKeyInfo privateKeyInfo = PrivateKeyInfo.getInstance(pemParser.readObject());
            return (RSAPrivateKey) converter.getPrivateKey(privateKeyInfo);
        }
    }

    public void validate (String token) {

        if (token == null || token.length() <= 7) {
            throw new RuntimeException("Invalid token");
        }

        try {
            Algorithm
                    algorithm =
                    Algorithm.RSA256(readPublicKey(publicKeyResource.getFile()),
                            readPrivateKey(privateKeyResource.getFile()));

            JWTVerifier verifier = JWT.require(algorithm).withIssuer(JWT_ISSUER).build();

            verifier.verify(token.substring(7));
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Invalid token: " + exception.getMessage());
        } catch (IOException e) {
            throw new RuntimeException("Error reading key file");
        }
    }

}
