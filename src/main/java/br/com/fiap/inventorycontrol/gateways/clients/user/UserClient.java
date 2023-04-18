package br.com.fiap.inventorycontrol.gateways.clients.user;

import br.com.fiap.inventorycontrol.domains.User;
import java.util.Optional;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user", url = "${spring.clients.userclient.url}")
public interface UserClient {

  @GetMapping(value = "/email/{email}", consumes = "application/json")
  Optional<User> findByEmail(@PathVariable("email") String email);

  @GetMapping(value = "/user/{id}", consumes = "application/json")
  User findById(@PathVariable("id") String userId);
}
