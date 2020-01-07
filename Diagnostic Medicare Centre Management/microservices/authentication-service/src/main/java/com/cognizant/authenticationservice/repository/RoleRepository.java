package com.cognizant.authenticationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.authenticationservice.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
   Role findById(int id);
}
