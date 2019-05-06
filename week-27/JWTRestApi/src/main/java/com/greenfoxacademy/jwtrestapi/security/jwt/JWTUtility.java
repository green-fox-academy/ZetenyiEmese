package com.greenfoxacademy.jwtrestapi.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

import static java.util.Collections.emptyList;

public class JWTUtility {

  static final String SECRET = "ThisIsASecret";
  static final String TOKEN_PREFIX = "Bearer ";
  static final String HEADER_STRING = "Authorization";

  public static String generateToken(String username) {
    String jwtToken = Jwts.builder()
            .setSubject(username)
            .signWith(SignatureAlgorithm.HS256, SECRET)
            .compact();
    return jwtToken;
  }

  public static Authentication getAuthentication(HttpServletRequest request) {
    String token = request.getHeader(HEADER_STRING);
    if (token != null) {
      String username = Jwts.parser()
              .setSigningKey(SECRET)
              .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
              .getBody()
              .getSubject();

      return username != null ?
              new UsernamePasswordAuthenticationToken(username, null, emptyList()) :
              null;
    }
    return null;
  }

  public static String retrieveUsername(String token) {
    if (token != null) {
      String username = Jwts.parser()
              .setSigningKey(SECRET)
              .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
              .getBody()
              .getSubject();

      return username;
    }
    return null;
  }

}
