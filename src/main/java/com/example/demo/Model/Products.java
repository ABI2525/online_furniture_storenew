package com.example.demo.Model;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="products_details")
public class Products {
      @Id
      private int productid;
      private String name;
      private String description;
      private long price;
      private int stockquantity;
      
      @OneToMany(cascade = CascadeType.ALL)
      @JoinColumn(name = "productId")
      private List<Cart> c;

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Products(int productid, String name, String description, long price, int stockquantity, List<Cart> c) {
		super();
		this.productid = productid;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stockquantity = stockquantity;
		this.c = c;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getStockquantity() {
		return stockquantity;
	}

	public void setStockquantity(int stockquantity) {
		this.stockquantity = stockquantity;
	}

	public List<Cart> getC() {
		return c;
	}

	public void setC(List<Cart> c) {
		this.c = c;
	}

	
      
}