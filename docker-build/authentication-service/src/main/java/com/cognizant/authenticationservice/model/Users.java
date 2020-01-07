package com.cognizant.authenticationservice.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "us_id")
	int id;
	@NotNull
	@Size(min = 5, max = 30, message = "Length should be min of 5 and max of 20 characters")
	@Column(name = "us_name")
	private String userName;
	@NotNull
	@Size(min = 5, max = 30, message = "Length should be min of 5 and max of 20 characters")
	@Column(name = "us_first_name")
	private String firstName;
	@NotNull
	@Size(min = 1, max = 30, message = "Length should be min of 1 and max of 20 characters")
	@Column(name = "us_last_name")
	private String lastName;
	@NotNull
	@Size(min = 3, message = "Length should be min of 8 characters")
	@Column(name = "us_password")
	private String password;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "cart", 
	   joinColumns = @JoinColumn(name = "ct_us_id"), 
	   inverseJoinColumns = @JoinColumn(name = "ct_pr_id"))
	private Set<MenuItem> menuItemList;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", 
			   joinColumns = @JoinColumn(name = "ur_us_id"), 
			   inverseJoinColumns = @JoinColumn(name = "ur_ro_id"))
	private Set<Role> roleList;
	
	public Users() {
		
	}
	public Users(int id, String userName, String firstName, String lastName, String password, Set<MenuItem> menuItemList, Set<Role> roleList) {
		
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.menuItemList = menuItemList;
		this.roleList = roleList;
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
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<MenuItem> getMenuItemList() {
		return menuItemList;
	}
	public void setMenuItemList(Set<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}
	public Set<Role> getRoleList() {
		return roleList;
	}
	public void setRoleList(Set<Role> roleList) {
		this.roleList = roleList;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", menuItemList=" + menuItemList + ", roleList=" + roleList + "]";
	}
	

}
