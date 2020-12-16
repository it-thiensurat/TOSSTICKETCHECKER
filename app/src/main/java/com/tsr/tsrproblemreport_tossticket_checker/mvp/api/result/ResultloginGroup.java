package com.tsr.tsrproblemreport_tossticket_checker.mvp.api.result;

import java.util.List;

/**
 * Created by user on 30/10/2560.

 */
public class ResultloginGroup {
    private  String status,message;
    private List<Resultlogin> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Resultlogin> getData() {
        return data;
    }

    public void setData(List<Resultlogin> data) {
        this.data = data;
    }
}
