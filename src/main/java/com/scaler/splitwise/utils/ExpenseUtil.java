package com.scaler.splitwise.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.scaler.splitwise.models.Expense;
import com.scaler.splitwise.models.ExpenseType;
import com.scaler.splitwise.models.ExpenseUser;
import com.scaler.splitwise.models.User;

public class ExpenseUtil {
	
	public static Map<User, Double> getCondensedExpense(List<Expense> expenses){
		Map<User, Double> condensedExpenses = new HashMap<>();
		for(Expense expense: expenses) {
			for(ExpenseUser expenseUser: expense.getExpenseUsers()) {
				double amount = expenseUser.getType().equals(ExpenseType.PAID) ?
						expenseUser.getAmount(): expenseUser.getAmount()* -1;
				condensedExpenses.put(expenseUser.getUser(), amount + condensedExpenses.getOrDefault(expenseUser.getUser(), 0.0));
			}
		}
		return condensedExpenses;
	}

}
