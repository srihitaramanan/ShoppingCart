package com.bg.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bg.shoppingcart.exception.CartException;
import com.bg.shoppingcart.model.CartDTO;
import com.bg.shoppingcart.model.Response;
import com.bg.shoppingcart.service.ShoppingCartService;

/**
 * @author bg
 *
 */
@RestController
@RequestMapping(path="${cart.api.version}")
public class ShoppingCartController {
	
	@Autowired
	private ShoppingCartService shoppingCartService;
		
	@PostMapping(path = "/createCart")
	public ResponseEntity<Response> createCart(@RequestBody CartDTO cartDto) throws CartException {
		System.out.println("ShoppingCartController - createCart() - createCart api invoked");
		String cartId = null;
		
		if(cartDto == null || cartDto.getItemId() == 0 || cartDto.getSellerId() == 0) {
			throw new CartException("Request missing");
		}
		
		cartId = shoppingCartService.createCart(cartDto);
		
		Response response = new Response();
		response.setCartId(cartId);
		
		return new ResponseEntity<Response> (response, HttpStatus.OK);
	}
	
	@GetMapping(path = "/cart/{cartid}")
	public ResponseEntity<CartDTO> getCart(@PathVariable(value="cartid") Long id) throws CartException {
		System.out.println("ShoppingCartController - getCart() - getCart invoked with id: "+id);
		
		if(id != null) {
			return new ResponseEntity<CartDTO> (shoppingCartService.getCartById(id), HttpStatus.OK);
		}
		return null;
	}
}
