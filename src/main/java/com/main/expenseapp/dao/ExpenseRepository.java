package com.main.expenseapp.dao;


import com.main.expenseapp.dao.dto.ExpenseDto;
import com.main.expenseapp.entities.Expense;

public interface ExpenseRepository extends Dao<Expense, Integer> {
     void deleteEntity(Integer integer);
     void updateEntity(Integer integer);
     Integer insertNewEntity(Expense expense);
}
