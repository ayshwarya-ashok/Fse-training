package com.cognizant.DiagnosticMedicare.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "us_id")
	private int id;

	@Column(name = "us_name", unique = true)
	private String username;

	@Column(name = "us_password")
	private String password;

	@Column(name = "us_approve")
	private String approve;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ro_id")
	private Role role;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(int id, String username, String password, String approve, Role role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.approve = approve;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", approve=" + approve
				+ ", role=" + role + "]";
	}

}