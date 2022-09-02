package br.com.mba.inventorycontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class InventoryControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryControlApplication.class, args);
	}

}
