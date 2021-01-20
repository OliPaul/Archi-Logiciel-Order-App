package com.archi.groupe5.Customer.domain;

import java.util.Date;

public class Response {

    private String id;
    private String price;
    private String userId;
    private String answer;
    private Date time;

    public Response(String id, String price, String userId, String answer, Date time) {
        this.id = id;
        this.price = price;
        this.userId = userId;
        this.answer = answer;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
