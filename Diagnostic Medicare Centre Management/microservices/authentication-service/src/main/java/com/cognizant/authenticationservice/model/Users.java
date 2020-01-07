package com.cognizant.authenticationservice.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "all_users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "all_us_id")
	private int id;

	@Column(name = "all_us_name", unique = true)
	private String userName;
	
	@Column(name = "all_us_first_name")
	private String firstName;
	
	@Column(name = "all_us_password")
	private String password;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ro_id")
	private Role role;

	public Users() {

	}

	public Users(int id, String userName, String firstName, String password, Role role) {

		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", password=" + password + ", role=" + role + "]";
	}

}
