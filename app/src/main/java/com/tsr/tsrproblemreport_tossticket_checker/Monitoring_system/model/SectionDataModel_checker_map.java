package com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model;

import java.util.ArrayList;

/**
 * Created by pratap.kesaboyina on 30-11-2015.
 */
public class SectionDataModel_checker_map {



    private String headerTitle;
    private ArrayList<SingleItemModel_checker_map> allItemsInSection;


    public SectionDataModel_checker_map() {

    }
    public SectionDataModel_checker_map(String headerTitle, ArrayList<SingleItemModel_checker_map> allItemsInSection) {
        this.headerTitle = headerTitle;
        this.allItemsInSection = allItemsInSection;
    }



    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<SingleItemModel_checker_map> getAllItemsInSection() {
        return allItemsInSection;
    }

    public void setAllItemsInSection(ArrayList<SingleItemModel_checker_map> allItemsInSection) {
        this.allItemsInSection = allItemsInSection;
    }


}
