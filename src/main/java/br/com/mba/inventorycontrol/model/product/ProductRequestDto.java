package br.com.mba.inventorycontrol.model.product;

import br.com.mba.inventorycontrol.model.category.Category;
import br.com.mba.inventorycontrol.model.storageplace.StoragePlace;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductRequestDto {

  @NotNull(message = "Name of the product cannot be null")
  private String name;

  private String description;

  private String image;

  private String color;

  @NotNull(message = "Quantity of the product cannot be null")
  private Integer quantity;

  @NotNull(message = "Unitary value cannot be null")
  private BigDecimal unitaryValue;

  @NotNull(message = "Id category cannot be null")
  private Category idCategory;

  @NotNull(message = "Id supplier cannot be null")
  private Integer idSupplier;

  @NotNull(message = "Storage place cannot be null")
  private Collection<StoragePlace> storagePlace;

  public Product convertJsonToEntity() {
    return Product.builder()
        .name(this.name)
        .description(this.description)
        .image(this.image)
        .color(this.color)
        .quantity(this.quantity)
        .unitaryValue(this.unitaryValue)
        .idSupplier(this.idSupplier)
        .storagePlace(this.storagePlace)
        .createdAt(LocalDateTime.now())
        .build();
  }
}
