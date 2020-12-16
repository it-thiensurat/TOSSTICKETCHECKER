package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models;

public class GetData_select_topic_problem_sub_all {
    String ProblemID;
    String ProblemCode;
    String ProblemName;
    String name_main;
    String name_gory;

    public String getProblemID() {
        return ProblemID;
    }

    public void setProblemID(String problemID) {
        ProblemID = problemID;
    }

    public String getProblemCode() {
        return ProblemCode;
    }

    public void setProblemCode(String problemCode) {
        ProblemCode = problemCode;
    }

    public String getProblemName() {
        return ProblemName;
    }

    public void setProblemName(String problemName) {
        ProblemName = problemName;
    }

    public String getName_main() {
        return name_main;
    }

    public void setName_main(String name_main) {
        this.name_main = name_main;
    }

    public String getName_gory() {
        return name_gory;
    }

    public void setName_gory(String name_gory) {
        this.name_gory = name_gory;
    }
}
