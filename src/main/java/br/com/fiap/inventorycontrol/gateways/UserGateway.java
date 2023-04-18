package br.com.fiap.inventorycontrol.gateways;

import br.com.fiap.inventorycontrol.domains.User;
import java.util.Optional;

public interface UserGateway {

  Optional<User> findByEmail(final String email);

  User findById(final String userId);
}
