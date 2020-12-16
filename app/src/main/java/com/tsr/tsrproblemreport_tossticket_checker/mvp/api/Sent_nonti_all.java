package com.tsr.tsrproblemreport_tossticket_checker.mvp.api;

import java.util.List;

public class Sent_nonti_all {

    private List<body> body;

    public List<Sent_nonti_all.body> getBody() {
        return body;
    }

    public Sent_nonti_all setBody(List<Sent_nonti_all.body> body) {
        this.body = body;
        return this;
    }

    public static class body {
        private  String   contno;
        private  String  problem;
        private  String fcm_key;
        private  String user_code;
        private  String  ID;
        private  String image;
        private  String CashTeamCode;

        public String getContno() {
            return contno;
        }

        public body setContno(String contno) {
            this.contno = contno;
            return this;
        }

        public String getProblem() {
            return problem;
        }

        public body setProblem(String problem) {
            this.problem = problem;
            return this;
        }

        public String getFcm_key() {
            return fcm_key;
        }

        public body setFcm_key(String fcm_key) {
            this.fcm_key = fcm_key;
            return this;
        }

        public String getUser_code() {
            return user_code;
        }

        public body setUser_code(String user_code) {
            this.user_code = user_code;
            return this;
        }

        public String getID() {
            return ID;
        }

        public body setID(String ID) {
            this.ID = ID;
            return this;
        }

        public String getImage() {
            return image;
        }

        public body setImage(String image) {
            this.image = image;
            return this;
        }

        public String getCashTeamCode() {
            return CashTeamCode;
        }

        public body setCashTeamCode(String cashTeamCode) {
            CashTeamCode = cashTeamCode;
            return this;
        }
    }
}
