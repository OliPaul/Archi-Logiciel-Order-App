package CustomerService.domain;

import java.util.Date;

public class Response {

    private int id;
    private String userId;
    private String answer;
    private Date time;

    public Response(int id, String userId, String answer, Date time) {
        this.id = id;
        this.userId = userId;
        this.answer = answer;
        this.time = time;
    }
}
