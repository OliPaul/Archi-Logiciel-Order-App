package com.archi.groupe5.Customer.use_case;

import com.archi.groupe5.Customer.domain.Response;
import com.archi.groupe5.Customer.domain.ResponseDAO;

import java.util.List;

public class StoreCustomerResponse {

    private final ResponseDAO responseDAO;

    public StoreCustomerResponse(ResponseDAO responseDAO) {
        this.responseDAO = responseDAO;
    }

    public String execute(List<Response> responseList){
        String mailToCustomer = responseDAO.storeResponse(responseList);

        return mailToCustomer;
    }
}
