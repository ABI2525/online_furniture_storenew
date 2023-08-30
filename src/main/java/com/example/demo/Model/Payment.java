package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {
	
	@Id
    private int paymentMethodId;
    private int customerId;
    private String paymentType;
    private long cardNumber;
    private String expiryDate;
    private String billingAddress;
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(int paymentMethodId, int customerId, String paymentType, long cardNumber, String expiryDate,
			String billingAddress) {
		super();
		this.paymentMethodId = paymentMethodId;
		this.customerId = customerId;
		this.paymentType = paymentType;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.billingAddress = billingAddress;
	}
	public int getPaymentMethodId() {
		return paymentMethodId;
	}
	public void setPaymentMethodId(int paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
    
    
}
