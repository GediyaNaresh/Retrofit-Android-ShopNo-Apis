package com.nareshgediya.retrofitandroidtutorial.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SingleProductData {

    @SerializedName("products")
    @Expose
    private Products products;
    @SerializedName("wishlist")
    @Expose
    private int wishlist;
    @SerializedName("book_now")
    @Expose
    private int bookNow;
    @SerializedName("image_path")
    @Expose
    private String imagePath;

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public int getWishlist() {
        return wishlist;
    }

    public void setWishlist(int wishlist) {
        this.wishlist = wishlist;
    }

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
}