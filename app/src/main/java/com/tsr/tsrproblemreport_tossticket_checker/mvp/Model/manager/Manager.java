package com.tsr.tsrproblemreport_tossticket_checker.mvp.Model.manager;

import android.os.Parcel;
import android.os.Parcelable;


import com.tsr.tsrproblemreport_tossticket_checker.mvp.base.adapter.BaseItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashish on 30-01-2017.
 */

public class Manager implements Parcelable {
    private  String status,message;
    private List<ManagerRes> data;

    protected Manager(Parcel in) {
        status = in.readString();
        message = in.readString();
        data = in.createTypedArrayList(ManagerRes.CREATOR);
    }

    public static final Creator<Manager> CREATOR = new Creator<Manager>() {
        @Override
        public Manager createFromParcel(Parcel in) {
            return new Manager(in);
        }

        @Override
        public Manager[] newArray(int size) {
            return new Manager[size];
        }
    };

    public Manager() {

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

    public List<ManagerRes> getData() {
        return data;
    }

    public void setData(List<ManagerRes> data) {
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
        for( ManagerRes item : data ){
            baseItems.add(item);
        }
        return baseItems;
    }


}

