package com.main.expenseapp.services.impl;


import com.main.expenseapp.dao.ExpenseRepository;
import com.main.expenseapp.dto.request.ExpenseRequestDto;
import com.main.expenseapp.dto.response.ExpenseCategoryResponseDto;
import com.main.expenseapp.dto.response.ExpenseResponseDto;
import com.main.expenseapp.entities.Expense;
import com.main.expenseapp.services.ExpenseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public String createExpense(ExpenseRequestDto expenseRequestDto) {
        String response = "Expense added with success";
        Expense expense = mapDtoToExpense(expenseRequestDto);
        Integer responseInserted = expenseRepository.insertNewEntity(expense);
        if(responseInserted.equals(0)){
            System.out.println("Insert failed, no register added");
        }
        return response;
    }

    @Override
    public List<ExpenseResponseDto> getAllExpenses() {
        List<Expense> expenses = expenseRepository.getAllEntities();

        return expenses.stream()
                .map(this::mapExpenseToResponseDto)
                .collect(Collectors.toList());
    }

    private Expense mapDtoToExpense(ExpenseRequestDto dto){
        Expense expense = new Expense();
        expense.setAmount(dto.getAmount());
        expense.setDate(dto.getDate());
        expense.setCategoryName(dto.getCategoryRequestDto().getName());
        return expense;
    }
    private ExpenseResponseDto mapExpenseToResponseDto(Expense expense) {
        ExpenseResponseDto expenseResponseDto = new ExpenseResponseDto();
        expenseResponseDto.setAmount(expense.getAmount());

        ExpenseCategoryResponseDto categoryDto = new ExpenseCategoryResponseDto();
        categoryDto.setId(expense.getId());
        categoryDto.setName(expense.getCategoryName());

        expenseResponseDto.setCategoryDto(categoryDto);
        expenseResponseDto.setDate(expense.getDate());
        return expenseResponseDto;
    }
}
