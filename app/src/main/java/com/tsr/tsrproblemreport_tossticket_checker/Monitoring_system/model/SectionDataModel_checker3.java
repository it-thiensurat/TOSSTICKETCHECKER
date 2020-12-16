package com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model;

import java.util.ArrayList;

/**
 * Created by pratap.kesaboyina on 30-11-2015.
 */
public class SectionDataModel_checker3 {



    private String headerTitle;
    private ArrayList<SingleItemModel_checker3> allItemsInSection;


    public SectionDataModel_checker3() {

    }
    public SectionDataModel_checker3(String headerTitle, ArrayList<SingleItemModel_checker3> allItemsInSection) {
        this.headerTitle = headerTitle;
        this.allItemsInSection = allItemsInSection;
    }



    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<SingleItemModel_checker3> getAllItemsInSection() {
        return allItemsInSection;
    }

    public void setAllItemsInSection(ArrayList<SingleItemModel_checker3> allItemsInSection) {
        this.allItemsInSection = allItemsInSection;
    }


}
