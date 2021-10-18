package com.nareshgediya.retrofitandroidtutorial.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {
    public Data(String id, String fullName, String email, String pass) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.pass = pass;
    }

    public Data() {
    }

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("pass")
    @Expose
    private String pass;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("mobile_2")
    @Expose
    private String mobile2;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("nearby")
    @Expose
    private String nearby;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("postcode")
    @Expose
    private String postcode;
    @SerializedName("is_active")
    @Expose
    private String isActive;
    @SerializedName("cdate")
    @Expose
    private String cdate;
    @SerializedName("email_code")
    @Expose
    private String emailCode;
    @SerializedName("book_now")
    @Expose
    private String bookNow;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Data withId(String id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Data withFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Data withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Data withPass(String pass) {
        this.pass = pass;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Data withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getMobile2() {
        return mobile2;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    public Data withMobile2(String mobile2) {
        this.mobile2 = mobile2;
        return this;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Data withDob(String dob) {
        this.dob = dob;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Data withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Data withAddress(String address) {
        this.address = address;
        return this;
    }

    public String getNearby() {
        return nearby;
    }

    public void setNearby(String nearby) {
        this.nearby = nearby;
    }

    public Data withNearby(String nearby) {
        this.nearby = nearby;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Data withCountry(String country) {
        this.country = country;
        return this;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Data withState(String state) {
        this.state = state;
        return this;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Data withCity(String city) {
        this.city = city;
        return this;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Data withPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public Data withIsActive(String isActive) {
        this.isActive = isActive;
        return this;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public Data withCdate(String cdate) {
        this.cdate = cdate;
        return this;
    }

    public String getEmailCode() {
        return emailCode;
    }

    public void setEmailCode(String emailCode) {
        this.emailCode = emailCode;
    }

    public Data withEmailCode(String emailCode) {
        this.emailCode = emailCode;
        return this;
    }

    public String getBookNow() {
        return bookNow;
    }

    public void setBookNow(String bookNow) {
        this.bookNow = bookNow;
    }

    public Data withBookNow(String bookNow) {
        this.bookNow = bookNow;
        return this;
    }

}