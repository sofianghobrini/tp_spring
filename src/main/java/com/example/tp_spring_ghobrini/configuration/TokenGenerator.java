package com.example.tp_spring_ghobrini.configuration;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenGenerator {

    @Value("${app.secret-key}")
    private String jwtSecret;

    @Value("${r5a05.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String generateJwtToken(Authentication authentication) {

        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();

        Date tokenCreationDate = new Date();
        Date tokenExpirationDate = new Date(tokenCreationDate.getTime() + jwtExpirationMs);

        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(tokenCreationDate)
                .setExpiration(tokenExpirationDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
}