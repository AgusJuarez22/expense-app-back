package com.main.expenseapp.entities;

import java.util.Locale;

public class ExpenseCategory {
     private String name;
     private Long id;


    public ExpenseCategory(String name, Long id) {
        this.name = name.toLowerCase().trim();
        this.id = id;
    }

    public ExpenseCategory() {
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ExpenseCategory{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
