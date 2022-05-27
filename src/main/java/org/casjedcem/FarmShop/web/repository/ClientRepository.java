package org.casjedcem.FarmShop.web.repository;


import org.casjedcem.FarmShop.web.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByUserEmail(String email);
}
