package br.com.mba.inventorycontrol.template;

import static br.com.mba.inventorycontrol.template.AddressTemplate.ADDRESS;

import br.com.mba.inventorycontrol.model.supplier.Supplier;

public class SupplierTemplate {

  public static Supplier SUPPLIER = Supplier.builder()
      .id(189291)
      .name("name")
      .cnpj("23848483920")
      .address(ADDRESS)
      .email("email@email.com")
      .phone("1234-5678")
      .build();

}
