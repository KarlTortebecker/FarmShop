/*
 * Copyright (c) 2022.
 * licebce MIT
 */

package org.casjedcem.Farmshop.repository;


import org.casjedcem.Farmshop.model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProducerRepository extends JpaRepository<Producer, Long> {




}
