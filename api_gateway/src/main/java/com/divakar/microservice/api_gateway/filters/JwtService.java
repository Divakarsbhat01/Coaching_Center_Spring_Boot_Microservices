package com.divakar.microservice.api_gateway.filters;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/*
1. JWT token is a compact url representation in claims
2. it contains 3 parts: header, payload, signature
3. header contains: algorithm, type
4. payload contains: claims statements about entity and additional data
5. signature contains: signed secret key
3 types claims : registered claims Recommended (issuer, subject, expiration),public claims, private claims
 */
@Service
public class JwtService
{
    private static final String SECRET_KEY="C67CCBF37AAAB6D61D1D52E6BD265B189FA05744DDFDD99A5510833F11FC1482";
// Define Secret key which is a hex 256 bit key
    public void validateToken(final String token)
    {
        Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
    }
    private Key getSignKey()
    {
        byte[] keyBytes=Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
