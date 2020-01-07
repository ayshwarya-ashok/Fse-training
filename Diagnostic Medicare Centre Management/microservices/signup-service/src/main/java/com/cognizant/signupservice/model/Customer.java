package com.cognizant.signupservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cus_id",
			columnDefinition = "INT(10)")
	long customerId;
	@Column(name = "cus_user_name")
	String userName;
	@Column(name = "cus_first_name")
	String firstName;
	@Column(name = "cus_last_name")
	String lastName;
	@Column(name = "cus_age")
	int age;
	@Column(name = "cus_gender")
	String gender;
	@Column(name = "cus_dob")
	String dateOfBirth;
	@Column(name = "cus_contact")
	long contactNumber;
	@Column(name = "cus_alt_contact")
	long altContactNumber;
	@Column(name = "cus_email")
	String emailId;
	@Column(name = "cus_password")
	String password;
	@Column(name = "cus_address_line_1")
	String addressLine_1;
	@Column(name = "cus_address_line_2")
	String addressLine_2;
	@Column(name = "cus_city")
	String city;
	@Column(name = "cus_state")
	String state;
	@Column(name = "cus_zip_code")
	String zipCode;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "all_us_id")
	private Users user;

	public Customer() {
		super();
	}

	public Customer(long customerId, String userName, String firstName, String lastName, int age, String gender,
			String dateOfBirth, long contactNumber, long altContactNumber, String emailId, String password,
			String addressLine_1, String addressLine_2, String city, String state, String zipCode, Users user) {
		super();
		this.customerId = customerId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.contactNumber = contactNumber;
		this.altContactNumber = altContactNumber;
		this.emailId = emailId;
		this.password = password;
		this.addressLine_1 = addressLine_1;
		this.addressLine_2 = addressLine_2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.user = user;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public long getAltContactNumber() {
		return altContactNumber;
	}

	public void setAltContactNumber(long altContactNumber) {
		this.altContactNumber = altContactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddressLine_1() {
		return addressLine_1;
	}

	public void setAddressLine_1(String addressLine_1) {
		this.addressLine_1 = addressLine_1;
	}

	public String getAddressLine_2() {
		return addressLine_2;
	}

	public void setAddressLine_2(String addressLine_2) {
		this.addressLine_2 = addressLine_2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", userName=" + userName + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", age=" + age + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
				+ ", contactNumber=" + contactNumber + ", altContactNumber=" + altContactNumber + ", emailId=" + emailId
				+ ", password=" + password + ", addressLine_1=" + addressLine_1 + ", addressLine_2=" + addressLine_2
				+ ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + ", user=" + user + "]";
	}
	
}
