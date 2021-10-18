package com.nareshgediya.retrofitandroidtutorial.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HomeData {

    @SerializedName("book_now")
    @Expose
    private int bookNow;
    @SerializedName("slider_img_path")
    @Expose
    private String sliderImgPath;
    @SerializedName("slider")
    @Expose
    private List<String> slider;
    @SerializedName("category_img_path")
    @Expose
    private String categoryImgPath;
    @SerializedName("category")
    @Expose
    private List<Category> category = null;
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

    public String getSliderImgPath() {
        return sliderImgPath;
    }

    public void setSliderImgPath(String sliderImgPath) {
        this.sliderImgPath = sliderImgPath;
    }

    public List<String> getSlider() {
        return slider;
    }

    public void setSlider(List<String> slider) {
        this.slider = slider;
    }

    public String getCategoryImgPath() {
        return categoryImgPath;
    }

    public void setCategoryImgPath(String categoryImgPath) {
        this.categoryImgPath = categoryImgPath;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
