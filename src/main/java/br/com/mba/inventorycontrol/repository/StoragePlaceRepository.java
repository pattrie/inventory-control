package br.com.mba.inventorycontrol.repository;

import br.com.mba.inventorycontrol.model.storageplace.StoragePlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoragePlaceRepository extends JpaRepository<StoragePlace, Integer> {

}
