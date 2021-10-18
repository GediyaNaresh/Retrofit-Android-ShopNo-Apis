package com.nareshgediya.retrofitandroidtutorial.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryData {

    @SerializedName("book_now")
    @Expose
    private int bookNow;
    @SerializedName("c_id")
    @Expose
    private String cId;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("image_path")
    @Expose
    private String imagePath;
    @SerializedName("subcategory")
    @Expose
    private List<Subcategory> subcategory = null;

    public int getBookNow() {
        return bookNow;
    }

    public void setBookNow(int bookNow) {
        this.bookNow = bookNow;
    }

    public CategoryData withBookNow(int bookNow) {
        this.bookNow = bookNow;
        return this;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public CategoryData withcId(String cId) {
        this.cId = cId;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public CategoryData withCategory(String category) {
        this.category = category;
        return this;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public CategoryData withImagePath(String imagePath) {
        this.imagePath = imagePath;
        return this;
    }

    public List<Subcategory> getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(List<Subcategory> subcategory) {
        this.subcategory = subcategory;
    }

    public CategoryData withSubcategory(List<Subcategory> subcategory) {
        this.subcategory = subcategory;
        return this;
    }

}
