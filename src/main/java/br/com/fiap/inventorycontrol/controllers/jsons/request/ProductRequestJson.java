package br.com.fiap.inventorycontrol.controllers.jsons.request;

import br.com.fiap.inventorycontrol.domains.Product;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestJson {
  @ApiModelProperty(notes = "The name of the product.", required = true)
  @NotNull(message = "Name of the product cannot be null")
  private String name;

  @ApiModelProperty(notes = "Code SKU.")
  private String sku;

  @ApiModelProperty(notes = "Description of the product.")
  private String description;

  @ApiModelProperty(notes = "Image.")
  private String image;

  @ApiModelProperty(notes = "Colors of the product.")
  private String color;

  @ApiModelProperty(notes = "Unitary value of the product.", required = true)
  @Positive
  @NotNull(message = "Unitary value cannot be null")
  private BigDecimal unitaryValue;

  @ApiModelProperty(notes = "Category of the product.")
  private CategoryRequestJson category;

  @ApiModelProperty(notes = "Supplier of the product.")
  private SupplierRequestJson supplier;

  @ApiModelProperty(notes = "Location where product is stored.", required = true)
  @NotNull(message = "Storage place cannot be null")
  private List<StoragePlaceRequestJson> storagePlaces;

  public Product convertJsonToEntity() {
    return Product.builder()
        .name(this.name)
        .sku(this.sku)
        .description(this.description)
        .image(this.image)
        .color(this.color)
        .unitaryValue(this.unitaryValue)
        .category(category == null ? null : category.convertJsonToEntity())
        .supplier(supplier == null ? null : supplier.convertJsonToEntity())
        .storagePlaces(storagePlaces.stream()
            .map(StoragePlaceRequestJson::convertJsonToEntity)
            .collect(Collectors.toList()))
        .build();
  }
}
