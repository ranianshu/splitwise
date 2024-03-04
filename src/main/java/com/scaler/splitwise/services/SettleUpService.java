package com.scaler.splitwise.services;

import java.util.List;

import com.scaler.splitwise.models.Transaction;

public interface SettleUpService {
	
	public List<Transaction> settleGroup(Long groupId);
	
	public List<Transaction> settleUser(Long userId);

}
