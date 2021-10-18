package com.nareshgediya.retrofitandroidtutorial.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Login2Response {

    @SerializedName("flag")
    @Expose
    private int flag;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private Data data;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Login2Response withFlag(int flag) {
        this.flag = flag;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Login2Response withMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Login2Response withData(Data data) {
        this.data = data;
        return this;
    }

}

