package com.nareshgediya.retrofitandroidtutorial.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubcategoryProduct {

    @SerializedName("flag")
    @Expose
    private int flag;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private SubcategoryData data;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public SubcategoryProduct withFlag(int flag) {
        this.flag = flag;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public SubcategoryProduct withMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public SubcategoryData getData() {
        return data;
    }

    public void setData(SubcategoryData data) {
        this.data = data;
    }

    public SubcategoryProduct withData(SubcategoryData data) {
        this.data = data;
        return this;
    }

}
