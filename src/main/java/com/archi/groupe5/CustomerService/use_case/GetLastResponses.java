package com.archi.groupe5.CustomerService.use_case;

import com.archi.groupe5.Customer.domain.Response;
import com.archi.groupe5.CustomerService.domain.ResponseDAO;
import com.archi.groupe5.CustomerService.domain.ResponseProcessing;

import java.util.List;

public class GetLastResponses {
    private final ResponseDAO ResponseDAO;

    public GetLastResponses(ResponseDAO responseDAO) {
        ResponseDAO = responseDAO;
    }

    public List<List<Response>> execute() {
        //Get responses list
        List<List<Response>> responses = ResponseDAO.getResponse();

        return new ResponseProcessing(responses).getLast();
    }
}
