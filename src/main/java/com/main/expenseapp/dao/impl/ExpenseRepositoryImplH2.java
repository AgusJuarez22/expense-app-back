package com.main.expenseapp.dao.impl;



import com.main.expenseapp.dao.ExpenseRepository;
import com.main.expenseapp.dao.dto.ExpenseDto;
import com.main.expenseapp.entities.Expense;
import com.main.expenseapp.entities.ExpenseCategory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ExpenseRepositoryImplH2 implements ExpenseRepository {
    private static final String INSERT_INTO_EXPENSE = "INSERT INTO Expense (amount, category_id,category_name, date) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_EXPENSES = "SELECT * FROM Expense";
    private static final String INSERT_INTO_CATEGORY_EXPENSE = "INSERT INTO ExpenseCategory (name) VALUES (?)";
    private static final String SELECT_FROM_EXPENSE_CATEGORY_BY_NAME = "SELECT * FROM ExpenseCategory WHERE name = ?";
    private final JdbcTemplate jdbcTemplate;

    public ExpenseRepositoryImplH2(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Integer insertNewEntity(Expense expense) {
        jdbcTemplate.update(INSERT_INTO_CATEGORY_EXPENSE, expense.getCategoryName().toLowerCase());

        Object[] params = {expense.getCategoryName()};
        int[] types = {1};

        ExpenseCategory expenseCategory = jdbcTemplate.queryForObject(
                SELECT_FROM_EXPENSE_CATEGORY_BY_NAME,
                params, types,
                new ExpenseCategoryRowMapper());

        return jdbcTemplate.update(
                INSERT_INTO_EXPENSE,
                expense.getAmount(),
                expenseCategory.getId(),
                expenseCategory.getName(), expense.getDate());
    }

    static class ExpenseCategoryRowMapper implements RowMapper<ExpenseCategory> {
        @Override
        public ExpenseCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
            ExpenseCategory expenseCategory = new ExpenseCategory();
            expenseCategory.setId(rs.getLong("id"));
            expenseCategory.setName(rs.getString("name"));
            return expenseCategory;
        }
    }
    @Override
    public List<Expense> getAllEntities() {
        return jdbcTemplate.query(SELECT_ALL_EXPENSES, new ExpenseRowMapper());
    }

    static class ExpenseRowMapper implements RowMapper<Expense> {
        @Override
        public Expense mapRow(ResultSet rs, int rowNum) throws SQLException {
            Expense expense = new Expense();
            expense.setId(rs.getLong("id"));
            expense.setAmount(rs.getDouble("amount"));
            expense.setCategory_id(rs.getInt("category_id"));
            expense.setCategoryName(rs.getString("category_name"));
            expense.setDate(rs.getString("date"));
            return expense;
        }
    }

    @Override
    public void deleteEntity(Integer integer) {

    }

    @Override
    public void updateEntity(Integer integer) {

    }


    private Expense mapDtoToExpense(ExpenseDto dto){
        Expense expense = new Expense();
        expense.setAmount(dto.getAmount());
        expense.setDate(dto.getDate());
        expense.setCategory_id(dto.getCategoryId());
        return expense;
    }
    private ExpenseDto mapExpenseToDto(Expense expense){
        ExpenseDto expenseDto = new ExpenseDto();
        expenseDto.setAmount(expense.getAmount());
        expenseDto.setCategoryId(expense.getCategory_id());
        expenseDto.setDate(expense.getDate());
        return expenseDto;
    }
    private ExpenseDto mapResultSetToDto(ResultSet resultSet) throws SQLException {
        ExpenseDto expenseDto = new ExpenseDto();
        expenseDto.setAmount(resultSet.getDouble("amount"));
        expenseDto.setDate(resultSet.getString("date"));
        expenseDto.setCategoryId(resultSet.getInt("category_id"));
        return expenseDto;
    }
}
