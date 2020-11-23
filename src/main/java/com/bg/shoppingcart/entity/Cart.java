/**
 * 
 */
package com.bg.shoppingcart.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author bg
 *
 */
@Entity
public class Cart implements Serializable {

	private static final long serialVersionUID = -2152033415474959074L;
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CART_SQ")
	@SequenceGenerator(sequenceName = "cart_seq", allocationSize = 1, name = "CART_SQ")
	@Id
	private long id;
	private long itemId;
	private long sellerId;
	private String itemTitle;
	private double price;
	private double tax;
	
	/**
	 * 
	 */
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * @param id
	 * @param itemId
	 * @param sellerId
	 * @param itemTitle
	 * @param price
	 * @param tax
	 */
	public Cart(long id, long itemId, long sellerId, String itemTitle, double price, double tax) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.sellerId = sellerId;
		this.itemTitle = itemTitle;
		this.price = price;
		this.tax = tax;
	}
	
	

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * @return the itemId
	 */
	public long getItemId() {
		return itemId;
	}


	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(long itemId) {
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
