package br.com.fiap.inventorycontrol.controllers.jsons.response;

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
public class AddressResponseJson {

  private String zipCode;

  private String street;

  private String number;

  private String complementary;

  private String city;

  private String neighborhood;

  private String state;

  private String country;

  public AddressResponseJson convertJsonToEntity() {
    return AddressResponseJson.builder()
        .zipCode(this.zipCode)
        .street(this.street)
        .number(this.number)
        .complementary(this.complementary)
        .city(this.city)
        .neighborhood(this.neighborhood)
        .state(this.state)
        .country(this.country)
        .build();
  }
}
