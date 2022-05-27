package org.casjedcem.FarmShop.web.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.casjedcem.FarmShop.web.model.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {

}
