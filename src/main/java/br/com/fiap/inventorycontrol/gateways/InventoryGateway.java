package br.com.fiap.inventorycontrol.gateways;

import br.com.fiap.inventorycontrol.domains.Product;
import java.util.List;
import java.util.Optional;

public interface InventoryGateway {

  Product save(Product product);

  Optional<Product> findBy(String id);

  List<Product> getAll();

  void delete(Product product);
}
