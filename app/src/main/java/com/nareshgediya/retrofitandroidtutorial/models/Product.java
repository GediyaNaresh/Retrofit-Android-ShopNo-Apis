package com.nareshgediya.retrofitandroidtutorial.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Product {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("product_name")
    @Expose
    private String productName;
    @SerializedName("new_price")
    @Expose
    private String newPrice;
    @SerializedName("old_price")
    @Expose
    private String oldPrice;
    @SerializedName("shipping_rate")
    @Expose
    private String shippingRate;
    @SerializedName("product_img1")
    @Expose
    private String productImg1;
    @SerializedName("images")
    @Expose
    private List<String> images = null;
    @SerializedName("wishlist")
    @Expose
    private int wishlist;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product withId(String id) {
        this.id = id;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Product withProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }

    public Product withNewPrice(String newPrice) {
        this.newPrice = newPrice;
        return this;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Product withOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
        return this;
    }

    public String getShippingRate() {
        return shippingRate;
    }

    public void setShippingRate(String shippingRate) {
        this.shippingRate = shippingRate;
    }

    public Product withShippingRate(String shippingRate) {
        this.shippingRate = shippingRate;
        return this;
    }

    public String getProductImg1() {
        return productImg1;
    }

    public void setProductImg1(String productImg1) {
        this.productImg1 = productImg1;
    }

    public Product withProductImg1(String productImg1) {
        this.productImg1 = productImg1;
        return this;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public Product withImages(List<String> images) {
        this.images = images;
        return this;
    }

    public int getWishlist() {
        return wishlist;
    }

    public void setWishlist(int wishlist) {
        this.wishlist = wishlist;
    }

    public Product withWishlist(int wishlist) {
        this.wishlist = wishlist;
        return this;
    }

}
