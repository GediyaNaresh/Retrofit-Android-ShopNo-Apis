package com.nareshgediya.retrofitandroidtutorial.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CartData {

    @SerializedName("image_path")
    @Expose
    private String imagePath;
    @SerializedName("products")
    @Expose
    private List<CartProduct> products = null;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public CartData withImagePath(String imagePath) {
        this.imagePath = imagePath;
        return this;
    }

    public List<CartProduct> getProducts() {
        return products;
    }

    public void setProducts(List<CartProduct> products) {
        this.products = products;
    }

    public CartData withProducts(List<CartProduct> products) {
        this.products = products;
        return this;
    }

}
