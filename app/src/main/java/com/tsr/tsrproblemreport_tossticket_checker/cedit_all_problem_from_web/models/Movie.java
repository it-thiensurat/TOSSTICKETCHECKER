package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models;

import java.util.List;

/**
 * Created by Suleiman on 19/10/16.
 */

public class Movie {

    private String title;

     String InformID;
    String ResponStatus;
    String Contno;
    String EmployeeName;
    String PositionName;
    String picture;
    String Informitem;
    String ID;
    String topic_problem;
    String main;
    String gory;
    String ProblemDetail;
    String ProblemDetail2;
    String WorkCode_I;
    String WorkCode;
    String WorkName;
    String date_create;
    String Image_Name;
    String countImage;
    String Image_Name_R;
    String countImage_R;
    String ImageUrl;
    String ImageUrl_R;
    String Items_R;
    String user_code;
    String ProblemDetail_sub;
    String CancelNote;
    List<ImageBefore> ImageBefore;
    List<ImageAfter> ImageAfter;
    List<Details_contno> details_contnos;



    String EmployeeName_sale;
    String PositionName_sale;
    String SubTeamName;
    String SubTeamHeadName;
    String TeamCode;
    String TeamName;
    String TeamHeadName;
    String SupervisorName;
    String SupervisorHeadName;
    String SubDepartmentName;
    String SubDepartmentHeadName;
    String DepartmentName;
    String DepartmentHeadName;
    String picture_sale;
    String ProductName;
    String ProductPrice;
    String CustomerName;
    String Addressall;
    String Latitude;
    String Longitude;
    String TelHome;
    String TelMobile;


    String SaleStatus;
    String TeamSaleStatus;
    String SupSaleStatus;
    String SecSaleStatus;
    String MngSaleStatus;

    String Picture_sale_check;
    String TeamSaleEmp_picture;
    String SupSaleEmp_picture;
    String SecSaleEmp_picture;
    String MngSaleEmp_picture;
    String Outstanding;
    String CustomerStatus;
    String AccountStatus;
    String PayLastPeriod;


    private boolean isSelected;
    public Movie() {
    }

    public Movie(String title,String InformID,String ResponStatus,String Contno,String EmployeeName,String PositionName,String picture,String Informitem,String ID,String topic_problem,String main,String gory,String ProblemDetail,String ProblemDetail2,String WorkCode_I,String WorkCode,String WorkName,String date_create,String Image_Name,String countImage,String Image_Name_R,String countImage_R,String ImageUrl,String ImageUrl_R,String Items_R,String user_code,String ProblemDetail_sub) {
        this.title = title;

        this.InformID = InformID;
        this.ResponStatus = ResponStatus;
        this.Contno = Contno;
        this.EmployeeName = EmployeeName;
        this.PositionName = PositionName;
        this.picture = picture;
        this.Informitem = Informitem;
        this.ID = ID;
        this.topic_problem = topic_problem;
        this.main = main;
        this.gory = gory;
        this.ProblemDetail = ProblemDetail;
        this.ProblemDetail2 = ProblemDetail2;
        this.WorkCode_I = WorkCode_I;
        this.WorkCode = WorkCode;
        this.WorkName = WorkName;
        this.date_create = date_create;
        this.Image_Name = Image_Name;
        this.countImage = countImage;
        this.Image_Name_R = Image_Name_R;
        this.countImage_R = countImage_R;
        this.ImageUrl = ImageUrl;



        this.ImageUrl_R = ImageUrl_R;
        this.Items_R = Items_R;
        this.user_code = user_code;
        this.ProblemDetail_sub = ProblemDetail_sub;



    }











    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInformID() {
        return InformID;
    }

    public void setInformID(String informID) {
        this.InformID = informID;
    }

    public String getResponStatus() {
        return ResponStatus;
    }

    public void setResponStatus(String responStatus) {
        this.ResponStatus = responStatus;
    }

    public String getContno() {
        return Contno;
    }

    public void setContno(String contno) {
        this.Contno = contno;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.EmployeeName = employeeName;
    }

    public String getPositionName() {
        return PositionName;
    }

