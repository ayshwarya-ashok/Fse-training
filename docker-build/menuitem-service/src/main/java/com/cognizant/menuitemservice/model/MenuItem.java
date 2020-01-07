package com.cognizant.menuitemservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu_item")
public class MenuItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "me_id")
	int itemId;
	@Column(name = "me_name")
	String itemName;
	@Column(name = "me_price", 
			columnDefinition = "DECIMAL(8,2)")
	float itemPrice;
	@Column(name = "me_active")
	String itemActive;
	@Column(name = "me_date_of_launch")
	Date dateOfLaunch;
	@Column(name = "me_category")
	String itemCategory;
	@Column(name = "me_free_delivery")
	String freeDelivery;
	@Column(name = "me_image")
	String itemImage;
	
	public MenuItem() {

	}

	public MenuItem(int itemId, String itemName, float itemPrice, String itemActive, Date dateOfLaunch,
			String itemCategory, String freeDelivery, String itemImage) {
		
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemActive = itemActive;
		this.dateOfLaunch = dateOfLaunch;
		this.itemCategory = itemCategory;
		this.freeDelivery = freeDelivery;
		this.itemImage = itemImage;
		
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemActive() {
		return itemActive;
	}

	public void setItemActive(String itemActive) {
		this.itemActive = itemActive;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getFreeDelivery() {
		return freeDelivery;
	}

	public void setFreeDelivery(String freeDelivery) {
		this.freeDelivery = freeDelivery;
	}

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}


	@Override
	public String toString() {
		return "MenuItem [itemId=" + itemId + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemActive="
				+ itemActive + ", dateOfLaunch=" + dateOfLaunch + ", itemCategory=" + itemCategory + ", freeDelivery="
				+ freeDelivery + ", itemImage=" + itemImage + "]";
	}

	
}
