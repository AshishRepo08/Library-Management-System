package com.RollNo8.MyLibraryManagementPlatform.serviceJWT;

//NOTE : Refer to https://www.codingshuttle.com/spring-boot-handbook/jwt-creation-and-verification/ for simpler and better example of token generation step

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTService {

      //One way to specify a secret
//    private String secretKey = "ThisIsMyRollNo8KeyThisIsMyRollNo8KeyThisIsMyRollNo8Key";

    //Second Way to specify the Secret
    private String secretKey="";
    public JWTService() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey sk = keyGen.generateKey();
            secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private SecretKey getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(String username) {

        Map<String,Object> claims = new HashMap<>();

        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+(60*60*30)))
                .and()
                .signWith(getKey())
                .compact();
    }

    //-------------------------End of Token Generation Part ------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------


    //This method is not part of token generation. It will used to extract username for token verification

    public String extractUserName(String token) {

        //To get the username, we have to follow below steps :
           //1. Decode the token
           //2. Fetch the claims
           //3. From the claims, fetch the username

        return extractClaim(token, Claims::getSubject);
    }

    public boolean validateToken(String token, UserDetails loggedInUser) {

        //To validate token, we have follow below steps
            //1. Check for expiration time
        final String userName = extractUserName(token);
        return (userName.equals(loggedInUser.getUsername()) && !isTokenExpired(token));

    }

    //-------------------------------------Helper methods for token verification -----------------
    private <T> T extractClaim(String token, Function<Claims, T> claimResolver){
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token){
        return extractClaim(token,Claims::getExpiration);
    }


}
