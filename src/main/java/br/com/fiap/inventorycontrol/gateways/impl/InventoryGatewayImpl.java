package br.com.fiap.inventorycontrol.gateways.impl;

import br.com.fiap.inventorycontrol.domains.Product;
import br.com.fiap.inventorycontrol.gateways.InventoryGateway;
import br.com.fiap.inventorycontrol.gateways.repositories.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class InventoryGatewayImpl implements InventoryGateway {

  private final InventoryRepository inventoryRepository;

  @Override
  public Product save(final Product product) {
    log.info(
        product.getId() == null
            ? String.format("Saving product:: %s", product.getName())
            : String.format("Updating product:: %s - %s", product.getId(), product.getName()));
    return inventoryRepository.save(product);
  }

  @Override
  public Optional<Product> findBy(final String id) {
    log.info("Searching product with id:: {}", id);
    return inventoryRepository.findById(id);
  }

  @Override
  public List<Product> getAll() {
    log.info("Finding all products");
    return inventoryRepository.findAll();
  }

  @Override
  public void delete(Product product) {
    log.info("Deleting product with ID:: {}", product.getId());
    inventoryRepository.delete(product);
  }
}
