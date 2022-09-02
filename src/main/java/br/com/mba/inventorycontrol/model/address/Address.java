package br.com.mba.inventorycontrol.model.address;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_address")
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String zipCode;

  @Column(nullable = false)
  private String street;

  @Column(nullable = false)
  private String number;

  private String complementary;

  @Column(nullable = false)
  private String city;

  @Column(nullable = false)
  private String neighborhood;

  @Column(nullable = false)
  private String state;

  @Column(nullable = false)
  private String country;

}
