package com.scaler.splitwise.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scaler.splitwise.models.GroupExpense;

@Repository
public interface GroupExpenseRepository extends JpaRepository<GroupExpense, Long>{
	
	public List<GroupExpense> findAllByGroupId(Long groupId);
	

}
