package Customer.domain;

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

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
