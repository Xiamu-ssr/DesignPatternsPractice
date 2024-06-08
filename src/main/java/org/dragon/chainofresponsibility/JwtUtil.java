package org.dragon.chainofresponsibility;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * JWT工具类
 *
 * @author mumu
 * @date 2024/06/08
 */
public class JwtUtil {
    private static final String SECRET_KEY = "SBIAI==202156SADADAWFAW12fawfaw4616516161165dadawfawfwa351f6a51f56a1f5a3f35";
    public static String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("password", user.getPassword())
                .claim("role", user.getRole().name())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public static User parseToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
        return new User(
                claims.getSubject(),
                claims.get("password", String.class),
                UserRole.valueOf(claims.get("role", String.class)));
    }
}
