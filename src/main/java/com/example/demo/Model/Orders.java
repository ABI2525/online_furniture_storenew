package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name =  "order_table")
public class Orders {
   @Id
   private int orderId;
   private int customerId;
   private long totalAmount;
   private String orderStatus;
public Orders() {
	super();
	// TODO Auto-generated constructor stub
	
}
public Orders(int orderId, int customerId, long totalAmount, String orderStatus) {
	super();
	this.orderId = orderId;
	this.customerId = customerId;
	this.totalAmount = totalAmount;
	this.orderStatus = orderStatus;
}
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public long getTotalAmount() {
	return totalAmount;
}
public void setTotalAmount(long totalAmount) {
	this.totalAmount = totalAmount;
}
public String getOrderStatus() {
	return orderStatus;
}
public void setOrderStatus(String orderStatus) {
	this.orderStatus = orderStatus;
}

}
