package br.com.fiap.inventorycontrol.controllers.jsons.response;

import static java.util.Objects.isNull;

import br.com.fiap.inventorycontrol.domains.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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
public class ProductResponseJson {

  private String id;

  private String name;

  private String description;

  private String color;

  private String image;

  private Long quantity;

  private BigDecimal unitaryValue;

  private CategoryResponseJson category;

  private SupplierResponseJson supplier;

  private List<StoragePlaceResponseJson> storagePlaces;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDateTime createdAt;

  public ProductResponseJson convertEntityToJson(final Product product) {
    return ProductResponseJson.builder()
        .id(product.getId())
        .name(product.getName())
        .color(product.getColor())
        .description(product.getDescription())
        .image(product.getImage())
        .quantity(product.getQuantity())
        .unitaryValue(product.getUnitaryValue())
        .category(isNull(product.getCategory()) ? null
            : new CategoryResponseJson().convertEntityToJson(product.getCategory()))
        .supplier(isNull(product.getSupplier()) ? null
            : new SupplierResponseJson().convertEntityToJson(product.getSupplier()))
        .storagePlaces(isNull(product.getStoragePlaces()) ? List.of() :
            new StoragePlaceResponseJson().convertEntityToJson(product.getStoragePlaces())
        )
        .createdAt(product.getCreatedAt())
        .build();
  }
}
