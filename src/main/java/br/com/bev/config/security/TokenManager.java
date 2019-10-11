package br.com.bev.config.security;

import br.com.bev.model.Usuario;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenManager {

    @Value("${bev.jwt.secret}")
    private String secret;

    @Value("${bev.jwt.expiration}")
    private Long expirationInMillis;

    public String generateToken(Authentication authentication){

        Usuario usuario = (Usuario) authentication.getPrincipal();

        final Date now = new Date();
        final Date expiration = new Date(now.getTime() +
                this.expirationInMillis);

        return Jwts.builder()
                .setIssuer("Bate & Volta API")
                .setSubject(Long.toString(usuario.getId()))
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, this.secret)
                .compact();
    }

}
