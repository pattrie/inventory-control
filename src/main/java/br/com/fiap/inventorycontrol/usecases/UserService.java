package br.com.fiap.inventorycontrol.usecases;

import br.com.fiap.inventorycontrol.domains.User;
import br.com.fiap.inventorycontrol.gateways.UserGateway;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserService {

  private final UserGateway userGateway;

  public Optional<User> findByEmail(final String username) {
    return userGateway.findByEmail(username);
  }

  public User findById(final String userId) {
    return userGateway.findById(userId);
  }
}
