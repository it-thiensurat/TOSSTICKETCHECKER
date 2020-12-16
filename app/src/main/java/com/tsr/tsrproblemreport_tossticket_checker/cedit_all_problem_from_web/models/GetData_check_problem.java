package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models;

public class GetData_check_problem {
    String part_id;
    String category;
    String main_problems;
    String Sub_problems;
    String subject;
    String ProblemDetail;
    String datetime;
    String image;
    String count_image;


    public String getPart_id() {
        return part_id;
    }

    public void setPart_id(String part_id) {
        this.part_id = part_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String getSub_problems() {
        return Sub_problems;
    }

    public void setSub_problems(String sub_problems) {
        Sub_problems = sub_problems;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getProblemDetail() {
        return ProblemDetail;
    }

    public void setProblemDetail(String problemDetail) {
        ProblemDetail = problemDetail;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getMain_problems() {
        return main_problems;
    }

    public void setMain_problems(String main_problems) {
        this.main_problems = main_problems;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCount_image() {
        return count_image;
    }

    public void setCount_image(String count_image) {
        this.count_image = count_image;
    }
}
