package com.nareshgediya.retrofitandroidtutorial.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DResponse {

    @SerializedName("flag")
    @Expose
    String flag;

    @SerializedName("msg")
    @Expose
    String msg;

    @SerializedName("data")
    @Expose
    Object data;

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
