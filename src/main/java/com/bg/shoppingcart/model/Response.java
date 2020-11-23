/**
 * 
 */
package com.bg.shoppingcart.model;

/**
 * @author bg
 *
 */
public class Response {
	private String cartId;

	/**
	 * 
	 */
	public Response() {
		super();
	}

	/**
	 * @param cartId
	 */
	public Response(String cartId) {
		super();
		this.cartId = cartId;
	}

	/**
	 * @return the cartId
	 */
	public String getCartId() {
		return cartId;
	}

	/**
	 * @param cartId the cartId to set
	 */
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	@Override
	public String toString() {
		return "Response [cartId=" + cartId + "]";
	}
		
}
