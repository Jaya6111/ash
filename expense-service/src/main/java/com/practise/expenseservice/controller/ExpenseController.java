package com.practise.expenseservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practise.expenseservice.bean.Expense;
import com.practise.expenseservice.service.ExpenseService;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

	@Autowired
	private ExpenseService ferService;
	
	@Autowired
	Environment environment;
	
	@PostMapping("/addExpense")
	public ResponseEntity<String> addExpense(@RequestBody Expense expense) {
		// 2. Call the service for business logic execution
		boolean isAdded = ferService.addExpense(expense);

		// 3. Display the status
		if (isAdded) {
			return new ResponseEntity<String>("Expens added successful...!", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Expens add is failed...!", HttpStatus.ACCEPTED);
		}
	}

	@GetMapping("/editExpenseOptions/{userName}/{password}")
	public ResponseEntity<List<Expense>> showEditExpenseOptions(@PathVariable String userName, @PathVariable String password) {

		List<Expense> expenseOptions = ferService.expenseOptions(userName,password);
		System.out.println(environment.getProperty("local.server.port"));
		return new ResponseEntity<List<Expense>>(expenseOptions, HttpStatus.OK);
	}

	@GetMapping("/getExpense/{expenseId}")
	public ResponseEntity<Expense> getExpense(@PathVariable int expenseId) {
		Expense expense = ferService.getExpense(expenseId);
		if (expense != null) {
			return new ResponseEntity<Expense>(expense, HttpStatus.OK);
		}
		return new ResponseEntity<Expense>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/editExpense")
	public ResponseEntity<String> editExpense(@RequestBody Expense expense) {
		// 2. Call the service for business logic execution
		boolean isEdited = ferService.editExpense(expense);

		// 3. Display the status
		if (isEdited) {
			return new ResponseEntity<String>("Expens edited successful...!", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Expens edit is failed...!", HttpStatus.CONFLICT);
		}
	}

	@DeleteMapping("/delete/{expenseId}")
	public ResponseEntity<String> delete(@PathVariable int expenseId) {
		// 2. Call the service for business logic execution
		boolean userId = ferService.deleteExpense(expenseId);

		// 3. Display the status
		if (userId) {
			return new ResponseEntity<String>("Expens deleted successfully...!", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Expens delete is failed...!", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/report")
	public ResponseEntity<List<Expense>> expenseReport(@RequestParam int userId, @RequestParam String type,
			@RequestParam String fromDate, @RequestParam String toDate) {
		// 2. Call the service for business logic execution
		List<Expense> expenses = ferService.expenseReport(userId, type, fromDate, toDate);

		// 3. Display the status
		if (expenses != null || !expenses.isEmpty()) {
			return new ResponseEntity<List<Expense>>(expenses, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Expense>>(HttpStatus.NOT_FOUND);
		}
	}

}
