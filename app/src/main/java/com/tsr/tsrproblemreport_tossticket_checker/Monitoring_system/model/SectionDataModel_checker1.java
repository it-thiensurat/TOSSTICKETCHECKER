package com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model;

import java.util.ArrayList;

/**
 * Created by pratap.kesaboyina on 30-11-2015.
 */
public class SectionDataModel_checker1 {



    private String headerTitle;
    private ArrayList<SingleItemModel_checker1> allItemsInSection;


    public SectionDataModel_checker1() {

    }
    public SectionDataModel_checker1(String headerTitle, ArrayList<SingleItemModel_checker1> allItemsInSection) {
        this.headerTitle = headerTitle;
        this.allItemsInSection = allItemsInSection;
    }



    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<SingleItemModel_checker1> getAllItemsInSection() {
        return allItemsInSection;
    }

    public void setAllItemsInSection(ArrayList<SingleItemModel_checker1> allItemsInSection) {
        this.allItemsInSection = allItemsInSection;
    }


}
