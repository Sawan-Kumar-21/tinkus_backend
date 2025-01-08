package com.tinkus_backend.dto;

public class UserDTO {
	
private Integer Id ;
private String firstName;
private String lastName;
private String email;
private String mobileNumber;
private String address;
private String password;
private Integer cityId;
private String gender;


public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public Integer getId() {
	return Id;
}
public void setId(Integer id) {
	Id = id;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Integer getCityId() {
	return cityId;
}
public void setCityId(Integer cityId) {
	this.cityId = cityId;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}



}
