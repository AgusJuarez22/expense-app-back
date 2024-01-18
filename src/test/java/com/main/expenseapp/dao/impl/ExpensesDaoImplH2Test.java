package com.main.expenseapp.dao.impl;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExpensesDaoImplH2Test {
    /*private ExpensesDao expensesDao;
    private PreparedStatement preparedStatementMock;
    private ResultSet resultSetMock;

    @BeforeEach
    void setUp() throws SQLException {
        Connection connectionMock = mock(Connection.class);
        preparedStatementMock = mock(PreparedStatement.class);
        resultSetMock = mock(ResultSet.class);
        when(connectionMock.prepareStatement(anyString())).thenReturn(preparedStatementMock);
        expensesDao = new ExpensesDaoImplH2(connectionMock);
    }

    @Test
    @DisplayName("Insert an expense when given a valid expenseDto")
    void shouldInsertExpenseWhenValidDTO() throws SQLException {
        //GIVEN
        ExpenseDto expenseDto = new ExpenseDto();
        expenseDto.setAmount(20.00);
        expenseDto.setDate("10/01/2018");
        expenseDto.setCategoryId(2);
        when(preparedStatementMock.executeUpdate()).thenReturn(1);
        //WHEN
        expensesDao.insertNewEntity(expenseDto);

        //THEN
        verify(preparedStatementMock).setDouble(1,expenseDto.getAmount());
        verify(preparedStatementMock).setInt(2,expenseDto.getCategoryId());
        verify(preparedStatementMock).setString(3,expenseDto.getDate());
        verify(preparedStatementMock, times(1)).executeUpdate();
    }
    @Test
    @DisplayName("Get a List of all the expenses when called")
    void shouldGetAllExpensesDtoSuccessfully_WhenDBHasData() throws SQLException {
        //GIVEN
        List<ExpenseDto> expectedDtoList = List.of(new ExpenseDto(10.00,1,"11/03/2016"), new ExpenseDto(20.00,2,"11/03/2016"));
        when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);
        when(resultSetMock.next()).thenReturn(true,true,false);

        when(resultSetMock.getDouble("amount")).thenReturn(10.00,20.00);
        when(resultSetMock.getString("date")).thenReturn("11/03/2016","11/03/2016");
        when(resultSetMock.getInt("category_id")).thenReturn(1,2);
        //WHEN
        List<ExpenseDto> result = expensesDao.getAllEntities();
        //THEN

        assertEquals(expectedDtoList.size(),result.size());
        verify(resultSetMock,times(2)).getDouble("amount");
        verify(resultSetMock,times(2)).getString("date");
        verify(resultSetMock,times(2)).getInt("category_id");
        assertEquals(expectedDtoList.get(0).getAmount(),result.get(0).getAmount());
        assertEquals(expectedDtoList.get(0).getCategoryId(),result.get(0).getCategoryId());
        assertEquals(expectedDtoList.get(0).getDate(),result.get(0).getDate());
    }*/
}