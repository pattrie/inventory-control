package br.com.fiap.inventorycontrol.gateways.impl;

import br.com.fiap.inventorycontrol.domains.User;
import br.com.fiap.inventorycontrol.gateways.UserGateway;
import br.com.fiap.inventorycontrol.gateways.clients.user.UserClient;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserGatewayImpl implements UserGateway {

  private final UserClient userClient;

  @Override
  public Optional<User> findByEmail(final String email) {
    return userClient.findByEmail(email);
  }

  @Override
  public User findById(final String userId) {
    return userClient.findById(userId);
  }
}
