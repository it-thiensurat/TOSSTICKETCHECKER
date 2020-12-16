package com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.pagination.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Pagination
 * Created by Suleiman19 on 10/27/16.
 * Copyright (c) 2016. Suleiman Ali Shakir. All rights reserved.
 */

public class Result {

    @SerializedName("poster_path")
    @Expose
    private String posterPath;
    @SerializedName("adult")
    @Expose
    private Boolean adult;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("genre_ids")
    @Expose
    private List<Integer> genreIds = new ArrayList<Integer>();
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("original_title")
    @Expose
    private String originalTitle;
    @SerializedName("original_language")
    @Expose
    private String originalLanguage;


    @SerializedName("InformID")
    @Expose
    private String title;


    @SerializedName("Contno")
    @Expose
    private String Contno;


    @SerializedName("customer")
    @Expose
    private String customer;



    @SerializedName("address")
    @Expose
    private String address;


    @SerializedName("tel")
    @Expose
    private String tel;


    @SerializedName("tel2")
    @Expose
    private String tel2;


    @SerializedName("EffDate")
    @Expose
    private String EffDate;


    @SerializedName("gory")
    @Expose
    private String gory;


    @SerializedName("main")
    @Expose
    private String main;


    @SerializedName("topic_problem")
    @Expose
    private String topic_problem;



    @SerializedName("ImageUrl")
    @Expose
    private String ImageUrl;


    @SerializedName("ImageUrl_R")
    @Expose
    private String ImageUrl_R;



    @SerializedName("ProblemDetail")
    @Expose
    private String ProblemDetail;


    @SerializedName("ProblemDetail2")
    @Expose
    private String ProblemDetail2;


    @SerializedName("ProblemDetail3")
    @Expose
    private String ProblemDetail3;


    @SerializedName("ProblemDetail4")
    @Expose
    private String ProblemDetail4;


    @SerializedName("Image_Name")
    @Expose
    private String Image_Name;


    @SerializedName("Image_Name_R")
    @Expose
    private String Image_Name_R;


    @SerializedName("Informitem")
    @Expose
    private String Informitem;



    @SerializedName("CancelNote")
    @Expose
    private String CancelNote;



    @SerializedName("picture")
    @Expose
    private String picture;


    @SerializedName("EmployeeName")
    @Expose
    private String EmployeeName;


    @SerializedName("PositionName")
    @Expose
    private String PositionName;



    @SerializedName("WorkCode")
    @Expose
    private String WorkCode;


    @SerializedName("WorkName")
    @Expose
    private String WorkName;


    @SerializedName("ProblemDetail_sub")
    @Expose
    private String ProblemDetail_sub;


    @SerializedName("countImage")
    @Expose
    private String countImage;


    @SerializedName("countImage_R")
    @Expose
    private String countImage_R;





    @SerializedName("date_modify")
    @Expose
    private String date_create;




    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("vote_count")
    @Expose
    private Integer voteCount;
    @SerializedName("video")
    @Expose
    private Boolean video;
    @SerializedName("vote_average")
    @Expose
    private Double voteAverage;

    /**
     *
     * @return
     * The posterPath
     */
    public String getPosterPath() {
        return posterPath;
    }

    /**
     *
     * @param posterPath
     * The poster_path
     */
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    /**
     *
     * @return
     * The adult
     */
    public Boolean getAdult() {
        return adult;
    }

    /**
     *
     * @param adult
     * The adult
     */
    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    /**
     *
     * @return
     * The overview
     */
    public String getOverview() {
        return overview;
    }

    /**
     *
     * @param overview
     * The overview
     */
    public void setOverview(String overview) {
        this.overview = overview;
    }

    /**
     *
     * @return
     * The releaseDate
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     *
     * @param releaseDate
     * The release_date
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     *
     * @return
     * The genreIds
     */
    public List<Integer> getGenreIds() {
        return genreIds;
    }

    /**
     *
     * @param genreIds
     * The genre_ids
     */
    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The originalTitle
     */
    public String getOriginalTitle() {
        return originalTitle;
    }

    /**
     *
     * @param originalTitle
     * The original_title
     */
    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    /**
     *
     * @return
     * The originalLanguage
     */
    public String getOriginalLanguage() {
        return originalLanguage;
    }

