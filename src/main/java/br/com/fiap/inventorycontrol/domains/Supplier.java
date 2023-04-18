package br.com.fiap.inventorycontrol.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

  @Id
  private String id;

  private String name;

  private Address address;

  private String cnpj;

  private String phone;

  private String email;
}
