package com.main.expenseapp.exception;

import java.sql.SQLException;

public class DaoException extends Exception{
    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, SQLException e) {
        super(message);
    }
}
