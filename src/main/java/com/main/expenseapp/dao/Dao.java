package com.main.expenseapp.dao;

import java.util.List;

public interface Dao<Type, Id>{
    List<Type> getAllEntities();
}
