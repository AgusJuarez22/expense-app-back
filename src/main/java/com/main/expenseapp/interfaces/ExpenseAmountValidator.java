package com.main.expenseapp.interfaces;


import com.main.expenseapp.exception.InvalidateAmountException;

@FunctionalInterface
public interface ExpenseAmountValidator{
    void validateAmount(Double amount) throws InvalidateAmountException;
}
