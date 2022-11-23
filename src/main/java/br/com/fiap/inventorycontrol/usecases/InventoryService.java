package br.com.fiap.inventorycontrol.usecases;

import br.com.fiap.inventorycontrol.controllers.jsons.response.ProductResponseJson;
import br.com.fiap.inventorycontrol.domains.Product;
import br.com.fiap.inventorycontrol.gateways.InventoryGateway;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InventoryService {

  private final InventoryGateway inventoryGateway;

  public ProductResponseJson create(final Product product) {
    final Product productSaved = inventoryGateway.save(product);
    return new ProductResponseJson().convertEntityToJson(productSaved);
  }

  public ResponseEntity<ProductResponseJson> findBy(final Integer id) {
    return inventoryGateway.findBy(id)
        .map(product -> ResponseEntity.ok()
            .body(new ProductResponseJson().convertEntityToJson(product)))
        .orElse(ResponseEntity.notFound().build());
  }

  public List<ProductResponseJson> getAll() {
    return inventoryGateway.getAll()
        .stream().map(product -> new ProductResponseJson().convertEntityToJson(product))
        .collect(Collectors.toList());
  }
}
