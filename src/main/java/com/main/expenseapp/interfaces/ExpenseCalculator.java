package com.main.expenseapp.interfaces;



import com.main.expenseapp.dao.dto.ExpenseDto;
import com.main.expenseapp.entities.Expense;

import java.util.List;

public interface ExpenseCalculator {
    double calculateTotalExpense(List<ExpenseDto> expenses);
    double calculateExpenses(Expense expense);
}
