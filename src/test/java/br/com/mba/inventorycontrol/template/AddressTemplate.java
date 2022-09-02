package br.com.mba.inventorycontrol.template;

import br.com.mba.inventorycontrol.model.address.Address;

public class AddressTemplate {

  public static Address ADDRESS = Address.builder()
      .id(189291)
      .street("Rua")
      .number("123")
      .zipCode("01021010")
      .state("Pederneiras")
      .neighborhood("Uva")
      .city("São Paulo")
      .country("Brasil")
      .complementary("complementary")
      .build();

}
