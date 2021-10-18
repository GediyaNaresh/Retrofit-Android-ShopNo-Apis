package com.nareshgediya.retrofitandroidtutorial.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubcategoryData {
    @SerializedName("book_now")
    @Expose
    private int bookNow;
    @SerializedName("subcategory")
    @Expose
    private String subcategory;
    @SerializedName("image_path")
    @Expose
    private String imagePath;
    @SerializedName("products")
    @Expose
    private List<Product> products = null;

    public int getBookNow() {
        return bookNow;
    }

    public void setBookNow(int bookNow) {
        this.bookNow = bookNow;
    }

    public SubcategoryData withBookNow(int bookNow) {
        this.bookNow = bookNow;
        return this;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public SubcategoryData withSubcategory(String subcategory) {
        this.subcategory = subcategory;
        return this;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public SubcategoryData withImagePath(String imagePath) {
        this.imagePath = imagePath;
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public SubcategoryData withProducts(List<Product> products) {
        this.products = products;
        return this;
    }

}

