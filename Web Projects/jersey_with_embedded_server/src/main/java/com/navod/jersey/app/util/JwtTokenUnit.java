package com.navod.jersey.app.util;

import com.navod.jersey.app.model.UserDetails;
import io.fusionauth.jwt.Signer;
import io.fusionauth.jwt.Verifier;
import io.fusionauth.jwt.domain.JWT;
import io.fusionauth.jwt.hmac.HMACSigner;
import io.fusionauth.jwt.hmac.HMACVerifier;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenUnit {

    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATOR = "created";
    private static final String ISSUER = "www.navod.lk";
    private static final String SECRET = "B7@g!{B2g{:jnJk+_*vA?:Hi]6P?)r:$NwmHSE1X[Bn#HGBDPL@;FzJdB0?M,]vjMWv{;wtRp,0+";
    private static final Long TOKEN_LIFE = 1L;
    private static final Long REFRESH_TOKEN_LIFE = 43200L;
    private String generateToken(Map<String, String> claims,Long expiration, String subject){
        // Build an HMAC signer using a SHA-256 hash
        Signer signer = HMACSigner.newSHA256Signer(SECRET);

// Build a new JWT with an issuer(iss), issued at(iat), subject(sub) and expiration(exp)
        JWT jwt = new JWT().setIssuer(ISSUER)
                .setIssuedAt(ZonedDateTime.now(ZoneOffset.UTC))
                .setSubject(subject)
                .setExpiration(ZonedDateTime.now(ZoneOffset.UTC).plusMinutes(TOKEN_LIFE));

        claims.keySet().forEach(k ->{
            if(claims.get(k) != null){
                jwt.addClaim(k, claims.get(k));
            }
        });
        return JWT.getEncoder().encode(jwt, signer);
    }

    public Map<String, String> getClaimFromToken(String token){
        // Build an HMC verifier using the same secret that was used to sign the JWT
        Verifier verifier = HMACVerifier.newVerifier(SECRET);

// Verify and decode the encoded string JWT to a rich object
        JWT jwt = JWT.getDecoder().decode(token, verifier);

        Map<String, String> claims = new HashMap<>();
        if(jwt != null){
            jwt.getAllClaims().forEach((k, v)->{
                claims.put(k,v.toString());
            });
        }
        return claims;
    }

    public String getUsernameFromToken(String token){
            Map<String, String> claims = getClaimFromToken(token);
            String username = claims.get(CLAIM_KEY_USERNAME);
            return username;
    }

    public Date getExpireDateFromToken(String token){
        Verifier verifier = HMACVerifier.newVerifier(SECRET);
        JWT jwt = JWT.getDecoder().decode(token, verifier);
        return new Date(jwt.expiration.toInstant().toEpochMilli());
    }

    private boolean isTokenExpired(String token){
        Date expireDate = getExpireDateFromToken(token);
        return expireDate.before(new Date(System.currentTimeMillis()));
    }

    public boolean validateToken(String token, UserDetails userDetails){
        String username = getUsernameFromToken(token);
        return username.equals(userDetails.getEmail()) && !isTokenExpired(token);
    }

    public String generateAccessToken(UserDetails userDetails){
        Map<String, String> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME ,userDetails.getEmail());
        claims.put(CLAIM_KEY_CREATOR ,new Date().toString());
        return generateToken(claims,TOKEN_LIFE , userDetails.getEmail());
    }

    public String generateRefreshToken(UserDetails userDetails){
        Map<String, String> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME ,userDetails.getEmail());
        claims.put(CLAIM_KEY_CREATOR ,new Date().toString());
        return generateToken(claims,REFRESH_TOKEN_LIFE , userDetails.getEmail());
    }
}
