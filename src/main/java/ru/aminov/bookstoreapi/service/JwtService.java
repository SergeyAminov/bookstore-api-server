package ru.aminov.bookstoreapi.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import ru.aminov.bookstoreapi.entity.User;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    /* Извлечение имени пользователя из токена */
    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /* Генерация токена */
    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();

        claims.put("id", user.getId());
        claims.put("username", user.getUsername());
        claims.put("role", user.getRole());

        return generateToken(claims, user);
    }

    /* Проверка токена на корректность */
    public boolean isTokenValid(String token, User user) {
        final String userName = extractUserName(token);
        return (userName.equals(user.getUsername())) && !isTokenExpired(token);
    }

    /* Извлечение данных из токена */
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers) {
        final Claims claims = extractAllClaims(token);
        return claimsResolvers.apply(claims);
    }

    /* Генерация токена */
    private String generateToken(Map<String, Object> extraClaims, User user) {
        return Jwts.builder().setClaims(extraClaims).setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 100000 * 60 * 24))
                .signWith(getSigningKey(), SignatureAlgorithm.HS512).compact();
    }

    /* Проверка токена на просроченность */
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    /* Извлечение даты истечения токена */
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    /* Извлечение всех данных из токена */
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(getSigningKey())
                .parseClaimsJws(token)
                .getBody();
    }

    /* Получение ключа для подписи токена */
    private Key getSigningKey() {
        return Keys.secretKeyFor(SignatureAlgorithm.HS512);
    }
}
