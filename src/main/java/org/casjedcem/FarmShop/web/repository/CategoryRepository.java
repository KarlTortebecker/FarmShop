
package org.casjedcem.FarmShop.web.repository;

import org.casjedcem.FarmShop.web.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


    boolean findByName(String name);
}
