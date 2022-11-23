package br.com.fiap.inventorycontrol.gateways;

import br.com.fiap.inventorycontrol.domains.User;
import java.util.Optional;
import org.springframework.context.annotation.Primary;

@Primary
public interface UserGateway {

  User save(final User user);

  Optional<User> findByEmail(final User user);
}
