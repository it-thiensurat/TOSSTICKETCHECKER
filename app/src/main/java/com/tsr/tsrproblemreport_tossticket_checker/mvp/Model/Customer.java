package com.tsr.tsrproblemreport_tossticket_checker.mvp.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import com.tsr.tsrproblemreport_tossticket_checker.mvp.base.adapter.BaseItem;

/**
 * Created by Ashish on 30-01-2017.
 */

public class Customer implements Parcelable {
    private  String status,message;
    private List<CustomerRes> data;

    protected Customer(Parcel in) {
        status = in.readString();
        message = in.readString();
        data = in.createTypedArrayList(CustomerRes.CREATOR);
    }

    public static final Creator<Customer> CREATOR = new Creator<Customer>() {
        @Override
        public Customer createFromParcel(Parcel in) {
            return new Customer(in);
        }

        @Override
        public Customer[] newArray(int size) {
            return new Customer[size];
        }
    };

    public Customer() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<CustomerRes> getData() {
        return data;
    }

    public void setData(List<CustomerRes> data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(status);
        parcel.writeString(message);
        parcel.writeList(data);
    }

    public List<BaseItem> getBaseItems(){
        List<BaseItem> baseItems = new ArrayList<>(  );
        for( CustomerRes item : data ){
            baseItems.add(item);
        }
        return baseItems;
    }


}

