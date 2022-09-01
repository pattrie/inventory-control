package br.com.mba.inventorycontrol.repository;

import br.com.mba.inventorycontrol.model.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
