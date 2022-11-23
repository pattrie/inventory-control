package br.com.fiap.inventorycontrol.controllers.jsons.request;

import br.com.fiap.inventorycontrol.domains.Category;
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
public class CategoryRequestJson {

  @ApiModelProperty(notes = "Category Id - add if it already exists otherwise add the name.")
  private String id;

  @ApiModelProperty(notes = "Add name if new category.")
  private String name;

  public Category convertJsonToEntity() {
    return Category.builder()
        .id(this.id)
        .name(this.name)
        .build();
  }
}
