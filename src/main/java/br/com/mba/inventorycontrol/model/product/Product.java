package br.com.mba.inventorycontrol.model.product;

import br.com.mba.inventorycontrol.model.category.Category;
import br.com.mba.inventorycontrol.model.storageplace.StoragePlace;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Builder
@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_product")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String sku;

  @Column(nullable = false)
  private String name;

  private String description;

  private String image;

  private String color;

  @Column(nullable = false)
  private int quantity;

  @Column(name = "unitary_value")
  private BigDecimal unitaryValue;

  @JoinColumn(name = "id_category", referencedColumnName = "id")
  @ManyToOne(targetEntity = Category.class)
  private Integer idCategory;

  @Column(name = "id_supplier")
  private Integer idSupplier;

  @JoinColumn(name = "id_storage_place", referencedColumnName = "id")
  @ManyToOne(targetEntity = StoragePlace.class)
  private Integer idStoragePlace;

  private boolean active = true;

  @CreationTimestamp
  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;
}
