package com.cognizant.DiagnosticMedicare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.DiagnosticMedicare.model.Role;
import com.cognizant.DiagnosticMedicare.model.Users;

public interface RoleRepository extends JpaRepository<Role, Integer> {
   Role findById(int id);
}
