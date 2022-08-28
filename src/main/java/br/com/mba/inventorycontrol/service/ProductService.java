package br.com.mba.inventorycontrol.service;

import br.com.mba.inventorycontrol.model.product.Product;
import br.com.mba.inventorycontrol.model.product.ProductResponseDto;
import br.com.mba.inventorycontrol.model.productin.ProductIn;
import br.com.mba.inventorycontrol.repository.ProductInRepository;
import br.com.mba.inventorycontrol.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {

  private ProductRepository productRepository;
  private ProductInRepository productInRepository;

  public Product create(final Product product) {
    final Product productSave = productRepository.save(product);
    final ProductIn productIn = ProductIn.builder()
        .idProduct(productSave.getId())
        .quantity(product.getQuantity())
        .build();
    productInRepository.save(productIn);
    return productSave;
  }

  public ResponseEntity<ProductResponseDto> findById(final Integer id) {
    return productRepository.findById(id)
        .map(product -> ResponseEntity.ok()
            .body(new ProductResponseDto().convertJsonToEntity(product)))
        .orElse(ResponseEntity.notFound().build());
  }
}
