
package org.casjedcem.Farmshop.repository;
import org.casjedcem.Farmshop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {


    boolean findByName(String name);

}
