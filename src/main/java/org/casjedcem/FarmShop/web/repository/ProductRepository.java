/*
 * Copyright (c) 2022.
 * licebce MIT
 */

package org.casjedcem.FarmShop.web.repository;


import org.casjedcem.FarmShop.web.model.Category;
import org.casjedcem.FarmShop.web.model.Product;
import org.casjedcem.FarmShop.web.model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;




@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    public List<Product> findAllByCategory(Category category);
    public List<Product> findAllByCategoryAndNameLike(Category category, String name);
    public List<Product> findByNameContains(@Param("name") String name);
    public List<Product> findByProducerAndCategory(Producer producer, Category category);
    public List<Product> findByProducerAndAvailableIsTrue(Producer v);
    public List<Product> findByProducerAndPromotionIsTrue(Producer v);
    public List<Product> findByPromotionIsTrue();

    public List<Product> findByAvailableIsTrue();

}
