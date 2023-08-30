package com.example.demo.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "feedbacksection")
public class Feedback {
    @Id
    private int reviewId;
    private int rating;
    private String reviewText;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId")
    private Registration r;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="productId")
    private Products p;

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Feedback(int reviewId, int rating, String reviewText, Registration r, Products p) {
		super();
		this.reviewId = reviewId;
		this.rating = rating;
		this.reviewText = reviewText;
		this.r = r;
		this.p = p;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public Registration getR() {
		return r;
	}

	public void setR(Registration r) {
		this.r = r;
	}

	public Products getP() {
		return p;
	}

	public void setP(Products p) {
		this.p = p;
	}
    
	
}