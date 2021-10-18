package com.nareshgediya.retrofitandroidtutorial.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Products {
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getProductImg1() {
        return productImg1;
    }

    public void setProductImg1(String productImg1) {
        this.productImg1 = productImg1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSortDescription() {
        return sortDescription;
    }

    public void setSortDescription(String sortDescription) {
        this.sortDescription = sortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getShippingRate() {
        return shippingRate;
    }

    public void setShippingRate(String shippingRate) {
        this.shippingRate = shippingRate;
    }

    public String get_return() {
        return _return;
    }

    public void set_return(String _return) {
        this._return = _return;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getHit() {
        return hit;
    }

    public void setHit(String hit) {
        this.hit = hit;
    }

    public String getNoShare() {
        return noShare;
    }

    public void setNoShare(String noShare) {
        this.noShare = noShare;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("subcategory")
    @Expose
    private String subcategory;
    @SerializedName("images")
    @Expose
    private List<String> images = null;
    @SerializedName("product_img1")
    @Expose
    private String productImg1;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("seller_id")
    @Expose
    private String sellerId;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("product_name")
    @Expose
    private String productName;
    @SerializedName("sort_description")
    @Expose
    private String sortDescription;
    @SerializedName("full_description")
    @Expose
    private String fullDescription;
    @SerializedName("old_price")
    @Expose
    private String oldPrice;
    @SerializedName("new_price")
    @Expose
    private String newPrice;
    @SerializedName("quantity")
    @Expose
    private String quantity;
    @SerializedName("payment_method")
    @Expose
    private String paymentMethod;
    @SerializedName("filter")
    @Expose
    private String filter;
    @SerializedName("shipping_rate")
    @Expose
    private String shippingRate;
    @SerializedName("return")
    @Expose
    private String _return;
    @SerializedName("weight")
    @Expose
    private String weight;
    @SerializedName("sale")
    @Expose
    private String sale;
    @SerializedName("hit")
    @Expose
    private String hit;
    @SerializedName("no_share")
    @Expose
    private String noShare;
    @SerializedName("cdate")
    @Expose
    private String cdate;
}