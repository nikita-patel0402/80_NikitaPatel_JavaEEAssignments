package com.mycompany.assignment2.model;

public class Category {
    private int categoryId;
    private String categoryName;
    private int parentCategoryId;

    public int getCategoryId() { return categoryId; }
    public String getCategoryName() { return categoryName; }
    public int getParentCategoryId() { return parentCategoryId; }

    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public void setParentCategoryId(int parentCategoryId) { this.parentCategoryId = parentCategoryId; }
}