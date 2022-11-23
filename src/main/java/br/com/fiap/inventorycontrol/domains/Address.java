package br.com.fiap.inventorycontrol.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Address {

  private Integer id;

  private String zipCode;

  private String street;

  private String number;

  private String complementary;

  private String city;

  private String neighborhood;

  private String state;

  private String country;
}
