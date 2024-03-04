package com.scaler.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class GroupExpense extends BaseModel{
	
	@ManyToOne
	private Group group;
	@ManyToOne
	private Expense expense;
	
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public Expense getExpense() {
		return expense;
	}
	public void setExpense(Expense expense) {
		this.expense = expense;
	}

}
