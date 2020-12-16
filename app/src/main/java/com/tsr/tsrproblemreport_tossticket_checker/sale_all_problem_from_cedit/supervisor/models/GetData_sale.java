package com.tsr.tsrproblemreport_tossticket_checker.sale_all_problem_from_cedit.supervisor.models;

/**
 * Created by user on 20/11/2560.
 */


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by JUNED on 6/16/2016.
 */
public class GetData_sale implements Parcelable {

    public String CONTNO;
    public String RefNo;
    public String isremark;

    public String SaleEmployeeName;
    public String SaleTeamCode;
    public String SaleHeaderName;


    public String PrefixName;
    public String CustomerName;
    public String ProductName;
    public String AddressDetail;
    public String TelHome;
    public String TelMobile;
    public String Latitude;
    public String Longitude;
    public String IDCARD;
    public String statusName;
    public String EFFDATE;
    public String dis;




    public String CONTNO2;
    public String RefNo2;
    public String SaleEmployeeName2;
    public String SaleTeamCode2;
    public String SaleHeaderName2;

    public String PrefixName2;
    public String CustomerName2;
    public String ProductName2;
    public String AddressDetail2;
    public String TelHome2;
    public String TelMobile2;
    public String Latitude2;
    public String Longitude2;
    public String IDCARD2;
    public String statusName2;
    public String EFFDATE2;
    public String dis2;



    public String contno_image;
    public String Image_PRODUCT;
    public String Image_IDCARD;
    public String Image_MAP;
    public String Image_PRODUCT_new;
    public String Image_IDCARD_new;
    public String Image_MAP_new;
    public String status_confirm_Image_PRODUCT_old;
    public String status_confirm_Image_IDCARD_old;
    public String status_confirm_Image_MAP_old;
    public String status_confirm_Image_PRODUCT;
    public String status_confirm_Image_IDCARD;
    public String status_confirm_Image_MAP;
    public String server_image_PRODUCT;
    public String server_image_IDCARD;
    public String server_image_MAP;

    public String status_qrcode;
    public String status_image;
    public String status_image2;
    public String status_location;
    public String distance;

    public String salename;
    public String teamcode;
    public String headname;
    public String lat_long;

    public String conno;
    public String conno_qr_code;
    public String product_name;
    public String status;
    public String name_customer;
    public String id_card;
    public String address;
    public String number_phone;
    public String date;
    public String status_app;
    public String IssueName;
    public String status_view_lasttime;



    public String refno;
    public String conno_view;
    public String titleTypeCode;
    public String  partimage;
    public String Date;

    public String refno2;
    public String conno2;
    public String GroupID;
    public String Createdate;
    public String IssueGroupName;

    public GetData_sale(Parcel in) {
        CONTNO=in.readString();
        RefNo=in.readString();
        isremark=in.readString();

        SaleEmployeeName=in.readString();
        SaleTeamCode=in.readString();
        SaleHeaderName=in.readString();


        PrefixName=in.readString();
        CustomerName=in.readString();
        ProductName=in.readString();
        AddressDetail=in.readString();
        TelHome=in.readString();
        TelMobile=in.readString();
        Latitude=in.readString();
        Longitude=in.readString();
        IDCARD=in.readString();
        statusName=in.readString();
        EFFDATE=in.readString();
        dis=in.readString();




        CONTNO2=in.readString();
        RefNo2=in.readString();
        SaleEmployeeName2=in.readString();
        SaleTeamCode2=in.readString();
        SaleHeaderName2=in.readString();

        PrefixName2=in.readString();
        CustomerName2=in.readString();
        ProductName2=in.readString();
        AddressDetail2=in.readString();
        TelHome2=in.readString();
        TelMobile2=in.readString();
        Latitude2=in.readString();
        Longitude2=in.readString();
        IDCARD2=in.readString();
        statusName2=in.readString();
        EFFDATE2=in.readString();
        dis2=in.readString();



        contno_image=in.readString();
        Image_PRODUCT=in.readString();
        Image_IDCARD=in.readString();
        Image_MAP=in.readString();
        Image_PRODUCT_new=in.readString();
        Image_IDCARD_new=in.readString();
        Image_MAP_new=in.readString();
        status_confirm_Image_PRODUCT_old=in.readString();
        status_confirm_Image_IDCARD_old=in.readString();
        status_confirm_Image_MAP_old=in.readString();
        status_confirm_Image_PRODUCT=in.readString();
        status_confirm_Image_IDCARD=in.readString();
        status_confirm_Image_MAP=in.readString();
        server_image_PRODUCT=in.readString();
        server_image_IDCARD=in.readString();
        server_image_MAP=in.readString();

        status_qrcode=in.readString();
        status_image=in.readString();
        status_image2=in.readString();
        status_location=in.readString();
        distance=in.readString();

        salename=in.readString();
        teamcode=in.readString();
        headname=in.readString();
        lat_long=in.readString();

        conno=in.readString();
        conno_qr_code=in.readString();
        product_name=in.readString();
        status=in.readString();
        name_customer=in.readString();
        id_card=in.readString();
        address=in.readString();
        number_phone=in.readString();
        date=in.readString();
        status_app=in.readString();
        IssueName=in.readString();
        status_view_lasttime=in.readString();



        refno=in.readString();
        conno_view=in.readString();
        titleTypeCode=in.readString();
        partimage=in.readString();
        Date=in.readString();

        refno2=in.readString();
        conno2=in.readString();
        GroupID=in.readString();
        Createdate=in.readString();
        IssueGroupName=in.readString();
    }

