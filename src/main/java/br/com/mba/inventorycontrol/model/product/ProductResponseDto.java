package br.com.mba.inventorycontrol.model.product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

  private Long id;

  private String name;

  private String description;

  private String image;

  private Integer quantity;

  private BigDecimal unitaryValue;

  private Integer idCategory;

  private Integer idSupplier;

  private Integer idStoragePlace;

  private LocalDateTime createdAt;

  public ProductResponseDto convertJsonToEntity(final Product product) {
    return ProductResponseDto.builder()
        .id(product.getId())
        .name(product.getName())
        .description(product.getDescription())
        .image(product.getImage())
        .quantity(product.getQuantity())
        .unitaryValue(product.getUnitaryValue())
        .idCategory(product.getIdCategory())
        .idSupplier(product.getIdSupplier())
        .idStoragePlace(product.getIdStoragePlace())
        .createdAt(product.getCreatedAt())
        .build();
  }
}
