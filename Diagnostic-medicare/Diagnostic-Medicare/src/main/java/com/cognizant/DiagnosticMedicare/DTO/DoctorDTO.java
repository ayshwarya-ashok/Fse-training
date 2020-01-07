package com.cognizant.DiagnosticMedicare.DTO;

import java.util.Set;

import javax.persistence.Column;

import com.cognizant.DiagnosticMedicare.model.Medicare;
import com.cognizant.DiagnosticMedicare.model.Users;

public class DoctorDTO {

	
	private int doctorId;

	private String userName;

	private String firstName;

	private String lastName;

	private int age;

	private String gender;

	private String dateOfBirth;

	private long contactNumber;

	private long altContactNumber;

	private String emailId;

	private String password;

	private String addressLineOne;

	private String addressLineTwo;

	private String city;

	private String state;

	private long zipcode;

	private String degree;

	private String speciality;

	private int workhours;

	private String hospitalName;
	
	private Set<Medicare> medicareList;
	
	private Users user;

	public DoctorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DoctorDTO(int doctorId, String userName, String firstName, String lastName, int age, String gender,
			String dateOfBirth, long contactNumber, long altContactNumber, String emailId, String password,
			String addressLineOne, String addressLineTwo, String city, String state, long zipcode, String degree,
			String speciality, int workhours, String hospitalName, Set<Medicare> medicareList, Users user) {
		super();
		this.doctorId = doctorId;
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
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.degree = degree;
		this.speciality = speciality;
		this.workhours = workhours;
		this.hospitalName = hospitalName;
		this.medicareList = medicareList;
		this.user = user;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
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

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public int getWorkhours() {
		return workhours;
	}

	public void setWorkhours(int workhours) {
		this.workhours = workhours;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public Set<Medicare> getMedicareList() {
		return medicareList;
	}

	public void setMedicareList(Set<Medicare> medicareList) {
		this.medicareList = medicareList;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "DoctorDTO [doctorId=" + doctorId + ", userName=" + userName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", age=" + age + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", contactNumber="
				+ contactNumber + ", altContactNumber=" + altContactNumber + ", emailId=" + emailId + ", password="
				+ password + ", addressLineOne=" + addressLineOne + ", addressLineTwo=" + addressLineTwo + ", city="
				+ city + ", state=" + state + ", zipcode=" + zipcode + ", degree=" + degree + ", speciality="
				+ speciality + ", workhours=" + workhours + ", hospitalName=" + hospitalName + ", medicareList="
				+ medicareList + ", user=" + user + "]";
	}
	
}
