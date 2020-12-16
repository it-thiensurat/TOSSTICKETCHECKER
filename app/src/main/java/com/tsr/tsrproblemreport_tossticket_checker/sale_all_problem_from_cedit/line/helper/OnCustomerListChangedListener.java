package com.tsr.tsrproblemreport_tossticket_checker.sale_all_problem_from_cedit.line.helper;

import com.tsr.tsrproblemreport_tossticket_checker.sale_all_problem_from_cedit.line.models.GetData_cedit;

import java.util.List;


/**
 * Created by teerayut.k on 11/10/2017.
 */

public interface OnCustomerListChangedListener {
    void onNoteListChanged(List<GetData_cedit> jobItemList);
}
