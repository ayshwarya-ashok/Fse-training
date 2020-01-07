package com.cognizant.menuitemservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.menuitemservice.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

	public Users findByUserName(String userName);

	@Query("select u from Users u where u.userName = ?1")
	public Users getMenuItems(String userName);

	@Query(value = "select sum(me_price) from menu_item inner join cart on ct_pr_id = me_id inner join user on ct_us_id = us_id where us_name = ?1", nativeQuery = true)
	public double getCartTotal(String userName);
	
}
