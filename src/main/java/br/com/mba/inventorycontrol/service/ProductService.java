package br.com.mba.inventorycontrol.service;

import br.com.mba.inventorycontrol.model.product.Product;
import br.com.mba.inventorycontrol.model.product.ProductResponseDto;
import br.com.mba.inventorycontrol.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {

  private ProductRepository productRepository;

  public Product create(final Product product) {
    return productRepository.save(product);
  }

  public ResponseEntity<ProductResponseDto> findById(final Long id) {
    return productRepository.findById(id)
        .map(product -> ResponseEntity.ok()
            .body(new ProductResponseDto().convertJsonToEntity(product)))
        .orElse(ResponseEntity.notFound().build());
  }
}
