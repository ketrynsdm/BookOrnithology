package com.api.ornithology.infra.exception.security;

import com.api.ornithology.Utils.DateTimeUtils;
import com.api.ornithology.domain.User.DadosAutenticacao;
import com.auth0.jwt.exceptions.JWTCreationException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.nio.file.AccessDeniedException;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.function.Function;

@Service

public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    @Value("${api.security.token.expiration}")
    private Long jwtExpirationMs;

    private SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    public String gerarToken(DadosAutenticacao usuario) {
        try {
            String token = "Bearer " + Jwts.builder()
                    .setSubject(usuario.login())
                    .setIssuedAt(DateTimeUtils.now())
                    .setExpiration(new Date(DateTimeUtils.now().getTime() + jwtExpirationMs))
                    .signWith(signatureAlgorithm, getSecretyKey())
                    .compact();
            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("erro ao gerar token jwt", exception);
        }
    }

    private Key getSecretyKey(){
        System.out.println(secret);
        byte[] apiKeySecretBytes = Base64.getEncoder().encode(secret.getBytes(StandardCharsets.UTF_8));
        Key signinKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        return signinKey;
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(getSecretyKey()).build().parseClaimsJws(token).getBody();
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private <T> T getClaimFromToken(String token, String key, Class<T> type) {
        final Claims claims = getAllClaimsFromToken(token);
        return claims.get(key, type);
    }

    private Date getExpirationDateFromToken(String token) { return getClaimFromToken(token, Claims::getExpiration);}

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(DateTimeUtils.now());
    }

    public String getUserNameFromJwtToken(String token) { return getAllClaimsFromToken(token).getSubject();}

    public boolean validateJwtToken(String authToken) {
        try {
            if (getAllClaimsFromToken(authToken) == null) throw new AccessDeniedException("Usuário não autenticado!");

            if (isTokenExpired(authToken)) throw new AccessDeniedException("Usuário não autenticado!");

            return true;
            } catch (Exception e) {
            System.out.println("Invalid JWT token: " + e.getMessage());
            }
        return false;
        }
}
