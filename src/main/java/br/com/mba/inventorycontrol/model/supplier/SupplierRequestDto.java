package br.com.mba.inventorycontrol.model.supplier;

import br.com.mba.inventorycontrol.model.address.AddressRequestDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.Column;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupplierRequestDto {

  private Integer id;

  @Column(nullable = false)
  private String name;

  private AddressRequestDto address;

  private String cnpj;

  private String phone;

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
