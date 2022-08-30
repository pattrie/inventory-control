package br.com.mba.inventorycontrol.repository;

import br.com.mba.inventorycontrol.model.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
