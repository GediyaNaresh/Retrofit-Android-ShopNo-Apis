package com.nareshgediya.retrofitandroidtutorial.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderData {

    @SerializedName("book_now")
    @Expose
    private int bookNow;
    @SerializedName("image_path")
    @Expose
    private String imagePath;
    @SerializedName("products")
    @Expose
    private List<OrderProduct> products = null;

    public int getBookNow() {
        return bookNow;
    }

    public void setBookNow(int bookNow) {
        this.bookNow = bookNow;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<OrderProduct> getProducts() {
        return products;
    }

    public void setProducts(List<OrderProduct> products) {
        this.products = products;
    }
}
