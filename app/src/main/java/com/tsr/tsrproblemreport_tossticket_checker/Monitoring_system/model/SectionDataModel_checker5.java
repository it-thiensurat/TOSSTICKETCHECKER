package com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model;

import java.util.ArrayList;

/**
 * Created by pratap.kesaboyina on 30-11-2015.
 */
public class SectionDataModel_checker5 {



    private String headerTitle;
    private ArrayList<SingleItemModel_checker5> allItemsInSection;


    public SectionDataModel_checker5() {

    }
    public SectionDataModel_checker5(String headerTitle, ArrayList<SingleItemModel_checker5> allItemsInSection) {
        this.headerTitle = headerTitle;
        this.allItemsInSection = allItemsInSection;
    }



    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<SingleItemModel_checker5> getAllItemsInSection() {
        return allItemsInSection;
    }

    public void setAllItemsInSection(ArrayList<SingleItemModel_checker5> allItemsInSection) {
        this.allItemsInSection = allItemsInSection;
    }


}
