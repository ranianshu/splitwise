package com.scaler.splitwise.dtos;

import java.util.List;

import com.scaler.splitwise.models.Transaction;

public class SettleGroupResponseDto {
	
	private List<Transaction> transactions;
	private ResponseStatus responseStatus;
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	public ResponseStatus getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(ResponseStatus responseStatus) {
		this.responseStatus = responseStatus;
	}

}
