package br.com.mba.inventorycontrol.repository;

import br.com.mba.inventorycontrol.model.supplier.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}
