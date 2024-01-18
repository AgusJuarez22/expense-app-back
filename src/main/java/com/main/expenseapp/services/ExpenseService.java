package com.main.expenseapp.services;

import com.main.expenseapp.dto.request.ExpenseRequestDto;
import com.main.expenseapp.dto.response.ExpenseResponseDto;

import java.util.List;

public interface ExpenseService {
    String createExpense(ExpenseRequestDto expenseRequestDto);
    List<ExpenseResponseDto> getAllExpenses();
}
