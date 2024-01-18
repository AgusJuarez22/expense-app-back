package com.main.expenseapp.entities;



public class Expense {
    private Long id;
    private Double amount;
    private String date;
    private Integer category_id;
    private String CategoryName;

    public Expense() {
    }

    public Expense(Double amount, String date, Integer category_id, String categoryName) {
        this.amount = amount;
        this.date = date;
        this.category_id = category_id;
        CategoryName = categoryName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

}
