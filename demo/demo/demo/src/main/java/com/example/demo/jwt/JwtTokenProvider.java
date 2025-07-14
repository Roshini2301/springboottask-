package com.example.demo.jwt;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {//1.jwt provider
     @Value("${app.jwt-secret}")//start from application.properties
     private String jwtSecret;
     @Value("${app.jwt-expiration-milliseconds}")
    private long jwtExpirationMilliSecond;
    private Key secretKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }
    public String generateToken(Authentication authenticate){
        UserDetails userPrincipal = (UserDetails) authenticate.getPrincipal();
        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+jwtExpirationMilliSecond))
                .signWith(secretKey(),SignatureAlgorithm.HS256)
                .compact();
    }
    public String getUsernameFromToken(String token){
        return Jwts.parserBuilder().setSigningKey(secretKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    public boolean validateToken(String token){
        try{
            Jwts.parserBuilder()
                    .setSigningKey(secretKey())
                    .build()
                    .parseClaimsJws(token);
            return true;


        }
        catch (JwtException | IllegalArgumentException e){
            e.printStackTrace();
        }
        return false;

    }


}
