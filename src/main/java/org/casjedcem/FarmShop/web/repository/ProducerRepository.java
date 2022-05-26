/*
 * Copyright (c) 2022.
 * licebce MIT
 */

package org.casjedcem.FarmShop.web.repository;


import org.casjedcem.FarmShop.web.model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProducerRepository extends JpaRepository<Producer, Long> {




}
