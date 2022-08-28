package br.com.mba.inventorycontrol.repository;

import br.com.mba.inventorycontrol.model.productin.ProductIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInRepository extends JpaRepository<ProductIn, Integer> {

}
