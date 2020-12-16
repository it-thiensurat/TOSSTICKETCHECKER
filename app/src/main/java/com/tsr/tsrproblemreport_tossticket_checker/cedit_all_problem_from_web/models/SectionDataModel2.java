package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models;

import java.util.ArrayList;

/**
 * Created by pratap.kesaboyina on 30-11-2015.
 */
public class SectionDataModel2 {



    private String headerTitle;
    private ArrayList<SingleItemModel2> allItemsInSection;


    public SectionDataModel2() {

    }
    public SectionDataModel2(String headerTitle, ArrayList<SingleItemModel2> allItemsInSection) {
        this.headerTitle = headerTitle;
        this.allItemsInSection = allItemsInSection;
    }



    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<SingleItemModel2> getAllItemsInSection() {
        return allItemsInSection;
    }

    public void setAllItemsInSection(ArrayList<SingleItemModel2> allItemsInSection) {
        this.allItemsInSection = allItemsInSection;
    }


}
