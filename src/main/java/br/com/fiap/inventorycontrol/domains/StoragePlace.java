package br.com.fiap.inventorycontrol.domains;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StoragePlace {

  @Id
  private String id;

  private Address address;

  private Long quantity;

  @Builder.Default
  private LocalDateTime createdAt = LocalDateTime.now();

  @LastModifiedDate
  private LocalDateTime updatedAt;
}
