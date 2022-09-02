package br.com.mba.inventorycontrol.template;

import static br.com.mba.inventorycontrol.template.CategoryTemplate.CATEGORY;
import static br.com.mba.inventorycontrol.template.StoragePlaceTemplate.STORAGE_PLACE;
import static br.com.mba.inventorycontrol.template.SupplierTemplate.SUPPLIER;

import br.com.mba.inventorycontrol.model.product.Product;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ProductTemplate {

  public static Product PRODUCT = Product.builder()
      .id(123456)
      .name("name")
      .sku("sku")
      .color("color")
      .description("description")
      .image("image")
      .quantity(10L)
      .unitaryValue(new BigDecimal("30.00"))
      .category(CATEGORY)
      .createdAt(LocalDateTime.now())
      .supplier(SUPPLIER)
      .storagePlaces(List.of(STORAGE_PLACE))
      .build();

}
