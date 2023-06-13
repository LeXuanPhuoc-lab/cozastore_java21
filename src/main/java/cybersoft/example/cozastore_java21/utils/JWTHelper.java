package cybersoft.example.cozastore_java21.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JWTHelper {
    // class sinh ra JWT/ giai ma JWT

    //@Value
    @Value("${jwt.secret.key}")
    private String secretKey;

    // Khoi tao secret Key
    // SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    // String strKey = Encoders.BASE64.encode(key.getEncoded());

    public String generateTokent(String data){
        Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));

        String token = Jwts.builder()
//                .setSubject("Hello World!")
                .setSubject(data)
                .signWith(key)
                .compact();
        return token;
    }

    public Claims decodeToken(String token){
        Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
        Claims claims = Jwts.parserBuilder().
                setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }
}
