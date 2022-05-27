package org.casjedcem.FarmShop.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.casjedcem.FarmShop.web.model.WishListItem;

@Repository
public interface WishListItemRepository extends JpaRepository<WishListItem,Long> {

}
