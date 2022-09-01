package br.com.mba.inventorycontrol.model.storageplace;

import br.com.mba.inventorycontrol.model.address.AddressRequestDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
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
public class StoragePlaceRequestDto {

  private Integer id;

  @Positive
  @NotNull(message = "Quantity cannot be null")
  private Long quantity;

  @NotNull(message = "Address of the storage place cannot be null")
  private AddressRequestDto address;

  public StoragePlace convertJsonToEntity() {
    return StoragePlace.builder()
        .id(this.id)
        .address(this.address.convertJsonToEntity())
        .quantity(this.quantity)
        .build();
  }
}
