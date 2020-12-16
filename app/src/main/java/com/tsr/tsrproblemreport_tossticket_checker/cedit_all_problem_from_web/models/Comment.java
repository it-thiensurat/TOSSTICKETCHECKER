package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models;

public class Comment {
    String InformID;
    String ImageUrl;
    String WorkCode;
    String ProblemDetail;
    String date_create;
    String name_topic;
    String picture_topic;

    public String getInformID() {
        return InformID;
    }

    public void setInformID(String informID) {
        InformID = informID;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getWorkCode() {
        return WorkCode;
    }

    public void setWorkCode(String workCode) {
        WorkCode = workCode;
    }

    public String getProblemDetail() {
        return ProblemDetail;
    }

    public void setProblemDetail(String problemDetail) {
        ProblemDetail = problemDetail;
    }

    public String getDate_create() {
        return date_create;
    }

    public void setDate_create(String date_create) {
        this.date_create = date_create;
    }

    public String getName_topic() {
        return name_topic;
    }

    public void setName_topic(String name_topic) {
        this.name_topic = name_topic;
    }

    public String getPicture_topic() {
        return picture_topic;
    }

    public void setPicture_topic(String picture_topic) {
        this.picture_topic = picture_topic;
    }
}
