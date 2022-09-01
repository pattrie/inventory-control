package br.com.mba.inventorycontrol.model.supplier;

import br.com.mba.inventorycontrol.model.address.Address;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tb_supplier")
public class Supplier {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String name;

  @JoinColumn(name = "id_address", referencedColumnName = "id")
  @ManyToOne(targetEntity = Address.class)
  private Address address;

  private String cnpj;

  private String phone;

  private String email;
}