    public void setPositionName(String positionName) {
        this.PositionName = positionName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getInformitem() {
        return Informitem;
    }

    public void setInformitem(String informitem) {
        this.Informitem = informitem;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTopic_problem() {
        return topic_problem;
    }

    public void setTopic_problem(String topic_problem) {
        this.topic_problem = topic_problem;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getGory() {
        return gory;
    }

    public void setGory(String gory) {
        this.gory = gory;
    }

    public String getProblemDetail() {
        return ProblemDetail;
    }

    public void setProblemDetail(String problemDetail) {
        this.ProblemDetail = problemDetail;
    }

    public String getProblemDetail2() {
        return ProblemDetail2;
    }

    public void setProblemDetail2(String problemDetail2) {
        this.ProblemDetail2 = problemDetail2;
    }

    public String getWorkCode_I() {
        return WorkCode_I;
    }

    public void setWorkCode_I(String workCode_I) {
        this.WorkCode_I = workCode_I;
    }

    public String getWorkCode() {
        return WorkCode;
    }

    public void setWorkCode(String workCode) {
        this.WorkCode = workCode;
    }

    public String getWorkName() {
        return WorkName;
    }

    public void setWorkName(String workName) {
        this.WorkName = workName;
    }

    public String getDate_create() {
        return date_create;
    }

    public void setDate_create(String date_create) {
        this.date_create = date_create;
    }

    public String getImage_Name() {
        return Image_Name;
    }

    public void setImage_Name(String image_Name) {
        this.Image_Name = image_Name;
    }

    public String getCountImage() {
        return countImage;
    }

    public void setCountImage(String countImage) {
        this.countImage = countImage;
    }

    public String getImage_Name_R() {
        return Image_Name_R;
    }

    public void setImage_Name_R(String image_Name_R) {
        this.Image_Name_R = image_Name_R;
    }

    public String getCountImage_R() {
        return countImage_R;
    }

    public void setCountImage_R(String countImage_R) {
        this.countImage_R = countImage_R;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.ImageUrl = imageUrl;
    }

    public String getImageUrl_R() {
        return ImageUrl_R;
    }

    public void setImageUrl_R(String imageUrl_R) {
        this.ImageUrl_R = imageUrl_R;
    }

    public String getItems_R() {
        return Items_R;
    }

    public void setItems_R(String items_R) {
        this.Items_R = items_R;
    }

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

    public String getProblemDetail_sub() {
        return ProblemDetail_sub;
    }

    public void setProblemDetail_sub(String problemDetail_sub) {
        this.ProblemDetail_sub = problemDetail_sub;
    }

    public String getCancelNote() {
        return CancelNote;
    }

    public void setCancelNote(String cancelNote) {
        CancelNote = cancelNote;
    }

    public List<com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.ImageBefore> getImageBefore() {
        return ImageBefore;
    }

    public Movie setImageBefore(List<com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.ImageBefore> imageBefore) {
        ImageBefore = imageBefore;
        return this;
    }

    public List<com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.ImageAfter> getImageAfter() {
        return ImageAfter;
    }

    public Movie setImageAfter(List<com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.ImageAfter> imageAfter) {
        ImageAfter = imageAfter;
        return this;
    }


    public List<Details_contno> getDetails_contnos() {
        return details_contnos;
    }

    public Movie setDetails_contnos(List<Details_contno> details_contnos) {
        this.details_contnos = details_contnos;
        return this;
    }

    public String getEmployeeName_sale() {
        return EmployeeName_sale;
    }

    public void setEmployeeName_sale(String employeeName_sale) {
        this.EmployeeName_sale = employeeName_sale;
    }

    public String getPositionName_sale() {
        return PositionName_sale;
    }

    public void setPositionName_sale(String positionName_sale) {
        this.PositionName_sale = positionName_sale;
    }

    public String getSubTeamName() {
        return SubTeamName;
    }

    public void setSubTeamName(String subTeamName) {
        this.SubTeamName = subTeamName;
    }

    public String getSubTeamHeadName() {
        return SubTeamHeadName;
    }

    public void setSubTeamHeadName(String subTeamHeadName) {
        this.SubTeamHeadName = subTeamHeadName;
    }

    public String getTeamCode() {
        return TeamCode;
    }

    public void setTeamCode(String teamCode) {
        this.TeamCode = teamCode;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        this.TeamName = teamName;
    }

    public String getTeamHeadName() {
        return TeamHeadName;
    }

    public void setTeamHeadName(String teamHeadName) {
        this.TeamHeadName = teamHeadName;
    }

    public String getSupervisorName() {
        return SupervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.SupervisorName = supervisorName;
    }

    public String getSupervisorHeadName() {
        return SupervisorHeadName;
    }

    public void setSupervisorHeadName(String supervisorHeadName) {
        this.SupervisorHeadName = supervisorHeadName;
    }

    public String getSubDepartmentName() {
        return SubDepartmentName;
    }

    public void setSubDepartmentName(String subDepartmentName) {
        this.SubDepartmentName = subDepartmentName;
    }

    public String getSubDepartmentHeadName() {
        return SubDepartmentHeadName;
    }

    public void setSubDepartmentHeadName(String subDepartmentHeadName) {
        this.SubDepartmentHeadName = subDepartmentHeadName;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.DepartmentName = departmentName;
    }

    public String getDepartmentHeadName() {
        return DepartmentHeadName;
    }

    public void setDepartmentHeadName(String departmentHeadName) {
        this.DepartmentHeadName = departmentHeadName;
    }

    public String getPicture_sale() {
        return picture_sale;
    }

    public void setPicture_sale(String picture_sale) {
        this.picture_sale = picture_sale;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        this.ProductName = productName;
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(String productPrice) {
        this.ProductPrice = productPrice;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        this.CustomerName = customerName;
    }

    public String getAddressall() {
        return Addressall;
    }

    public void setAddressall(String addressall) {
        this.Addressall = addressall;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        this.Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        this.Longitude = longitude;
    }

    public String getTelHome() {
        return TelHome;
    }

    public void setTelHome(String telHome) {
        this.TelHome = telHome;
    }

    public String getTelMobile() {
        return TelMobile;
    }

    public void setTelMobile(String telMobile) {
        this.TelMobile = telMobile;
    }

    public String getSaleStatus() {
        return SaleStatus;
    }

    public void setSaleStatus(String saleStatus) {
        this.SaleStatus = saleStatus;
    }

    public String getTeamSaleStatus() {
        return TeamSaleStatus;
    }

    public void setTeamSaleStatus(String teamSaleStatus) {
        this.TeamSaleStatus = teamSaleStatus;
    }

    public String getSupSaleStatus() {
        return SupSaleStatus;
    }

    public void setSupSaleStatus(String supSaleStatus) {
        this.SupSaleStatus = supSaleStatus;
    }

    public String getSecSaleStatus() {
        return SecSaleStatus;
    }

    public void setSecSaleStatus(String secSaleStatus) {
        this.SecSaleStatus = secSaleStatus;
    }

    public String getMngSaleStatus() {
        return MngSaleStatus;
    }

    public void setMngSaleStatus(String mngSaleStatus) {
        this.MngSaleStatus = mngSaleStatus;
    }

    public String getPicture_sale_check() {
        return Picture_sale_check;
    }

    public void setPicture_sale_check(String picture_sale_check) {
        this.Picture_sale_check = picture_sale_check;
    }

    public String getTeamSaleEmp_picture() {
        return TeamSaleEmp_picture;
    }

    public void setTeamSaleEmp_picture(String teamSaleEmp_picture) {
        this.TeamSaleEmp_picture = teamSaleEmp_picture;
    }

    public String getSupSaleEmp_picture() {
        return SupSaleEmp_picture;
    }

    public void setSupSaleEmp_picture(String supSaleEmp_picture) {
        this.SupSaleEmp_picture = supSaleEmp_picture;
    }

    public String getSecSaleEmp_picture() {
        return SecSaleEmp_picture;
    }

    public void setSecSaleEmp_picture(String secSaleEmp_picture) {
        this.SecSaleEmp_picture = secSaleEmp_picture;
    }

    public String getMngSaleEmp_picture() {
        return MngSaleEmp_picture;
    }

    public void setMngSaleEmp_picture(String mngSaleEmp_picture) {
        this.MngSaleEmp_picture = mngSaleEmp_picture;
    }

    public String getOutstanding() {
        return Outstanding;
    }

    public void setOutstanding(String outstanding) {
        this.Outstanding = outstanding;
    }

    public String getCustomerStatus() {
        return CustomerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.CustomerStatus = customerStatus;
    }

    public String getAccountStatus() {
        return AccountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.AccountStatus = accountStatus;
    }

    public String getPayLastPeriod() {
        return PayLastPeriod;
    }

    public void setPayLastPeriod(String payLastPeriod) {
        this.PayLastPeriod = payLastPeriod;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        this.isSelected = selected;
    }


    /**
     * Creating 10 dummy content for list.
     *
     * @param itemCount
     * @return
     */


/*   public static List<Movie> createMovies(int itemCount) {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Movie movie = new Movie("Movie " + (itemCount == 0 ?
                    (itemCount + 1 + i) : (itemCount + i)));
            movies.add(movie);
        }
        return movies;
    }*/
}