    /**
     *
     * @param originalLanguage
     * The original_language
     */
    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }





    public String getContno() {
        return Contno;
    }

    public void setContno(String Contno) {
        this.Contno = Contno;
    }



    public String getcustomer() {
        return customer;
    }

    public void setcustomer(String customer) {
        this.customer = customer;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getEffDate() {
        return EffDate;
    }

    public void setEffDate(String effDate) {
        EffDate = effDate;
    }


    public String getGory() {
        return gory;
    }

    public void setGory(String gory) {
        this.gory = gory;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getTopic_problem() {
        return topic_problem;
    }

    public void setTopic_problem(String topic_problem) {
        this.topic_problem = topic_problem;
    }


    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getImageUrl_R() {
        return ImageUrl_R;
    }

    public void setImageUrl_R(String imageUrl_R) {
        ImageUrl_R = imageUrl_R;
    }


    public String getProblemDetail() {
        return ProblemDetail;
    }

    public void setProblemDetail(String problemDetail) {
        ProblemDetail = problemDetail;
    }

    public String getProblemDetail2() {
        return ProblemDetail2;
    }

    public void setProblemDetail2(String problemDetail2) {
        ProblemDetail2 = problemDetail2;
    }

    public String getProblemDetail3() {
        return ProblemDetail3;
    }

    public void setProblemDetail3(String problemDetail3) {
        ProblemDetail3 = problemDetail3;
    }

    public String getProblemDetail4() {
        return ProblemDetail4;
    }

    public void setProblemDetail4(String problemDetail4) {
        ProblemDetail4 = problemDetail4;
    }

    public String getImage_Name() {
        return Image_Name;
    }

    public void setImage_Name(String image_Name) {
        Image_Name = image_Name;
    }

    public String getImage_Name_R() {
        return Image_Name_R;
    }

    public void setImage_Name_R(String image_Name_R) {
        Image_Name_R = image_Name_R;
    }


    public String getInformitem() {
        return Informitem;
    }

    public void setInformitem(String informitem) {
        Informitem = informitem;
    }

    public String getCancelNote() {
        return CancelNote;
    }

    public void setCancelNote(String cancelNote) {
        CancelNote = cancelNote;
    }


    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public String getPositionName() {
        return PositionName;
    }

    public void setPositionName(String positionName) {
        PositionName = positionName;
    }

    public String getWorkCode() {
        return WorkCode;
    }

    public void setWorkCode(String workCode) {
        WorkCode = workCode;
    }

    public String getWorkName() {
        return WorkName;
    }

    public void setWorkName(String workName) {
        WorkName = workName;
    }


    public String getProblemDetail_sub() {
        return ProblemDetail_sub;
    }

    public void setProblemDetail_sub(String problemDetail_sub) {
        ProblemDetail_sub = problemDetail_sub;
    }

    public String getCountImage() {
        return countImage;
    }

    public void setCountImage(String countImage) {
        this.countImage = countImage;
    }

    public String getCountImage_R() {
        return countImage_R;
    }

    public void setCountImage_R(String countImage_R) {
        this.countImage_R = countImage_R;
    }


    public String getDate_create() {
        return date_create;
    }

    public void setDate_create(String date_create) {
        this.date_create = date_create;
    }

    /**
     *
     * @return
     * The backdropPath
     */
    public String getBackdropPath() {
        return backdropPath;
    }

    /**
     *
     * @param backdropPath
     * The backdrop_path
     */
    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    /**
     *
     * @return
     * The popularity
     */
    public Double getPopularity() {
        return popularity;
    }

    /**
     *
     * @param popularity
     * The popularity
     */
    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    /**
     *
     * @return
     * The voteCount
     */
    public Integer getVoteCount() {
        return voteCount;
    }

    /**
     *
     * @param voteCount
     * The vote_count
     */
    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    /**
     *
     * @return
     * The video
     */
    public Boolean getVideo() {
        return video;
    }

    /**
     *
     * @param video
     * The video
     */
    public void setVideo(Boolean video) {
        this.video = video;
    }

    /**
     *
     * @return
     * The voteAverage
     */
    public Double getVoteAverage() {
        return voteAverage;
    }

    /**
     *
     * @param voteAverage
     * The vote_average
     */
    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

}



