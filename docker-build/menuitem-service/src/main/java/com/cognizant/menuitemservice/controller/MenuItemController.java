package com.cognizant.menuitemservice.controller;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.menuitemservice.model.MenuItem;
import com.cognizant.menuitemservice.service.AppUserDetailsService;
import com.cognizant.menuitemservice.service.MenuItemService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/menu-items")
public class MenuItemController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

	Set<MenuItem> menuItemList = null;
	@Autowired
	MenuItemService menuItemService;
	@Autowired
	AppUserDetailsService appUserDetailsService;

	@GetMapping("")
	Set<MenuItem> getAllMenuItems() {
		LOGGER.info("Start");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();
		if (user != "anonymousUser") {
			UserDetails userDetails = appUserDetailsService.loadUserByUsername(user);
			String role = userDetails.getAuthorities().toArray()[0].toString();
			if (role.equals("admin")) {
				menuItemList = menuItemService.getMenuItemListAdmin();

			} else {
				menuItemList = menuItemService.getMenuItemListCustomer();
			}
		} else {
			menuItemList = menuItemService.getMenuItemListCustomer();
		}
		LOGGER.info("End");
		return menuItemList;
	}

	@GetMapping("/{menuItemId}")
	MenuItem getMenuItem(@PathVariable int menuItemId) {
		LOGGER.info("Start");
		LOGGER.info("End");
		return menuItemService.getMenuItem(menuItemId);

	}

	@PutMapping("")
	void modifyMenuItem(@RequestBody MenuItem menuItem) {
		LOGGER.info("Start");
		menuItemService.modifyMenuItem(menuItem);
		LOGGER.info("End");
	}
}
