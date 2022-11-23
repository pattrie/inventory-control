package br.com.fiap.inventorycontrol.controllers.jsons.response;

import br.com.fiap.inventorycontrol.domains.Category;
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
public class CategoryResponseJson {

  private String name;

  public CategoryResponseJson convertEntityToJson(final Category category) {
    return CategoryResponseJson.builder()
        .name(category.getName())
        .build();
  }
}
