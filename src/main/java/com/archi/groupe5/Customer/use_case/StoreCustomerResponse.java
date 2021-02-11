package com.archi.groupe5.Customer.use_case;

import com.archi.groupe5.Customer.domain.Response;
import com.archi.groupe5.Customer.domain.ResponseDAO;
import com.archi.groupe5.Customer.domain.Responses;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class StoreCustomerResponse {

    private final ResponseDAO responseDAO;

    public StoreCustomerResponse(ResponseDAO responseDAO) {
        this.responseDAO = responseDAO;
    }

    public String execute(List<HashMap<String, String>> customerResponsesList){

        Responses responses = new Responses();

        return responseDAO.storeResponse(responses.processing(customerResponsesList));
    }
}
