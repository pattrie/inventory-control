package br.com.fiap.inventorycontrol.gateways.impl;

import br.com.fiap.inventorycontrol.domains.Product;
import br.com.fiap.inventorycontrol.gateways.InventoryGateway;
import br.com.fiap.inventorycontrol.gateways.repositories.InventoryRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class InventoryGatewayImpl implements InventoryGateway {

  private final InventoryRepository inventoryRepository;

  @Override
  public Product save(final Product product) {
    log.info("Saving a product:: {} - {}", product.getId(), product.getName());
    return inventoryRepository.save(product);
  }

  @Override
  public Optional<Product> findBy(final Integer id) {
    log.info("Searching a product with id:: {}", id);
    return inventoryRepository.findById(id);
  }

  @Override
  public List<Product> getAll() {
    return inventoryRepository.findAll();
  }
}
