package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models;

/**
 * Created by pratap.kesaboyina on 01-12-2015.
 */
public class SingleItemModel3 {


    private String name;
    private String url;
    private String description;
    private boolean isSelected;

    public SingleItemModel3() {
    }

    public SingleItemModel3(String name, String url) {
        this.name = name;
        this.url = url;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
