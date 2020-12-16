package com.tsr.tsrproblemreport_tossticket_checker.mvp.Model;


import android.os.Parcel;
import android.os.Parcelable;

import com.tsr.tsrproblemreport_tossticket_checker.mvp.base.adapter.BaseItem;

public class CustomerRes extends BaseItem implements Parcelable {

   private String CONTNO;
   private String CustomerName;

    public CustomerRes() {

    }

    public String getCONTNO() {
        return CONTNO;
    }
    public String getCustomerName() {
        return CustomerName;
    }

    public CustomerRes setCONTNO(String CONTNO) {
        this.CONTNO = CONTNO;

        return this;
    }
    public CustomerRes setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;

        return this;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(CONTNO);
        dest.writeString(CustomerName);
    }

    protected CustomerRes(Parcel in) {
        super(in);
        CONTNO = in.readString();
        CustomerName = in.readString();
    }

    @Override
    public BaseItem clone() throws CloneNotSupportedException {
        CustomerRes item = new CustomerRes()
                .setCONTNO(CONTNO)
                .setCustomerName(CustomerName);
        return item;
    }

    public static final Creator<CustomerRes> CREATOR = new Creator<CustomerRes>() {
        @Override
        public CustomerRes createFromParcel(Parcel in) {
            return new CustomerRes(in);
        }

        @Override
        public CustomerRes[] newArray(int size) {
            return new CustomerRes[size];
        }
    };

    @Override
    public int hashCode(){
       // int result = CONTNO != null ? CONTNO.hashCode() : 0;
      //  int result = CustomerName != null ? CustomerName.hashCode() : 0;

        int result = CONTNO != null ? CONTNO.hashCode() : 0;
         result =  result + CustomerName != null ? CustomerName.hashCode() : 0;

        /*
        result = 31 * result + ( name != null ? name.hashCode() : 0 );
        result = 31 * result + ( lastpaystatus != null ? lastpaystatus.hashCode() : 0 );
        result = 31 * result + ( customerStatus != null ? customerStatus.hashCode() : 0 );
        result = 31 * result + ( accountStatus != null ? accountStatus.hashCode() : 0 );
        result = 31 * result + ( paytype != null ? paytype.hashCode() : 0 );
        result = 31 * result + periods;
        result = 31 * result + paylastmonth;
        result = 31 * result + totalPrice;
        result = 31 * result + ( productName != null ? productName.hashCode() : 0 );
        result = 31 * result + ( productModel != null ? productModel.hashCode() : 0 );
        result = 31 * result + ( saleCode != null ? saleCode.hashCode() : 0 );
        result = 31 * result + (date != null ? date.hashCode() : 0 );
        result = 31 * result + agingCumulative;
        result = 31 * result + agingContinuous;
        result = 31 * result + ( agingDetail != null ? agingDetail.hashCode() : 0 );
        result = 31 * result + ( stDate != null ? stDate.hashCode() : 0 );*/
        return result;
    }


}

