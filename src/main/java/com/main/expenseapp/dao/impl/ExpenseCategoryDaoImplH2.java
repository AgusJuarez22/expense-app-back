package com.main.expenseapp.dao.impl;



import com.main.expenseapp.dao.ExpenseCategoryDao;
import com.main.expenseapp.dao.dto.ExpenseCategoryDto;
import com.main.expenseapp.entities.ExpenseCategory;
import com.main.expenseapp.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class ExpenseCategoryDaoImplH2 implements ExpenseCategoryDao {
    private final Connection connection;

    private static final String FIND_BY_NAME = "SELECT * FROM expenseCategory WHERE name = ?";
    private static final String INSERT_EXPENSE_CATEGORY = "INSERT INTO expenseCategory (name) VALUES (?)";

    public ExpenseCategoryDaoImplH2(Connection connection) {
        this.connection = connection;
    }

    @Override
    public ExpenseCategory getEntityByName(String name) {
        /*try(PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME)){

            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                return new ExpenseCategory(resultSet.getString("name"),
                        resultSet.getInt("id"));
            }else{
                throw new DaoException("There is no Category with that name");
            }
        } catch (SQLException | DaoException e) {
            throw new RuntimeException(e);
        } */
        return null;
    }
    @Override
    public void insertNewEntity(ExpenseCategoryDto e) {
        ExpenseCategory expenseCategory = mapDtoToExpenseCategory(e);
        try(PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EXPENSE_CATEGORY);){
            preparedStatement.setString(1,expenseCategory.getName());
            int row = preparedStatement.executeUpdate();
            if(row == 0){
                throw new DaoException("Error adding the expense category, 0 rows affected");
            }
        } catch (SQLException | DaoException ex) {
            throw new RuntimeException(ex);
        }
    }
    @Override
    public List<ExpenseCategoryDto> getAllEntities() {
        return null;
    }
    @Override
    public List<ExpenseCategoryDto> getEntitiesByName(String name) {
        return null;
    }

    private ExpenseCategory mapDtoToExpenseCategory(ExpenseCategoryDto dto){
        ExpenseCategory expenseCategory = new ExpenseCategory();
        expenseCategory.setName(dto.getName());
        return expenseCategory;
    }
}
