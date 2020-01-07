package com.cognizant.menuitemservice.controller;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.menuitemservice.dto.CartDTO;
import com.cognizant.menuitemservice.exception.CartEmptyException;
import com.cognizant.menuitemservice.model.MenuItem;
import com.cognizant.menuitemservice.service.CartService;


@RestController
@RequestMapping("/cart")
public class CartController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

	@Autowired
	CartService cartService;

	@PostMapping("/{user}/{menuItemId}")
	public void addCartItem(@PathVariable String user, @PathVariable int menuItemId) {
		LOGGER.info("Start");
		cartService.addCartItem(user, menuItemId);
		LOGGER.info("End");
	}

	@GetMapping("/{user}")
	public CartDTO getAllCartItems(@PathVariable String user) throws CartEmptyException {
		LOGGER.info("Start");
		Set<MenuItem> menuItemList = cartService.getAllCartItems(user);
		double cartTotal = cartService.getCartTotal(user);
		CartDTO cartDto = new CartDTO(menuItemList, cartTotal);
		LOGGER.info("End");
		return cartDto;

	}

	@DeleteMapping("/{user}/{menuItemId}")
	public void removeCartItem(@PathVariable String user, @PathVariable int menuItemId) {
		LOGGER.info("Start");
		cartService.removeCartItem(user, menuItemId);
		LOGGER.info("End");
	}
}
