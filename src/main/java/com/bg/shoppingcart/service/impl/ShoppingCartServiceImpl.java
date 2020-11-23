/**
 * 
 */
package com.bg.shoppingcart.service.impl;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bg.shoppingcart.entity.Cart;
import com.bg.shoppingcart.exception.CartException;
import com.bg.shoppingcart.model.CartDTO;
import com.bg.shoppingcart.reppository.ShoppingCartRepository;
import com.bg.shoppingcart.service.ShoppingCartService;

/**
 * @author bg
 *
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	public String createCart(CartDTO cartDTO) throws CartException {
		System.out.println("ShoppingCartServiceImpl - createCart() - creating new cart");
		String cartId = null;
		try {
			Cart cart = mapCartDtoTOCart(cartDTO);			
			shoppingCartRepository.save(cart);
			
			cartId = Long.toString(cart.getId());
			
			System.out.println("ShoppingCartServiceImpl - createCart() - created cart with ref. "+cartId);
		} catch (Exception e) {
			System.out.println("ShoppingCartServiceImpl - createCart() - Exception Occured: "+e);
		    throw new CartException(e.getMessage());
		}
		return cartId;
	}
	
	public CartDTO getCartById(long id) throws CartException {
		
		Cart cart = shoppingCartRepository.findById(id).orElse(null);
		
		if(cart == null)
			throw new CartException("Card not found for cartId "+id);
		
		CartDTO cartDTO = null;
		
		if(cart != null) {
			System.out.println("ShoppingCartServiceImpl - getCartById() - return cart obj: "+cart.toString());
			
			try {
				ModelMapper modelMapper = new ModelMapper();
				cartDTO = modelMapper.map(cart, CartDTO.class); 
			} catch (Exception e) {
				System.out.println("ShoppingCartServiceImpl - getCartById() - Exception Occured: "+e);
			    throw new CartException(e.getMessage());
			}			
		}
		
		return cartDTO;
	}
	
	private Cart mapCartDtoTOCart(CartDTO cartDto) {
		Cart cart = new Cart();
		
		cart.setItemId(cartDto.getItemId());
		cart.setSellerId(cartDto.getSellerId());
		cart.setItemTitle(cartDto.getItemTitle());
		cart.setPrice(cartDto.getPrice());
		cart.setTax(cartDto.getTax());
		
		return cart;
	}
}
