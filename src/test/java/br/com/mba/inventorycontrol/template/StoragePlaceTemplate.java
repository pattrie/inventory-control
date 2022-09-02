package br.com.mba.inventorycontrol.template;

import static br.com.mba.inventorycontrol.template.AddressTemplate.ADDRESS;
import static br.com.mba.inventorycontrol.template.CategoryTemplate.CATEGORY;
import static br.com.mba.inventorycontrol.template.SupplierTemplate.SUPPLIER;

import br.com.mba.inventorycontrol.model.address.Address;
import br.com.mba.inventorycontrol.model.product.Product;
import br.com.mba.inventorycontrol.model.storageplace.StoragePlace;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class StoragePlaceTemplate {

  public static StoragePlace STORAGE_PLACE = StoragePlace.builder()
      .id(189291)
      .address(ADDRESS)
      .quantity(10L)
      .createdAt(LocalDateTime.now())
      .build();

}
