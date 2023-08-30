package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customer_details")
public class Registration {
     @Id
     private int customerId;
     private String name;
     private String lastName;
     private String contact;
     private String mailId;
     private String password;
     private String state;
     private String address;
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Registration(int customerId, String name, String lastName, String contact, String mailId, String password,
			String state, String address) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.lastName = lastName;
		this.contact = contact;
		this.mailId = mailId;
		this.password = password;
		this.state = state;
		this.address = address;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
     
     
     
}
