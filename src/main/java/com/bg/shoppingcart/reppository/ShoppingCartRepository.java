
package com.bg.shoppingcart.reppository;

import org.springframework.data.repository.CrudRepository;

import com.bg.shoppingcart.entity.Cart;

public interface ShoppingCartRepository extends CrudRepository<Cart, Long>{
	
}
