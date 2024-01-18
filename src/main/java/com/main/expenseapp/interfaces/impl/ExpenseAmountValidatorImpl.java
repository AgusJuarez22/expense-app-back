package com.main.expenseapp.interfaces.impl;


import com.main.expenseapp.exception.InvalidateAmountException;
import com.main.expenseapp.interfaces.ExpenseAmountValidator;

public class ExpenseAmountValidatorImpl implements ExpenseAmountValidator {
    @Override
    public void validateAmount(Double amount) throws InvalidateAmountException {
        if(amount <= 0){
            throw new InvalidateAmountException("The amount should be more than 0");
        }
    }
}
