package com.nareshgediya.retrofitandroidtutorial.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CartProduct {

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
    @SerializedName("product_img1")
    @Expose
    private String productImg1;
    @SerializedName("shipping_rate")
    @Expose
    private String shippingRate;
    @SerializedName("qty")
    @Expose
    private String qty;
    @SerializedName("filter")
    @Expose
    private String filter;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CartProduct withId(String id) {
        this.id = id;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public CartProduct withProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }

    public CartProduct withNewPrice(String newPrice) {
        this.newPrice = newPrice;
        return this;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public CartProduct withOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
        return this;
    }

    public String getProductImg1() {
        return productImg1;
    }

    public void setProductImg1(String productImg1) {
        this.productImg1 = productImg1;
    }

    public CartProduct withProductImg1(String productImg1) {
        this.productImg1 = productImg1;
        return this;
    }

    public String getShippingRate() {
        return shippingRate;
    }

    public void setShippingRate(String shippingRate) {
        this.shippingRate = shippingRate;
    }

    public CartProduct withShippingRate(String shippingRate) {
        this.shippingRate = shippingRate;
        return this;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public CartProduct withQty(String qty) {
        this.qty = qty;
        return this;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public CartProduct withFilter(String filter) {
        this.filter = filter;
        return this;
    }

}