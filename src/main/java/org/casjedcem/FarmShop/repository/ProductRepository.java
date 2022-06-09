/*
 * Copyright (c) 2022.
 * licebce MIT
 */

package org.casjedcem.Farmshop.repository;


import org.casjedcem.Farmshop.model.Category;
import org.casjedcem.Farmshop.model.Product;
import org.casjedcem.Farmshop.model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;




@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    public List<Product> findAllByCategory_Id(int id);
    public List<Product> findAllByCategoryAndNameLike(Category category, String name);
    public List<Product> findByNameContains(@Param("name") String name);
    public List<Product> findByProducerAndCategory(Producer producer, Category category);
    public List<Product> findByProducerAndIsAvailableIsTrue(Producer v);
    public List<Product> findByProducerAndInPromotionIsTrue(Producer v);
    public List<Product> findByInPromotionIsTrue();

    public List<Product> findByIsAvailableIsTrue();

    List<Product> findByNameContainingIgnoreCase(String name);

}
