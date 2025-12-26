package com.example.demo.security;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

public class JwtTokenProvider {

    private final Key key =
            Keys.hmacShaKeyFor("my-secret-key-my-secret-key-my-secret-key".getBytes());

    public String generateToken(User user) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());       // y
        claims.put("email", user.getEmail());     // 
        claims.put("roles", user.getRoles()
                .stream()
                .map(Role::getName)
                .collect(Collectors.toSet()));

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
