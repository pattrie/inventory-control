package br.com.fiap.inventorycontrol.configurations.security;

import br.com.fiap.inventorycontrol.domains.User;
import br.com.fiap.inventorycontrol.usecases.TokenService;
import br.com.fiap.inventorycontrol.usecases.UserService;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

@RequiredArgsConstructor
public class AuthenticationViaTokenFilter extends OncePerRequestFilter {

  private final TokenService tokenService;

  private final UserService userService;

  @Override
  protected void doFilterInternal(final HttpServletRequest request,
      final HttpServletResponse response,
      final FilterChain filterChain) throws ServletException, IOException {
    String token = getToken(request);

    boolean validToken = tokenService.isTokenValid(token);

    if (validToken) {
      authenticateClient(token);
    }

    filterChain.doFilter(request, response);
  }

  private String getToken(final HttpServletRequest request) {
    final String token = request.getHeader("Authorization");
    if (token == null || !token.startsWith("Bearer ")) {
      return null;
    }
    return token.substring(7);
  }

  private void authenticateClient(final String token) {
    String userId = tokenService.getUserId(token);
    final User user = userService.findById(userId);

    UsernamePasswordAuthenticationToken authentication =
        new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
    SecurityContextHolder.getContext().setAuthentication(authentication);
  }
}
