package com.cognizant.authenticationservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doctor")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "do_id",
			columnDefinition = "INT(10)")
	long doctorId;
	@Column(name = "do_user_name")
	String userName;
	@Column(name = "do_first_name")
	String firstName;
	@Column(name = "do_last_name")
	String lastName;
	@Column(name = "do_age")
	int age;
	@Column(name = "do_gender")
	String gender;
	@Column(name = "do_dob")
	String dateOfBirth;
	@Column(name = "do_contact")
	long contactNumber;
	@Column(name = "do_alt_contact")
	long altContactNumber;
	@Column(name = "do_email")
	String emailId;
	@Column(name = "do_password")
	String password;
	@Column(name = "do_address_line_1")
	String addressLine_1;
	@Column(name = "do_address_line_2")
	String addressLine_2;
	@Column(name = "do_city")
	String city;
	@Column(name = "do_state")
	String state;
	@Column(name = "do_zip_code")
	String zipCode;
	@Column(name = "do_degree")
	String degree;
	@Column(name = "do_speciality")
	String speciality;
	@Column(name = "do_work_hours")
	String workHours;
	@Column(name = "do_hospital_name")
	String hospitalName;
	@Column(name = "do_medicare_service_id")
	int medicareServiceId;
	
	public Doctor() {
		
	}

	public Doctor(long doctorId, String userName, String firstName, String lastName, int age, String gender,
			String dateOfBirth, long contactNumber, long altContactNumber, String emailId, String password,
			String addressLine_1, String addressLine_2, String city, String state, String zipCode, String degree,
			String speciality, String workHours, String hospitalName, int medicareServiceId) {
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
		this.addressLine_1 = addressLine_1;
		this.addressLine_2 = addressLine_2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.degree = degree;
		this.speciality = speciality;
		this.workHours = workHours;
		this.hospitalName = hospitalName;
		this.medicareServiceId = medicareServiceId;
	}

	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
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

	public String getWorkHours() {
		return workHours;
	}

	public void setWorkHours(String workHours) {
		this.workHours = workHours;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public int getMedicareServiceId() {
		return medicareServiceId;
	}

	public void setMedicareServiceId(int medicareServiceId) {
		this.medicareServiceId = medicareServiceId;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", userName=" + userName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", age=" + age + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", contactNumber="
				+ contactNumber + ", altContactNumber=" + altContactNumber + ", emailId=" + emailId + ", password="
				+ password + ", addressLine_1=" + addressLine_1 + ", addressLine_2=" + addressLine_2 + ", city=" + city
				+ ", state=" + state + ", zipCode=" + zipCode + ", degree=" + degree + ", speciality=" + speciality
				+ ", workHours=" + workHours + ", hospitalName=" + hospitalName + ", medicareServiceId="
				+ medicareServiceId + "]";
	}
	
}
