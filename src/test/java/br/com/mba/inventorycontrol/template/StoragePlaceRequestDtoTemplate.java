package br.com.mba.inventorycontrol.template;

import static br.com.mba.inventorycontrol.template.AddressRequestDtoTemplate.ADDRESS;

import br.com.mba.inventorycontrol.model.storageplace.StoragePlaceRequestDto;

public class StoragePlaceRequestDtoTemplate {

  public static StoragePlaceRequestDto STORAGE_PLACE = StoragePlaceRequestDto.builder()
      .id(189291)
      .address(ADDRESS)
      .quantity(10L)
      .build();

}
