package com.practise.expenseservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practise.expenseservice.bean.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Integer> {

	List<Expense> findByUserId(int userId);

	List<Expense> findByUserIdAndTypeAndDateBetween(int userId, String type, String fromDate, String toDate);
}
