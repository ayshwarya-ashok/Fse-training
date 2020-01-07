package com.cognizant.menuitemservice.service;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.menuitemservice.exception.CartEmptyException;
import com.cognizant.menuitemservice.model.MenuItem;
import com.cognizant.menuitemservice.model.Users;
import com.cognizant.menuitemservice.repository.MenuItemRepository;
import com.cognizant.menuitemservice.repository.UserRepository;



@Service
public class CartServiceImpl implements CartService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CartServiceImpl.class);
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	MenuItemRepository menuItemRepository;

	@Override
	public void addCartItem(String userName, int menuItemId) {
		LOGGER.info("Start");
		Users user = userRepository.findByUserName(userName);
		MenuItem menuItem = menuItemRepository.findMenuItemByItemId(menuItemId);
		Set<MenuItem> menuItemList = user.getMenuItemList();
		menuItemList.add(menuItem);
		user.setMenuItemList(menuItemList);
		userRepository.save(user);
		LOGGER.info("End");
	}

	@Override
	public Set<MenuItem> getAllCartItems(String userName) throws CartEmptyException {
		LOGGER.info("Start");
		Users user = userRepository.getMenuItems(userName);
		if(user.getMenuItemList().isEmpty()) {
			throw new CartEmptyException("Cart is Empty");
		}
		LOGGER.info("End");
		return user.getMenuItemList();
	}

	@Override
	public void removeCartItem(String userName, int menuItemId) {
		LOGGER.info("Start");
		boolean removeItemFlag = false;
		Users user = userRepository.findByUserName(userName);
		Set<MenuItem> menuItemList = user.getMenuItemList();
		for(MenuItem item: menuItemList) {
			if(item.getItemId() == menuItemId) {
				removeItemFlag = menuItemList.remove(item);
				break;
			}
		}
		if(removeItemFlag) {
			user.setMenuItemList(menuItemList);
			userRepository.save(user);
		}
		LOGGER.info("End");
	}

	@Override
	public double getCartTotal(String userName) {
		double cartTotal = userRepository.getCartTotal(userName);
		return cartTotal;
	}

}
