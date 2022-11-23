package br.com.fiap.inventorycontrol.controllers.jsons.response;

import br.com.fiap.inventorycontrol.domains.Address;
import br.com.fiap.inventorycontrol.domains.StoragePlace;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
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
public class StoragePlaceResponseJson {

  private Address address;

  private Long quantity;

  @JsonFormat(pattern="yyyy-MM-dd")
  private LocalDateTime createdAt;

  public List<StoragePlaceResponseJson> convertEntityToJson(final List<StoragePlace> storagePlace) {
    return storagePlace.stream().map(storage ->
        StoragePlaceResponseJson.builder()
            .address(storage.getAddress())
            .quantity(storage.getQuantity())
            .createdAt(storage.getCreatedAt())
            .build()).collect(Collectors.toList());
  }
}
