package com.scaler.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

@Entity
public class ExpenseUser {
	
	@ManyToOne
	private Expense expense;
	@ManyToOne
	private User user;
	private double amount;
	@Enumerated(value=EnumType.ORDINAL)
	private ExpenseType type;
	
	public Expense getExpense() {
		return expense;
	}
	public void setExpense(Expense expense) {
		this.expense = expense;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public ExpenseType getType() {
		return type;
	}
	public void setType(ExpenseType type) {
		this.type = type;
	}

}
