package br.com.fiap.inventorycontrol.usecases;

import br.com.fiap.inventorycontrol.controllers.jsons.response.ProductResponseJson;
import br.com.fiap.inventorycontrol.domains.Product;
import br.com.fiap.inventorycontrol.gateways.InventoryGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class InventoryService {

  private final InventoryGateway inventoryGateway;

  public ProductResponseJson createOrUpdate(final Product product) {
    final Product productSaved = inventoryGateway.save(product);
    return new ProductResponseJson().convertEntityToJson(productSaved);
  }

  public ResponseEntity<ProductResponseJson> findBy(final String id) {
    return inventoryGateway
        .findBy(id)
        .map(
            product ->
                ResponseEntity.ok().body(new ProductResponseJson().convertEntityToJson(product)))
        .orElse(ResponseEntity.notFound().build());
  }

  public List<ProductResponseJson> getAll() {
    return inventoryGateway.getAll().stream()
        .map(product -> new ProductResponseJson().convertEntityToJson(product))
        .collect(Collectors.toList());
  }

  public ResponseEntity<Object> deleteById(final String id) {
    return inventoryGateway.findBy(id)
            .map(product -> {
              inventoryGateway.delete(product);
              return ResponseEntity.noContent().build();
            }).orElse(ResponseEntity.notFound().build());
  }
}
