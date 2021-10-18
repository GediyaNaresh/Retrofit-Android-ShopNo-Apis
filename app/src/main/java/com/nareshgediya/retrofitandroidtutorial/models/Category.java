package com.nareshgediya.retrofitandroidtutorial.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("category_img")
    @Expose
    private String categoryImg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Category withId(String id) {
        this.id = id;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Category withCategory(String category) {
        this.category = category;
        return this;
    }

    public String getCategoryImg() {
        return categoryImg;
    }

    public void setCategoryImg(String categoryImg) {
        this.categoryImg = categoryImg;
    }

    public Category withCategoryImg(String categoryImg) {
        this.categoryImg = categoryImg;
        return this;
    }

}
