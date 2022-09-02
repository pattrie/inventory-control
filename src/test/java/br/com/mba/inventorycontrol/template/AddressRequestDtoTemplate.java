package br.com.mba.inventorycontrol.template;

import br.com.mba.inventorycontrol.model.address.AddressRequestDto;

public class AddressRequestDtoTemplate {

  public static AddressRequestDto ADDRESS = AddressRequestDto.builder()
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
