package edu.msoft.clientmtls;

import feign.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

@Configuration
public class CustomerClientConfiguration {

    public static final String TRUSTSTORE_PATH = "truststore.jks";
    public static final String TRUSTSTORE_PASSWORD = "openssl";
    public static final String KEYSTORE_PATH = "restapi-keystore.p12";
    public static final String KEYSTORE_PASSWORD = "openssl";

    @Bean
    public static Client getFeignClient() throws RuntimeException
    {
        try
        {
            return new Client.Default(getClientSSLSocketFactory(), null);
        } catch (Exception e)
        {
            throw new RuntimeException("Error initializing the Feign client", e);
        }
    }

    private static SSLSocketFactory getClientSSLSocketFactory()
            throws NoSuchAlgorithmException, KeyStoreException,
            CertificateException, IOException, KeyManagementException, UnrecoverableKeyException
    {

        SSLContext sslContext = SSLContext.getInstance("TLS");

        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        trustStore.load(new ClassPathResource(TRUSTSTORE_PATH).getInputStream(), TRUSTSTORE_PASSWORD.toCharArray());
        TrustManagerFactory trustManagerFactory = TrustManagerFactory
                .getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(trustStore);

        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());

        keyStore.load(new ClassPathResource(KEYSTORE_PATH).getInputStream(), KEYSTORE_PASSWORD.toCharArray());
        KeyManagerFactory keyManagerFactory = KeyManagerFactory
                .getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, KEYSTORE_PASSWORD.toCharArray());

        KeyManager[] keyManagers = keyManagerFactory.getKeyManagers();
        if (keyManagers == null)
        {
            keyManagers = new KeyManager[] {};
        }

        sslContext.init(keyManagers, trustManagerFactory.getTrustManagers(), null);

        return sslContext.getSocketFactory();

    }

}
