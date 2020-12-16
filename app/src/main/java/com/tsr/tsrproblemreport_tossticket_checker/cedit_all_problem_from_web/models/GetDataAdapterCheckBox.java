package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models;

import java.util.List;

/**
 * Created by JUNED on 6/16/2016.
 */
public class GetDataAdapterCheckBox {
    public String id;
    public String problem;
    public String id2;
    public String problem2;

    public String image_error;
    public String image_sucess;

    public String image_error_size;
    public String image_sucess_size;

    public List<GetDataAdapterCheckBox_image_id> image;

    public List<GetDataAdapterCheckBox_image_id> getImage() {
        return image;
    }

    public GetDataAdapterCheckBox setImage(List<GetDataAdapterCheckBox_image_id> image) {
        this.image = image;
        return this;
    }





    //  public boolean check_problem;
  private String textONEs;
    private boolean isSelected;


    public String getTextONEs() {
        return textONEs;
    }

    public void setTextONEs(String textONEs) {
        this.textONEs = textONEs;
    }


    public String getproblem() {
        return problem;
    }

    public void setproblem(String problem) {
        this.problem = problem;
    }


    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getImage_error_size() {
        return image_error_size;
    }

    public void setImage_error_size(String image_error_size) {
        this.image_error_size = image_error_size;
    }

    public String getImage_sucess_size() {
        return image_sucess_size;
    }

    public void setImage_sucess_size(String image_sucess_size) {
        this.image_sucess_size = image_sucess_size;
    }

    public String getproblem2() {
        return problem2;
    }

    public void setproblem2(String problem2) {
        this.problem2 = problem2;
    }


    public String getid2() {
        return id2;
    }

    public void setid2(String id2) {
        this.id2 = id2;
    }



    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }


    public String getImage_error() {
        return image_error;
    }

    public GetDataAdapterCheckBox setImage_error(String image_error) {
        this.image_error = image_error;
        return this;
    }

    public String getImage_sucess() {
        return image_sucess;
    }

    public GetDataAdapterCheckBox setImage_sucess(String image_sucess) {
        this.image_sucess = image_sucess;
        return this;
    }

}





