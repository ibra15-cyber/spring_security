//package com.ibra.ecommerce.user.security;
//
//import io.jsonwebtoken.*;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.stereotype.Component;
//
//import java.util.Base64;
//import java.util.Date;
//import java.util.List;
//
//@Component
//public class JwtUtil {
//
//    private final String SECRET_KEY = "your_secret_key";
//    private final long EXPIRATION_TIME = 1000 * 60 * 60 * 10; // 10 hours
//
//    public String generateToken(String username, List<String> roles) {
//        return Jwts.builder()
//                .subject(username)
//                .claim("roles", roles)
//                .issuedAt(new Date())
//                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .signWith(Keys.hmacShaKeyFor(Base64.getDecoder().decode(SECRET_KEY)))
//                .compact();
//    }
//
//    public String extractUsername(String token) {
//        return Jwts.parser()
//                .verifyWith(Keys.hmacShaKeyFor(Base64.getDecoder().decode(SECRET_KEY)))
//                .build()
//                .parseSignedClaims(token)
//                .getPayload()
//                .getSubject();
//    }
//
//    public boolean isTokenValid(String token, String username) {
//        return extractUsername(token).equals(username) && !isTokenExpired(token);
//    }
//
//    private boolean isTokenExpired(String token) {
//        return Jwts.parser()
//                .verifyWith(Keys.hmacShaKeyFor(Base64.getDecoder().decode(SECRET_KEY)))
//                .build().parseSignedClaims(token)
//                .getPayload()
//                .getExpiration()
//                .before(new Date());
//    }
//}
