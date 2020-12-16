package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by user on 20/2/2561.
 */

public class GetData_cedit_map implements Parcelable{
    List<GetData_cedit> GetDataAdapter1;

    public GetData_cedit_map(Parcel in) {
        GetDataAdapter1 = in.createTypedArrayList(GetData_cedit.CREATOR);
    }

    public static final Creator<GetData_cedit_map> CREATOR = new Creator<GetData_cedit_map>() {
        @Override
        public GetData_cedit_map createFromParcel(Parcel in) {
            return new GetData_cedit_map(in);
        }

        @Override
        public GetData_cedit_map[] newArray(int size) {
            return new GetData_cedit_map[size];
        }
    };

    public GetData_cedit_map() {

    }

    public List<GetData_cedit> getGetDataAdapter1() {
        return GetDataAdapter1;
    }

    public void setGetDataAdapter1(List<GetData_cedit> getDataAdapter1) {
        GetDataAdapter1 = getDataAdapter1;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(GetDataAdapter1);
    }
}
