package com.scaler.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction extends BaseModel{
	
	@ManyToOne
	private User paidFrom;
	@ManyToOne
	private User paidTo;
	private double amount;
	
	public User getPaidFrom() {
		return paidFrom;
	}
	public void setPaidFrom(User paidFrom) {
		this.paidFrom = paidFrom;
	}
	public User getPaidTo() {
		return paidTo;
	}
	public void setPaidTo(User paidTo) {
		this.paidTo = paidTo;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
