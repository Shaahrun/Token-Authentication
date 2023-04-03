package com.gmail.ejikemesharon.TokenAuthentication.security;

public class SecurityConstants {

    public static final String SECRET = "secret_key";
    public static final long EXPIRATION_TIME = 900_000_000;

    public static final String HEADER = "Authorization";

    public static final String TOKEN_PREFIX = "Bearer  ";

    public static final String SIGN_UP_URL = "/authenticate";
}
