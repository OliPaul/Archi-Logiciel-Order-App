package com.archi.groupe5.Customer.use_case;

import com.archi.groupe5.Customer.domain.Response;

import java.util.List;

public interface IResponse {

    String storeCustomerResponse(List<Response> responseList);
    List<Response> getCustomerResponse(String userID);
}
