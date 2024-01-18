package com.main.expenseapp.dao;


import com.main.expenseapp.dao.dto.ExpenseCategoryDto;
import com.main.expenseapp.entities.ExpenseCategory;
import java.util.List;

public interface ExpenseCategoryDao extends Dao<ExpenseCategoryDto, Integer>{
    List<ExpenseCategoryDto> getEntitiesByName(String name);
    ExpenseCategory getEntityByName(String name);
    void insertNewEntity(ExpenseCategoryDto e);
}
