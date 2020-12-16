package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.helper;

import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit;

import java.util.List;


/**
 * Created by teerayut.k on 11/10/2017.
 */

public interface OnCustomerListChangedListener {
    void onNoteListChanged(List<GetData_cedit> jobItemList);
}
