package com.nareshgediya.retrofitandroidtutorial.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class SingleProduct {

    @SerializedName("flag")
    @Expose
    private int flag;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private SingleProductData data;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public SingleProductData getData() {
        return data;
    }

    public void setData(SingleProductData data) {
        this.data = data;
    }
}