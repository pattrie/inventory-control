package br.com.mba.inventorycontrol.model.product;

import br.com.mba.inventorycontrol.model.category.CategoryRequestDto;
import br.com.mba.inventorycontrol.model.storageplace.StoragePlaceRequestDto;
import br.com.mba.inventorycontrol.model.supplier.SupplierRequestDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductRequestDto {

  @NotNull(message = "Name of the product cannot be null")
  private String name;

  private String sku;

  private String description;

  private String image;

  private String color;

  @Positive
  @NotNull(message = "Unitary value cannot be null")
  private BigDecimal unitaryValue;

  private CategoryRequestDto category;

  private SupplierRequestDto supplier;

  @NotNull(message = "Storage place cannot be null")
  private List<StoragePlaceRequestDto> storagePlaces;

  public Product convertJsonToEntity() {
    return Product.builder()
        .name(this.name)
        .sku(this.sku)
        .description(this.description)
        .image(this.image)
        .color(this.color)
        .quantity(storagePlaces.stream().mapToLong(StoragePlaceRequestDto::getQuantity).sum())
        .unitaryValue(this.unitaryValue)
        .build();
  }
}
