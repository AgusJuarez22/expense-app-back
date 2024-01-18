package com.main.expenseapp.interfaces.impl;



import com.main.expenseapp.dao.dto.ExpenseDto;
import com.main.expenseapp.entities.Expense;
import com.main.expenseapp.interfaces.ExpenseCalculator;
import java.util.List;


public class ExpenseCalculatorImpl implements ExpenseCalculator {
    @Override
    public double calculateTotalExpense(List<ExpenseDto> expenses) {
        double total = expenses.stream()
                .mapToDouble(ExpenseDto::getAmount)
                .reduce(0.0, Double::sum);
        return total;
    }

    @Override
    public double calculateExpenses(Expense expense) {
        return expense.getAmount();
    }
}
