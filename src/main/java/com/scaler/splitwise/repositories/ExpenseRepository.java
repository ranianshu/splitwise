package com.scaler.splitwise.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.scaler.splitwise.models.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{
	
	@Query("select e from Expense e inner join ExpenseUser eu on e.id = eu.expense.id and eu.user.id = :userId left join GroupExpense ge on e.id = ge.expense.id where ge.id is null")
	List<Expense> findNonGroupExpensesForUser(@Param("userId") Long userId);

}
