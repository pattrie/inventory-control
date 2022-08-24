package br.com.mba.inventorycontrol.repository;

import br.com.mba.inventorycontrol.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
