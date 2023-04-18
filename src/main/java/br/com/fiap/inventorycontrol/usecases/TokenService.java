package br.com.fiap.inventorycontrol.usecases;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {

  @Value("${security.jwt.secret}")
  private String secret;

  public boolean isTokenValid(String token) {
    try {
      Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public String getUserId(String token) {
    final Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
    return claims.getSubject();
  }
}
