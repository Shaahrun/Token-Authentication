package com.gmail.ejikemesharon.TokenAuthentication.security;

import com.gmail.ejikemesharon.TokenAuthentication.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenUtil {

    public String generateToken(User user) {
        String token = Jwts.builder()
                .setSubject(String.format("%s, %s", user.getId(), user.getName()))
                .setIssuer("Sharon")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET)
                .compact();
        System.out.println(token);
        return token;
    }
}
