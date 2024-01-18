package com.main.expenseapp.dao.dto;

public class ExpenseCategoryDto {
    String name;

    public ExpenseCategoryDto(String name) {
        this.name = name;
    }

    public ExpenseCategoryDto() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ExpenseCategoryDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
