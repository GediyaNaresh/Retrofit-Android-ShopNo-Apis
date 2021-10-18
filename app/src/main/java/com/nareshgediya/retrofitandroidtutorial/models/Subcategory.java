package com.nareshgediya.retrofitandroidtutorial.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Subcategory {

    @SerializedName("subcategory_id")
    @Expose
    private String subcategoryId;
    @SerializedName("subcategory")
    @Expose
    private String subcategory;
    @SerializedName("products")
    @Expose
    private List<Product> products = null;

    public String getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(String subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public Subcategory withSubcategoryId(String subcategoryId) {
        this.subcategoryId = subcategoryId;
        return this;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public Subcategory withSubcategory(String subcategory) {
        this.subcategory = subcategory;
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Subcategory withProducts(List<Product> products) {
        this.products = products;
        return this;
    }

}