package com.practise.expenseservice.service;

import java.util.List;

import com.practise.expenseservice.bean.Expense;

public interface ExpenseService {



	public boolean addExpense(Expense expense);

	public boolean editExpense(Expense expense);

	public boolean deleteExpense(int id);


	List<Expense> expenseOptions(String userName, String password);


	Expense getExpense(int expenseId);


	List<Expense> expenseReport(int expenseId, String expenceType, String fromDate, String todate);

}
