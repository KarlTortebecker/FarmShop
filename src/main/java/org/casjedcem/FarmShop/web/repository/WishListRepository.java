package org.casjedcem.FarmShop.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.casjedcem.FarmShop.web.model.WishList;

@Repository
public interface WishListRepository extends JpaRepository<WishList,Long>{
	WishList findBySessionToken(String sessionToken);
}
