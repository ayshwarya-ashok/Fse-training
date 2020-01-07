package com.cognizant.menuitemservice.dto;

import java.util.List;
import java.util.Set;

import com.cognizant.menuitemservice.model.MenuItem;


public class CartDTO {
	private Set<MenuItem> menuItemList;
	private double total;
	
	public CartDTO() {
		super();
	}

	public CartDTO(Set<MenuItem> menuItemList, double total) {
		this.menuItemList = menuItemList;
		this.total = total;
	}

	public Set<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(Set<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menuItemList == null) ? 0 : menuItemList.hashCode());
		long temp;
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartDTO other = (CartDTO) obj;
		if (menuItemList == null) {
			if (other.menuItemList != null)
				return false;
		} else if (!menuItemList.equals(other.menuItemList))
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cart [menuItemList=" + menuItemList + ", total=" + total + "]";
	}

}
