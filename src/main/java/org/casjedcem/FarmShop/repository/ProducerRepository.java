/*
 * Copyright (c) 2022.
 * licebce MIT
 */

package org.casjedcem.FarmShop.repository;


import org.casjedcem.FarmShop.model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;


@Repository
public interface ProducerRepository extends JpaRepository<Producer, Long> {




}
