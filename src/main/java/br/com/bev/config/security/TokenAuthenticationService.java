package br.com.bev.config.security;

import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;


/**
 * Classe responsavel por gerar e validar os tokens
 * Envia o token na resposta
 * */
public class TokenAuthenticationService {

    // EXPIRATION_TIME = 10 dias
    static final long EXPIRATION_TIME = 860_000_000;
    static final String SECRET = "B4T3V0LT4SECRETF14P0R4CL32ol9";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";
    public static final String AUTHORITIES_KEY = "scopes";

    // Geração do Token
    static void addAuthentication(HttpServletResponse response, String username, Collection<? extends GrantedAuthority> authorities) {

        final String roles = authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        String JWT = Jwts.builder()
                .setSubject(username)
                .claim(AUTHORITIES_KEY, roles)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();

        response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
    }

    // Validação do Token
    static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);

        if (token != null) {

            final JwtParser jwtParser = Jwts.parser().setSigningKey(SECRET);
            final Jws claimsJws = jwtParser.parseClaimsJws(token);
            final Claims claims = (Claims) claimsJws.getBody();

            final Collection authorities =
                    Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                            .map(SimpleGrantedAuthority::new)
                            .collect(Collectors.toList());

            String user = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();

            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, authorities);
            }
        }
        return null;
    }
}