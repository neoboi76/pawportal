package com.pawportal.backend.services.implementations;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import java.security.Key;
import java.util.Date;

/** Developed by Group 6:
 * Kenji Mark Alan Arceo
 * Carl Norbi Felonia
 * Ryonan Owen Ferrer
 * Dino Alfred Timbol
 * Mike Emil Vocal
 */

/**
 * JwtTokenProvider class. Provides methods that generates, validates, and extracts
 * JWT tokens from http request.
 */

@Component
public class JwtTokenProvider {

    //Secret key. Environment variable. Typically stored
    //In the applications.properties file
    @Value("${jwt.secret}")
    private String SECRET_KEY;

    //JWT token expiry date. Environment variable. Typically stored
    //In the applications.properties file
    @Value("${jwt.expiration}")
    private long EXPIRATION_TIME;

    //Generates the JWT token using the HS256 algorithm
    public String generateToken(String email) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    //Validates JWT token
    public boolean validateToken(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setAllowedClockSkewSeconds(60)
                    .setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            System.out.println("Token expires at: " + claims.getExpiration());
            System.out.println("Current time: " + new Date());

            return claims.getExpiration().after(new Date());
        } catch (JwtException | IllegalArgumentException e) {
            System.out.println("Invalid JWT token: " + e.getMessage());
            return false;
        }
    }



    //Helper method that extracts JWT token form HTTP request
    public String getEmailFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    //Helper method that extracts expiration date from JWT token
    public Date getExpirationDateFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getExpiration();
    }
}

