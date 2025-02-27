package com._odam.apiRestCatalogoMusica.utiles;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.ExpiredJwtException;


@Component
public class JwtUtil {
	 private static final Logger logger = LogManager.getLogger(JwtUtil.class);
	
	@Value("${jwt.secret}")
    private String jwtSecret;
    @Value("${jwt.expiration}")
    private int jwtExpirationMs;
    private SecretKey key;

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
    
    public boolean validateJwtToken(String token) {
 	   boolean valido = false;
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            valido = true;
        } catch (SecurityException e) {
     	   logger.error("Invalid JWT signature: " + e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: " + e.getMessage());
        } catch (ExpiredJwtException e) {
     	   logger.error("JWT token is expired: " + e.getMessage());
        } catch (UnsupportedJwtException e) {
     	   logger.error("JWT token is unsupported: " + e.getMessage());
        } catch (IllegalArgumentException e) {
     	   logger.error("JWT claims string is empty: " + e.getMessage());
        }
        return valido;
    }
    public String getUsernameFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key).build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
    }

}
