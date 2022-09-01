package br.com.mba.inventorycontrol.model.category;

import com.fasterxml.jackson.annotation.JsonInclude;
import javax.validation.constraints.NotNull;
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
public class CategoryRequestDto {

  private Integer id;

  @NotNull(message = "Name of the category cannot be null")
  private String name;

  public Category convertJsonToEntity() {
    return Category.builder()
        .id(this.id)
        .name(this.name)
        .build();
  }
}