    public GetData_sale() {

    }


    public String getCONTNO() {
        return CONTNO;
    }

    public void setCONTNO(String CONTNO) {
        this.CONTNO = CONTNO;
    }



    public String getRefNo() {
        return RefNo;
    }

    public void setRefNo(String RefNo) {
        this.RefNo = RefNo;
    }


    public String getisremark() {
        return isremark;
    }

    public void setisremark(String isremark) {
        this.isremark = isremark;
    }




    public String getSaleEmployeeName() {
        return SaleEmployeeName;
    }

    public void setSaleEmployeeName(String SaleEmployeeName) {
        this.SaleEmployeeName = SaleEmployeeName;
    }




    public String getSaleTeamCode() {
        return SaleTeamCode;
    }

    public void setSaleTeamCode(String SaleTeamCode) {
        this.SaleTeamCode = SaleTeamCode;
    }




    public String getSaleHeaderName() {
        return SaleHeaderName;
    }

    public void setSaleHeaderName(String SaleHeaderName) {
        this.SaleHeaderName = SaleHeaderName;
    }





    public String getPrefixName() {
        return PrefixName;
    }

    public void setPrefixName(String PrefixName) {
        this.PrefixName = PrefixName;
    }


    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }






    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }


    public String getAddressDetail() {
        return AddressDetail;
    }

    public void setAddressDetail(String AddressDetail) {
        this.AddressDetail = AddressDetail;
    }




    public String getTelHome() {
        return TelHome;
    }

    public void setTelHome(String TelHome) {
        this.TelHome = TelHome;
    }


    public String getTelMobile() {
        return TelMobile;
    }

    public void setTelMobile(String TelMobile) {
        this.TelMobile = TelMobile;
    }




    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String Latitude) {
        this.Latitude = Latitude;
    }






    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String Longitude) {
        this.Longitude = Longitude;
    }



    public String getIDCARD() {
        return IDCARD;
    }

    public void setIDCARD(String IDCARD) {
        this.IDCARD = IDCARD;
    }



    public String getstatusName() {
        return statusName;
    }

    public void setstatusName(String statusName) {
        this.statusName = statusName;
    }



    public String getEFFDATE() {
        return EFFDATE;
    }

    public void setEFFDATE(String EFFDATE) {
        this.EFFDATE = EFFDATE;
    }







    public String getdis() {
        return dis;
    }

    public void setdis(String dis) {
        this.dis = dis;
    }















    public String getCONTNO2() {
        return CONTNO2;
    }

    public void setCONTNO2(String CONTNO2) {
        this.CONTNO2 = CONTNO2;
    }



    public String getRefNo2() {
        return RefNo2;
    }

    public void setRefNo2(String RefNo2) {
        this.RefNo2 = RefNo2;
    }



    public String getSaleEmployeeName2() {
        return SaleEmployeeName2;
    }

    public void setSaleEmployeeName2(String SaleEmployeeName2) {
        this.SaleEmployeeName2 = SaleEmployeeName2;
    }



    public String getSaleTeamCode2() {
        return SaleTeamCode2;
    }

    public void setSaleTeamCode2(String SaleTeamCode2) {
        this.SaleTeamCode2 = SaleTeamCode2;
    }



    public String getSaleHeaderName2() {
        return SaleHeaderName2;
    }

    public void setSaleHeaderName2(String SaleHeaderName2) {
        this.SaleHeaderName2 = SaleHeaderName2;
    }







    public String getPrefixName2() {
        return PrefixName2;
    }

    public void setPrefixName2(String PrefixName2) {
        this.PrefixName2 = PrefixName2;
    }


    public String getCustomerName2() {
        return CustomerName2;
    }

    public void setCustomerName2(String CustomerName2) {
        this.CustomerName2 = CustomerName2;
    }






    public String getProductName2() {
        return ProductName2;
    }

    public void setProductName2(String ProductName2) {
        this.ProductName2 = ProductName2;
    }


    public String getAddressDetail2() {
        return AddressDetail2;
    }

    public void setAddressDetail2(String AddressDetail2) {
        this.AddressDetail2 = AddressDetail2;
    }




    public String getTelHome2() {
        return TelHome2;
    }

    public void setTelHome2(String TelHome2) {
        this.TelHome2 = TelHome2;
    }


    public String getTelMobile2() {
        return TelMobile2;
    }

    public void setTelMobile2(String TelMobile2) {
        this.TelMobile2 = TelMobile2;
    }




    public String getLatitude2() {
        return Latitude2;
    }

    public void setLatitude2(String Latitude2) {
        this.Latitude2 = Latitude2;
    }






    public String getLongitude2() {
        return Longitude2;
    }

    public void setLongitude2(String Longitude2) {
        this.Longitude2 = Longitude2;
    }



    public String getIDCARD2() {
        return IDCARD2;
    }

    public void setIDCARD2(String IDCARD2) {
        this.IDCARD2 = IDCARD2;
    }



    public String getstatusName2() {
        return statusName2;
    }

    public void setstatusName2(String statusName2) {
        this.statusName2 = statusName2;
    }



    public String getEFFDATE2() {
        return EFFDATE2;
    }

    public void setEFFDATE2(String EFFDATE2) {
        this.EFFDATE2 = EFFDATE2;
    }







    public String getdis2() {
        return dis2;
    }

    public void setdis2(String dis2) {
        this.dis2 = dis2;
    }











    public String getcontno_image() {
        return contno_image;
    }

    public void setcontno_image(String contno_image) {
        this.contno_image = contno_image;
    }




    public String getImage_PRODUCT() {
        return Image_PRODUCT;
    }

    public void setImage_PRODUCT(String Image_PRODUCT) {
        this.Image_PRODUCT = Image_PRODUCT;
    }



    public String getImage_IDCARD() {
        return Image_IDCARD;
    }

    public void setImage_IDCARD(String Image_IDCARD) {
        this.Image_IDCARD = Image_IDCARD;
    }


    public String getImage_MAP() {
        return Image_MAP;
    }

    public void setImage_MAP(String Image_MAP) {
        this.Image_MAP = Image_MAP;
    }






    public String getImage_PRODUCT_new() {
        return Image_PRODUCT_new;
    }

    public void setImage_PRODUCT_new(String Image_PRODUCT_new) {
        this.Image_PRODUCT_new = Image_PRODUCT_new;
    }



    public String getImage_IDCARD_new() {
        return Image_IDCARD_new;
    }

    public void setImage_IDCARD_new(String Image_IDCARD_new) {
        this.Image_IDCARD_new = Image_IDCARD_new;
    }


    public String getImage_MAP_new() {
        return Image_MAP_new;
    }

    public void setImage_MAP_new(String Image_MAP_new) {
        this.Image_MAP_new = Image_MAP_new;
    }




    public String getstatus_confirm_Image_PRODUCT_old() {
        return status_confirm_Image_PRODUCT_old;
    }

    public void setstatus_confirm_Image_PRODUCT_old(String status_confirm_Image_PRODUCT_old) {
        this.status_confirm_Image_PRODUCT_old = status_confirm_Image_PRODUCT_old;
    }


    public String getstatus_confirm_Image_IDCARD_old() {
        return status_confirm_Image_IDCARD_old;
    }

    public void setstatus_confirm_Image_IDCARD_old(String status_confirm_Image_IDCARD_old) {
        this.status_confirm_Image_IDCARD_old = status_confirm_Image_IDCARD_old;
    }



    public String getstatus_confirm_Image_MAP_old() {
        return status_confirm_Image_MAP_old;
    }

    public void setstatus_confirm_Image_MAP_old(String status_confirm_Image_MAP_old) {
        this.status_confirm_Image_MAP_old = status_confirm_Image_MAP_old;
    }



    public String getstatus_confirm_Image_PRODUCT() {
        return status_confirm_Image_PRODUCT;
    }

    public void setstatus_confirm_Image_PRODUCT(String status_confirm_Image_PRODUCT) {
        this.status_confirm_Image_PRODUCT = status_confirm_Image_PRODUCT;
    }

    public String getstatus_confirm_Image_IDCARD() {
        return status_confirm_Image_IDCARD;
    }

    public void setstatus_confirm_Image_IDCARD(String status_confirm_Image_IDCARD) {
        this.status_confirm_Image_IDCARD = status_confirm_Image_IDCARD;
    }

    public String getstatus_confirm_Image_MAP() {
        return status_confirm_Image_MAP;
    }

    public void setstatus_confirm_Image_MAP(String status_confirm_Image_MAP) {
        this.status_confirm_Image_MAP = status_confirm_Image_MAP;
    }


    public String getserver_image_PRODUCT() {
        return server_image_PRODUCT;
    }

    public void setserver_image_PRODUCT(String server_image_PRODUCT) {
        this.server_image_PRODUCT = server_image_PRODUCT;
    }


    public String getserver_image_IDCARD() {
        return server_image_IDCARD;
    }

    public void setserver_image_IDCARD(String server_image_IDCARD) {
        this.server_image_IDCARD = server_image_IDCARD;
    }


    public String getserver_image_MAP() {
        return server_image_MAP;
    }

    public void setserver_image_MAP(String server_image_MAP) {
        this.server_image_MAP = server_image_MAP;
    }

    public String getstatus_qrcode() {
        return status_qrcode;
    }

    public void setstatus_qrcode(String status_qrcode) {
        this.status_qrcode = status_qrcode;
    }



    public String getstatus_image() {
        return status_image;
    }

    public void setstatus_image(String status_image) {
        this.status_image = status_image;
    }


    public String getstatus_image2() {
        return status_image2;
    }

    public void setstatus_image2(String status_image2) {
        this.status_image2 = status_image2;
    }



    public String getstatus_location() {
        return status_location;
    }

    public void setstatus_location(String status_location) {
        this.status_location = status_location;
    }


    public String getdistance() {
        return distance;
    }

    public void setdistance(String distance) {
        this.distance = distance;
    }



    public String getsalename() {
        return salename;
    }

    public void setsalename(String salename) {
        this.salename = salename;
    }


    public String getteamcode() {
        return teamcode;
    }

    public void setteamcode(String teamcode) {
        this.teamcode = teamcode;
    }


    public String getheadname() {
        return headname;
    }

    public void setheadname(String headname) {
        this.headname = headname;
    }


    public String getlat_long() {
        return lat_long;
    }

    public void setlat_long(String lat_long) {
        this.lat_long = lat_long;
    }




    public String getconno() {
        return conno;
    }

    public void setconno(String conno) {
        this.conno = conno;
    }


    public String getconno_qr_code() {
        return conno_qr_code;
    }

    public void setconno_qr_code(String conno_qr_code) {
        this.conno_qr_code = conno_qr_code;
    }


    public String getproduct_name() {
        return product_name;
    }

    public void setproduct_name(String product_name) {
        this.product_name = product_name;
    }


    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }


    public String getname_customer() {
        return name_customer;
    }

    public void setname_customer(String name_customer) {
        this.name_customer = name_customer;
    }


    public String getid_card() {
        return id_card;
    }

    public void setid_card(String id_card) {
        this.id_card = id_card;
    }


    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }


    public String getnumber_phone() {
        return number_phone;
    }

    public void setnumber_phone(String number_phone) {
        this.number_phone = number_phone;
    }


    public String getdate() {
        return date;
    }

    public void setdate(String date) {
        this.date = date;
    }


    public String getstatus_app() {
        return status_app;
    }

    public void setstatus_app(String status_app) {
        this.status_app = status_app;
    }



    public String getIssueName() {
        return IssueName;
    }

    public void setIssueName(String IssueName) {
        this.IssueName = IssueName;
    }



    public String getstatus_view_lasttime() {
        return status_view_lasttime;
    }

    public void setstatus_view_lasttime(String status_view_lasttime) {
        this.status_view_lasttime = status_view_lasttime;
    }

    public String get() {
        return refno;
    }

    public void setrefno(String refno) {
        this.refno = refno;
    }




    public String getconno_view() {
        return conno_view;
    }

    public void setconno_view(String conno_view) {
        this.conno_view = conno_view;
    }



    public String gettitleTypeCode() {
        return titleTypeCode;
    }

    public void settitleTypeCode(String titleTypeCode) {
        this.titleTypeCode = titleTypeCode;
    }



    public String getpartimage() {
        return partimage;
    }

    public void setpartimage(String partimage) {
        this.partimage = partimage;
    }


    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }




    public String getrefno2() {
        return refno2;
    }

    public void setrefno2(String refno2) {
        this.refno2 = refno2;
    }


    public String getconno2() {
        return conno2;
    }

    public void setconno2(String conno2) {
        this.conno2 = conno2;
    }



    public String getGroupID() {
        return GroupID;
    }

    public void setGroupID(String GroupID) {
        this.GroupID = GroupID;
    }


    public String getCreatedate() {
        return Createdate;
    }

    public void setCreatedate(String Createdate) {
        this.Createdate = Createdate;
    }
    public String getIssueGroupName() {
        return IssueGroupName;
    }

    public void setIssueGroupName(String IssueGroupName) {
        this.IssueGroupName = IssueGroupName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(CONTNO);
        parcel.writeString(RefNo);
        parcel.writeString(isremark);
        parcel.writeString(SaleEmployeeName);
        parcel.writeString(SaleTeamCode);
        parcel.writeString(SaleHeaderName);
        parcel.writeString(PrefixName);
        parcel.writeString(CustomerName);
        parcel.writeString(ProductName);
        parcel.writeString(AddressDetail);
        parcel.writeString(TelHome);
        parcel.writeString(TelMobile);
        parcel.writeString(Latitude);
        parcel.writeString(Longitude);

        parcel.writeString(IDCARD);
        parcel.writeString(statusName);
        parcel.writeString(EFFDATE);
        parcel.writeString(dis);

        parcel.writeString(CONTNO2);
        parcel.writeString(RefNo2);
        parcel.writeString(SaleEmployeeName2);
        parcel.writeString(SaleTeamCode2);
        parcel.writeString(SaleHeaderName2);
        parcel.writeString(PrefixName2);
        parcel.writeString(CustomerName2);

        parcel.writeString(ProductName2);
        parcel.writeString(AddressDetail2);
        parcel.writeString(TelHome2);
        parcel.writeString(TelMobile2);
        parcel.writeString(Latitude2);
        parcel.writeString(Longitude2);
        parcel.writeString(IDCARD2);
        parcel.writeString(statusName2);
        parcel.writeString(EFFDATE2);
        parcel.writeString(dis2);

        parcel.writeString(contno_image);
        parcel.writeString(Image_PRODUCT);
        parcel.writeString(Image_IDCARD);
        parcel.writeString(Image_MAP);
        parcel.writeString(Image_PRODUCT_new);
        parcel.writeString(Image_IDCARD_new);
        parcel.writeString(Image_MAP_new);
        parcel.writeString(status_confirm_Image_PRODUCT_old);
        parcel.writeString(status_confirm_Image_IDCARD_old);
        parcel.writeString(status_confirm_Image_MAP_old);
        parcel.writeString(status_confirm_Image_PRODUCT);
        parcel.writeString(status_confirm_Image_IDCARD);
        parcel.writeString(status_confirm_Image_MAP);
        parcel.writeString(server_image_PRODUCT);
        parcel.writeString(server_image_IDCARD);
        parcel.writeString(server_image_MAP);
        parcel.writeString(status_qrcode);
        parcel.writeString(status_image);

        parcel.writeString(status_image2);
        parcel.writeString(status_location);
        parcel.writeString(distance);
        parcel.writeString(salename);
        parcel.writeString(teamcode);
        parcel.writeString(headname);
        parcel.writeString(lat_long);
        parcel.writeString(conno);
        parcel.writeString(conno_qr_code);
        parcel.writeString(product_name);
        parcel.writeString(status);
        parcel.writeString(name_customer);
        parcel.writeString(id_card);
        parcel.writeString(address);
        parcel.writeString(number_phone);
        parcel.writeString(date);
        parcel.writeString(status_app);
        parcel.writeString(IssueName);
        parcel.writeString(status_view_lasttime);
        parcel.writeString(refno);
        parcel.writeString(conno_view);
        parcel.writeString(titleTypeCode);
        parcel.writeString(partimage);
        parcel.writeString(Date);
        parcel.writeString(refno2);

        parcel.writeString(conno2);
        parcel.writeString(GroupID);
        parcel.writeString(Createdate);
        parcel.writeString(IssueGroupName);



    }

    public static final Creator<GetData_cedit> CREATOR = new Creator<GetData_cedit>() {
        @Override
        public GetData_cedit createFromParcel(Parcel in) {
            return new GetData_cedit(in);
        }

        @Override
        public GetData_cedit[] newArray(int size) {
            return new GetData_cedit[size];
        }
    };
}
