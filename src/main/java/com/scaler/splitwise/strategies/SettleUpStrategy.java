package com.scaler.splitwise.strategies;

import java.util.List;
import java.util.Map;

import com.scaler.splitwise.models.Transaction;
import com.scaler.splitwise.models.User;

public interface SettleUpStrategy {
	
	public List<Transaction> settleUp(Map<User, Double> condensedExpenses);

}
