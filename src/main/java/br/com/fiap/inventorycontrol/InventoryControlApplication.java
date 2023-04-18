package br.com.fiap.inventorycontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class InventoryControlApplication {

  public static void main(String[] args) {
    SpringApplication.run(InventoryControlApplication.class, args);
  }

}
