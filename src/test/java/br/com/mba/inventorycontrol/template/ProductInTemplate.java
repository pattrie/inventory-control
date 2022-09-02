package br.com.mba.inventorycontrol.template;

import br.com.mba.inventorycontrol.model.productin.ProductIn;
import java.time.LocalDateTime;

public class ProductInTemplate {

  public static ProductIn PRODUCT_IN = ProductIn.builder()
      .id(189291)
      .idProduct(177897)
      .quantity(10L)
      .dateIn(LocalDateTime.now())
      .build();

}
