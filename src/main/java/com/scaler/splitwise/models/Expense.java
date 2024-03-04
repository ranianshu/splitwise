package com.scaler.splitwise.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;

@Entity
public class Expense {
	
	private double amount;
	private Date addedAt;
	private String description;
	private String proofUrl;
	@Enumerated(value=EnumType.ORDINAL)
	private Currency currency;
	@OneToMany
	private List<ExpenseUser> expenseUsers;
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getAddedAt() {
		return addedAt;
	}
	public void setAddedAt(Date addedAt) {
		this.addedAt = addedAt;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProofUrl() {
		return proofUrl;
	}
	public void setProofUrl(String proofUrl) {
		this.proofUrl = proofUrl;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public List<ExpenseUser> getExpenseUsers() {
		return expenseUsers;
	}
	public void setExpenseUsers(List<ExpenseUser> expenseUsers) {
		this.expenseUsers = expenseUsers;
	}

}
