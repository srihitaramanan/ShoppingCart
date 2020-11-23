/**
 * 
 */
package com.bg.shoppingcart.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * @author bg
 *
 */
@Component
public class CartDTO implements Serializable {

	private static final long serialVersionUID = -2152033415474959074L;
	
	private long itemId;
	private long sellerId;
	private String itemTitle;
	private double price;
	private double tax;
	
	/**
	 * 
	 */
	public CartDTO() {
		
	}

	/**
	 * @param itemId
	 * @param sellerId
	 * @param itemTitle
	 * @param price
	 * @param tax
	 */
	public CartDTO(long itemId, long sellerId, String itemTitle, double price, double tax) {
		super();
		this.itemId = itemId;
		this.sellerId = sellerId;
		this.itemTitle = itemTitle;
		this.price = price;
		this.tax = tax;
	}
	
	
	/**
	 * @return the itemId
	 */
	public long getItemId() {
		return itemId;
	}

	/**
	 * @param itemid the itemid to set
	 */
	public void setItemid(long itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the sellerId
	 */
	public long getSellerId() {
		return sellerId;
	}

	/**
	 * @param sellerId the sellerId to set
	 */
	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
	}

	/**
	 * @return the itemTitle
	 */
	public String getItemTitle() {
		return itemTitle;
	}

	/**
	 * @param itemTitle the itemTitle to set
	 */
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the tax
	 */
	public double getTax() {
		return tax;
	}

	/**
	 * @param tax the tax to set
	 */
	public void setTax(double tax) {
		this.tax = tax;
	}

	@Override
	public String toString() {
		return "Cart [itemId=" + itemId + ", sellerId=" + sellerId + ", itemTitle=" + itemTitle + ", price=" + price
				+ ", tax=" + tax + "]";
	}
}
