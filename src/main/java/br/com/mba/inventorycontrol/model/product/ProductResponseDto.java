package br.com.mba.inventorycontrol.model.product;

import br.com.mba.inventorycontrol.model.category.Category;
import br.com.mba.inventorycontrol.model.storageplace.StoragePlace;
import br.com.mba.inventorycontrol.model.supplier.Supplier;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {

  private Integer id;

  private String name;

  private String description;

  private String image;

  private Long quantity;

  private BigDecimal unitaryValue;

  private Category idCategory;

  private Supplier idSupplier;

  private List<StoragePlace> storagePlaces;

  private LocalDateTime createdAt;

  public ProductResponseDto convertJsonToEntity(final Product product) {
    return ProductResponseDto.builder()
        .id(product.getId())
        .name(product.getName())
        .description(product.getDescription())
        .image(product.getImage())
        .quantity(product.getQuantity())
        .unitaryValue(product.getUnitaryValue())
        .idCategory(product.getCategory())
        .idSupplier(product.getSupplier())
        .storagePlaces(product.getStoragePlaces())
        .createdAt(product.getCreatedAt())
        .build();
  }
}
