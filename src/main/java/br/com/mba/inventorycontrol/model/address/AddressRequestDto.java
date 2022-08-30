package br.com.mba.inventorycontrol.model.address;

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
public class AddressRequestDto {

  private Long id;

  private String zipcode;

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
        .zipcode(this.zipcode)
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
