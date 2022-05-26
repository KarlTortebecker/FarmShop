/*
 * Copyright (c) 2022.
 * licebce MIT
 */

package org.casjedcem.FarmShop.repository;

import org.casjedcem.FarmShop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {



}
