package br.com.fiap.inventorycontrol.controllers.jsons.request;

import br.com.fiap.inventorycontrol.domains.Address;
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
public class AddressRequestJson {

  private Integer id;

  private String zipCode;

  private String street;

  private String number;

  private String complementary;

  private String city;

  private String neighborhood;

  private String state;

  private String country;

  public Address convertJsonToEntity() {
    return Address.builder()
        .id(this.id)
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
