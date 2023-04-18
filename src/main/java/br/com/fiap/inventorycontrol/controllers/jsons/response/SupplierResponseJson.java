package br.com.fiap.inventorycontrol.controllers.jsons.response;

import br.com.fiap.inventorycontrol.domains.Supplier;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierResponseJson {

  private String name;

  private AddressResponseJson address;

  private String cnpj;

  private String phone;

  private String email;

  public SupplierResponseJson convertEntityToJson(final Supplier supplier) {

    return SupplierResponseJson.builder()
        .name(supplier.getName())
        .address(supplier.getAddress() == null ? null : this.address.convertJsonToEntity())
        .cnpj(supplier.getCnpj())
        .phone(supplier.getPhone())
        .email(supplier.getEmail())
        .build();
  }
}
