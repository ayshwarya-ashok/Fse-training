package com.cognizant.menuitemservice.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.menuitemservice.model.MenuItem;


@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer>{
	
	@Query(value = "select me_id, me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery, me_image from menu_item where me_date_of_launch < current_date and me_active = 'Yes'", nativeQuery = true)
	public Set<MenuItem> getMenuItemListCustomer();
	
	@Query("select m from MenuItem m")
	public Set<MenuItem> getMenuItemListAdmin();
	
	public MenuItem findMenuItemByItemId(int menuItemId);
	
}
