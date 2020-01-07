package com.cognizant.menuitemservice.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.cognizant.menuitemservice.exception.CartEmptyException;
import com.cognizant.menuitemservice.model.MenuItem;

@Service
public interface CartService {
	
	public void addCartItem(String user, int menuItemId);
	
	public Set<MenuItem> getAllCartItems(String user) throws CartEmptyException;

	public void removeCartItem(String userName, int menuItemId) ;
	
	public double getCartTotal(String userName);
}
