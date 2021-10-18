package com.nareshgediya.retrofitandroidtutorial.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryResponse {
    @SerializedName("flag")
    @Expose
    private int flag;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private CategoryData data;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public CategoryResponse withFlag(int flag) {
        this.flag = flag;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public CategoryResponse withMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public CategoryData getData() {
        return data;
    }

    public void setData(CategoryData data) {
        this.data = data;
    }

    public CategoryResponse withData(CategoryData data) {
        this.data = data;
        return this;
    }

}
