package com.cognizant.DiagnosticMedicare.model;

import java.util.Arrays;

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
@Table(name = "agent")
public class Agent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ag_id")
	private int id;

	@Column(name = "ag_user_name", unique = true)
	private String username;

	@Column(name = "ag_first_name")
	private String firstName;

	@Column(name = "ag_last_name")
	private String lastName;

	@Column(name = "ag_age")
	private int age;

	@Column(name = "ag_gender")
	private String gender;

	@Column(name = "ag_dob")
	private String dateOfBirth;

	@Column(name = "ag_contact")
	private long contactNumber;

	@Column(name = "ag_alt_contact")
	private long altContactNumber;

	@Column(name = "ag_email")
	private String emailId;

	@Column(name = "ag_password")
	private String password;

	@Column(name = "ag_security_question")
	private String securityQuestion;

	@Column(name = "ag_security_answer")
	private String securityAnswer;

	@Column(name = "ag_address_line_1")
	private String addressLineOne;

	@Column(name = "ag_address_line_2")
	private String addressLineTwo;

	@Column(name = "ag_city")
	private String city;

	@Column(name = "ag_state")
	private String state;

	@Column(name = "ag_zip_code")
	private long zipcode;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "us_id")
	private Users user;

	public Agent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Agent(int id, String username, String firstName, String lastName, int age, String gender, String dateOfBirth,
			long contactNumber, long altContactNumber, String emailId, String password, String securityQuestion,
			String securityAnswer, String addressLineOne, String addressLineTwo, String city, String state,
			long zipcode, Users user) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.contactNumber = contactNumber;
		this.altContactNumber = altContactNumber;
		this.emailId = emailId;
		this.password = password;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.user = user;
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

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
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

	public long getZipcode() {
		return zipcode;
	}

	public void setZipcode(long zipcode) {
		this.zipcode = zipcode;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Agent [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", contactNumber="
				+ contactNumber + ", altContactNumber=" + altContactNumber + ", emailId=" + emailId + ", password="
				+ password + ", securityQuestion=" + securityQuestion + ", securityAnswer=" + securityAnswer
				+ ", addressLineOne=" + addressLineOne + ", addressLineTwo=" + addressLineTwo + ", city=" + city
				+ ", state=" + state + ", zipcode=" + zipcode + ", user=" + user + "]";
	}

}
