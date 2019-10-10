package com.example.a5_contact_v2.model;

import java.io.Serializable;

public class Contact implements Serializable {
    private String mName;
    private String mPhone;
    private int mId;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public Contact(String mName, String mPhone) {
        this.mName = mName;
        this.mPhone = mPhone;
    }

    public Contact() {
    }

    public String getmName() {
        return mName;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String toString() {
        return this.mName + "-" + this.mPhone;
    }

}