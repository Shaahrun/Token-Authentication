package com.gmail.ejikemesharon.TokenAuthentication.security;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

public class SecurityConstants {

    public static final SecretKey SECRET = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    public static final long EXPIRATION_TIME = 900_000_000;

    public static final String HEADER = "Authorization";

    public static final String TOKEN_PREFIX = "Bearer  ";

    public static final String SIGN_UP_URL = "/authenticate";
}
