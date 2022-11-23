package br.com.fiap.inventorycontrol.controllers.jsons.request;

import br.com.fiap.inventorycontrol.domains.StoragePlace;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoragePlaceRequestJson {

  @ApiModelProperty(notes = "Storage Place Id - add if it already exists otherwise add the another infos.")
  private String id;

  @ApiModelProperty(notes = "Quantity of products.", required = true)
  @Positive
  @NotNull(message = "Quantity cannot be null")
  private Long quantity;

  @ApiModelProperty(notes = "Address of the storage place.", required = true)
  @NotNull(message = "Address of the storage place cannot be null")
  private AddressRequestJson address;

  public StoragePlace convertJsonToEntity() {
    return StoragePlace.builder()
        .id(this.id)
        .address(this.address.convertJsonToEntity())
        .quantity(this.quantity)
        .build();
  }
}
