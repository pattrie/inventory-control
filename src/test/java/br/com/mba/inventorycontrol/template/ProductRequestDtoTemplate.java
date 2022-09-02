package br.com.mba.inventorycontrol.template;

import static br.com.mba.inventorycontrol.template.CategoryRequestDtoTemplate.CATEGORY;
import static br.com.mba.inventorycontrol.template.StoragePlaceRequestDtoTemplate.STORAGE_PLACE;
import static br.com.mba.inventorycontrol.template.SupplierRequestDtoTemplate.SUPPLIER;

import br.com.mba.inventorycontrol.model.product.ProductRequestDto;
import java.math.BigDecimal;
import java.util.List;

public class ProductRequestDtoTemplate {

  public static ProductRequestDto PRODUCT = ProductRequestDto.builder()
      .name("name")
      .sku("sku")
      .color("color")
      .description("description")
      .image("image")
      .unitaryValue(new BigDecimal("30.00"))
      .category(CATEGORY)
      .supplier(SUPPLIER)
      .storagePlaces(List.of(STORAGE_PLACE))
      .build();

}
