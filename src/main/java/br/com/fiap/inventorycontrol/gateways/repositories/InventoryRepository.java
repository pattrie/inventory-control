package br.com.fiap.inventorycontrol.gateways.repositories;

import br.com.fiap.inventorycontrol.domains.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventoryRepository extends MongoRepository<Product, String> {

}
