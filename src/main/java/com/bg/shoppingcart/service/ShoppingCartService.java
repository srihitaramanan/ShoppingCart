/**
 * 
 */
package com.bg.shoppingcart.service;

import com.bg.shoppingcart.exception.CartException;
import com.bg.shoppingcart.model.CartDTO;

/**
 * @author bg
 *
 */

public interface ShoppingCartService {
	public String createCart(CartDTO cartDTO) throws CartException;	
	public CartDTO getCartById(long id) throws CartException;
}
