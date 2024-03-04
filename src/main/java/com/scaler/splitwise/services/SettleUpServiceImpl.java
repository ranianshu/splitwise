package com.scaler.splitwise.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import com.scaler.splitwise.models.Expense;
import com.scaler.splitwise.models.ExpenseType;
import com.scaler.splitwise.models.ExpenseUser;
import com.scaler.splitwise.models.GroupExpense;
import com.scaler.splitwise.models.Transaction;
import com.scaler.splitwise.models.User;
import com.scaler.splitwise.repositories.ExpenseRepository;
import com.scaler.splitwise.repositories.GroupExpenseRepository;
import com.scaler.splitwise.strategies.SettleUpStrategy;
import com.scaler.splitwise.utils.ExpenseUtil;

@Service
public class SettleUpServiceImpl implements SettleUpService{
	
	private GroupExpenseRepository groupExpenseRepository;
	private SettleUpStrategy settleUpStrategy;
	private ExpenseRepository expenseRepository;
	
	@Autowired
	public SettleUpServiceImpl(GroupExpenseRepository groupExpenseRepository, SettleUpStrategy settleUpStrategy, ExpenseRepository expenseRepository) {
		this.groupExpenseRepository = groupExpenseRepository;
		this.settleUpStrategy = settleUpStrategy;
		this.expenseRepository = expenseRepository;
	}

	@Override
	public List<Transaction> settleGroup(Long groupId) {
		
		
		//step 1: check if the group exists or not
		//step 2: Figure out all the expenses linked to this group
		
		List<GroupExpense> groupExpenses = groupExpenseRepository.findAllByGroupId(groupId);
		
		List<Expense> expenses = groupExpenses.stream().map(ge -> ge.getExpense()).toList();
		
		Map<User, Double> condensedExpenses = ExpenseUtil.getCondensedExpense(expenses);
		
		List<Transaction> transactions = settleUpStrategy.settleUp(condensedExpenses);
		
		return transactions;
	}

	@Override
	public List<Transaction> settleUser(Long userId) {
		//check if user exists or not
		//Figure out all the non group expenses related to the user - userId
		
		List<Expense> expenses = expenseRepository.findNonGroupExpensesForUser(userId);
		
		Map<User, Double> condensedExpenses = ExpenseUtil.getCondensedExpense(expenses);
		
		List<Transaction> transactions = settleUpStrategy.settleUp(condensedExpenses);
		
		
		return null;
	}

}
