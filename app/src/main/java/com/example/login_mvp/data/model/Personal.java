package com.example.login_mvp.data.model;

public class Personal {
    private int mId;
    private String mName, mPhone, mAdd, mGender;

    public Personal(String name, String phone, String add, String gender) {
        mName = name;
        mPhone = phone;
        mAdd = add;
        mGender = gender;
    }

    public Personal(){}

    public Personal(int id, String name, String phone, String add, String gender) {
        mId = id;
        mName = name;
        mPhone = phone;
        mAdd = add;
        mGender = gender;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getAdd() {
        return mAdd;
    }

    public void setAdd(String add) {
        mAdd = add;
    }

    public String getGender() {
        return mGender;
    }

    public void setGender(String gender) {
        mGender = gender;
    }

    @Override
    public String toString() {
        return "Personal{"
                + "mId="
                + mId
                + ", mName='"
                + mName
                + '\''
                + ", mPhone='"
                + mPhone
                + '\''
                + ", mAdd='"
                + mAdd
                + '\''
                + ", mGender='"
                + mGender
                + '\''
                + '}';
    }

    public int checkValidity(String name,String phone,String add,String gen){
        if (name == null || phone == null || add == null || gen == null ) return 1;
        return 0;
    }
}
