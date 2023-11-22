package com.example.course.services;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.Jwts.SIG;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.util.*;

@Service
public class JwtService {

    public String getEmail(String jwt) {

        return extractClaim(jwt, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claim = jwtClaims(token);
        return claimResolver.apply(claim);

    }

    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(Map<String, Object> extractClaim, UserDetails userDetails) {
        return Jwts.builder().claims(extractClaim).subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 10000 * 60)).signWith(getSignInKey(), SIG.HS256)
                .compact();

    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String email = getEmail(token);
        return email.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    public boolean isTokenExpired(String token) {
        final Date expDate = extractClaim(token, Claims::getExpiration);
        return expDate.before(new Date());
    }

    private Claims jwtClaims(String jwtToken) {
        return Jwts.parser().decryptWith(getSignInKey()).build().parseSignedClaims(jwtToken).getPayload();
    }

    private SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode("Pravin");
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
