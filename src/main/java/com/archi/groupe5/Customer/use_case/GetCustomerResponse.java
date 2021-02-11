package com.archi.groupe5.Customer.use_case;

import com.archi.groupe5.Customer.domain.Responses;
import com.archi.groupe5.Customer.domain.Response;
import com.archi.groupe5.Customer.domain.ResponseDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetCustomerResponse {

    private final ResponseDAO responseDAO;

    public GetCustomerResponse(ResponseDAO responseDAO) {
        this.responseDAO = responseDAO;
    }

    public List<Response> execute(String userID) {
        List<List<Response>> responseList = responseDAO.getResponse();
        Responses getResponse = new Responses(responseList);

        List<Response> responses = getResponse.checkIfCustomerHasResponse(userID);

        return responses;
    }
}
