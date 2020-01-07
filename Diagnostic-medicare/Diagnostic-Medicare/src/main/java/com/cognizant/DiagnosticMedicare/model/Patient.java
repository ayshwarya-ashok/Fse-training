package com.cognizant.DiagnosticMedicare.model;

import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pa_id")
	private int id;

	@Column(name = "pa_user_name", unique = true)
	private String username;

	@Column(name = "pa_first_name")
	private String firstName;

	@Column(name = "pa_last_name")
	private String lastName;

	@Column(name = "pa_age")
	private int age;

	@Column(name = "pa_gender")
	private String gender;

	@Column(name = "pa_dob")
	private String dateOfBirth;

	@Column(name = "pa_contact")
	private long contactNumber;

	@Column(name = "pa_alt_contact")
	private long altContactNumber;

	@Column(name = "pa_email")
	private String emailId;

	@Column(name = "pa_password")
	private String password;

	@Column(name = "pa_security_question")
	private String securityQuestion;

	@Column(name = "pa_security_answer")
	private String securityAnswer;

	@Column(name = "pa_address_line_1")
	private String addressLineOne;

	@Column(name = "pa_address_line_2")
	private String addressLineTwo;

	@Column(name = "pa_city")
	private String city;

	@Column(name = "pa_state")
	private String state;

	@Column(name = "pa_zip_code")
	private long zipcode;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "us_id")
	private Users user;

//	@ManyToMany()
//	 @JoinTable(name = "request",
//   joinColumns = @JoinColumn(name = "re_pa_id", referencedColumnName="pa_id"), 
//   inverseJoinColumns = @JoinColumn(name = "re_ms_id", referencedColumnName="ms_id"))
//	private Set<Medicare> medicareList;

	@OneToMany
	@JoinColumn(name = "re_id")
	private Set<Request> allRequests;

	public Patient() {
		super();
	}

	public Patient(int id, String username, String firstName, String lastName, int age, String gender,
			String dateOfBirth, long contactNumber, long altContactNumber, String emailId, String password,
			String securityQuestion, String securityAnswer, String addressLineOne, String addressLineTwo, String city,
			String state, long zipcode, Users user, Set<Request> allRequests) {
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
		this.allRequests = allRequests;
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

	public Set<Request> getAllRequests() {
		return allRequests;
	}

	public void setAllRequests(Set<Request> allRequests) {
		this.allRequests = allRequests;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", contactNumber="
				+ contactNumber + ", altContactNumber=" + altContactNumber + ", emailId=" + emailId + ", password="
				+ password + ", securityQuestion=" + securityQuestion + ", securityAnswer=" + securityAnswer
				+ ", addressLineOne=" + addressLineOne + ", addressLineTwo=" + addressLineTwo + ", city=" + city
				+ ", state=" + state + ", zipcode=" + zipcode + ", user=" + user + ", allRequests=" + allRequests + "]";
	}
}