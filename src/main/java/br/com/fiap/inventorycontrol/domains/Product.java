package br.com.fiap.inventorycontrol.domains;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

@Builder
@Getter
@Setter
@ToString
@With
@NoArgsConstructor
@AllArgsConstructor
public class Product {

  @Id
  private String id;

  private String sku;

  private String name;

  private String description;

  private String image;

  private String color;

  private Long quantity;

  private BigDecimal unitaryValue;

  private Category category;

  private Supplier supplier;

  private List<StoragePlace> storagePlaces;

  @Builder.Default
  private boolean active = true;

  @Builder.Default
  private LocalDateTime createdAt = LocalDateTime.now();

  @LastModifiedDate
  private LocalDateTime updatedAt;
}
