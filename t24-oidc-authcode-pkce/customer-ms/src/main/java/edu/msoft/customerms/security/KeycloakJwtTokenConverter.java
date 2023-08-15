package edu.msoft.customerms.security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimNames;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KeycloakJwtTokenConverter implements Converter<Jwt, JwtAuthenticationToken> {

    private final JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter;

    public KeycloakJwtTokenConverter (JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter) {
        this.jwtGrantedAuthoritiesConverter = jwtGrantedAuthoritiesConverter;
    }

    @Override
    public JwtAuthenticationToken convert (@NonNull Jwt jwt) {

        Stream<SimpleGrantedAuthority>
                roleAuthorities =
                Optional.of(jwt)
                        .map(token -> token.getClaimAsMap("resource_access"))
                        .map(claimMap -> (Map<?, ?>) claimMap.get("customer-ms"))
                        .map(resourceData -> (Collection<?>) resourceData.get("roles"))
                        .stream()
                        .flatMap(Collection::stream)
                        .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                        .distinct();

        Set<GrantedAuthority>
                authorities =
                Stream.concat(Optional.of(jwtGrantedAuthoritiesConverter.convert(jwt))
                        .stream()
                        .flatMap(Collection::stream), roleAuthorities).collect(Collectors.toSet());

        String
                principalClaimName =
                Optional.ofNullable(jwt.getClaimAsString("preferred_username"))
                        .orElse(jwt.getClaimAsString(JwtClaimNames.SUB));

        return new JwtAuthenticationToken(jwt, authorities, principalClaimName);
    }

}
