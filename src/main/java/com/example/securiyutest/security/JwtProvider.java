package com.example.securiyutest.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {

    @Value("${jwt.token.secret}")
    private String secret;

    @Value("${jwt.token.validity}")
    private Long validityMilliSecond;
}
