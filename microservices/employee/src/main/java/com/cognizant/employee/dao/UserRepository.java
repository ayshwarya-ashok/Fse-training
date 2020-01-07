package com.cognizant.employee.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.employee.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	 public User findByUserName(String userName);
	

}
