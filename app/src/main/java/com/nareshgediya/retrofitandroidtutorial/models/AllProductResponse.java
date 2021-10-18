package com.nareshgediya.retrofitandroidtutorial.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllProductResponse {

    @SerializedName("flag")
    @Expose
    String flag;

    @SerializedName("msg")
    @Expose
    String msg;

    @SerializedName("data")
    @Expose
    AllProductData data;

    public AllProductData getData() {
        return data;
    }

    public void setData(AllProductData data) {
        this.data = data;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
