package com.cognizant.menuitemservice.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.cognizant.menuitemservice.model.MenuItem;

@Service
public interface MenuItemService {
	
	public Set<MenuItem> getMenuItemListCustomer();
	
	public MenuItem getMenuItem(int menuItemId);
	
	public Set<MenuItem> getMenuItemListAdmin();
	
	public void modifyMenuItem(MenuItem menuItem);
}
