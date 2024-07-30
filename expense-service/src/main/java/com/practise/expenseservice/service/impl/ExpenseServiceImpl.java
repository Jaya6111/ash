package com.practise.expenseservice.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practise.expenseservice.bean.Expense;
import com.practise.expenseservice.feign.ConnectUser;
import com.practise.expenseservice.repository.ExpenseRepository;
import com.practise.expenseservice.service.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;

	@Autowired
	ConnectUser connectUser;

	@Transactional
	@Override
	public boolean addExpense(Expense expense) {
		return expenseRepository.save(expense).getId() > 0;
	}

	@Override
	public boolean editExpense(Expense expense) {
		return addExpense(expense);
	}

	@Transactional
	@Override
	public boolean deleteExpense(int expenseId) {
		try {
			expenseRepository.deleteById(expenseId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Expense> expenseOptions(String userName, String password) {
		int userId = connectUser.login(userName, password).getBody();
		return expenseRepository.findByUserId(userId);
	}

	@Override
	public Expense getExpense(int expenseId) {
		return expenseRepository.findById(expenseId).get();
	}

	@Override
	public List<Expense> expenseReport(int userId, String expenceType, String fromDate, String toDate) {
		return expenseRepository.findByUserIdAndTypeAndDateBetween(userId, expenceType, fromDate, toDate);
	}
}
