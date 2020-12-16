package com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model;

import java.util.ArrayList;

/**
 * Created by pratap.kesaboyina on 30-11-2015.
 */
public class SectionDataModel_checker4 {



    private String headerTitle;
    private ArrayList<SingleItemModel_checker4> allItemsInSection;


    public SectionDataModel_checker4() {

    }
    public SectionDataModel_checker4(String headerTitle, ArrayList<SingleItemModel_checker4> allItemsInSection) {
        this.headerTitle = headerTitle;
        this.allItemsInSection = allItemsInSection;
    }



    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<SingleItemModel_checker4> getAllItemsInSection() {
        return allItemsInSection;
    }

    public void setAllItemsInSection(ArrayList<SingleItemModel_checker4> allItemsInSection) {
        this.allItemsInSection = allItemsInSection;
    }


}
