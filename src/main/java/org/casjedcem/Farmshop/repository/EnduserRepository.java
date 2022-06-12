package org.casjedcem.Farmshop.repository;

import org.casjedcem.Farmshop.model.Enduser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnduserRepository extends JpaRepository<Enduser, Long> {


    Optional<Enduser> findEnduserByEmail(String email);


}
