package br.com.fiap.inventorycontrol.controllers.jsons.request;

import br.com.fiap.inventorycontrol.domains.Supplier;
import io.swagger.annotations.ApiModelProperty;
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
public class SupplierRequestJson {

  @ApiModelProperty(notes = "Supplier Id - add if it already exists otherwise add the another infos.")
  private String id;

  @ApiModelProperty(notes = "Supplier name.")
  private String name;

  @ApiModelProperty(notes = "Address.")
  private AddressRequestJson address;

  @ApiModelProperty(notes = "CNPJ.")
  private String cnpj;

  @ApiModelProperty(notes = "Phone number.")
  private String phone;

  @ApiModelProperty(notes = "Email.")
  private String email;

  public Supplier convertJsonToEntity() {
    return Supplier.builder()
        .id(this.id)
        .name(this.name)
        .address(this.address == null ? null : this.address.convertJsonToEntity())
        .cnpj(this.cnpj)
        .phone(this.phone)
        .email(this.email)
        .build();
  }
}
