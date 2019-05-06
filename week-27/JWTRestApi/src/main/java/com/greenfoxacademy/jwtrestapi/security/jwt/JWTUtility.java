package com.greenfoxacademy.jwtrestapi.security.jwt;

import com.greenfoxacademy.jwtrestapi.models.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtility {

  public static String generateToken(String username){

    String jwtToken = Jwts.builder()
            .setSubject(username)
            .signWith(SignatureAlgorithm.HS256, "ThisIsASecret")
            .compact();
    return jwtToken;
  }

}
