package com.archi.groupe5.CustomerService.use_case;

import com.archi.groupe5.Customer.domain.Response;

import java.util.List;

public interface IResponse {

    List<List<Response>> getAllResponses();
    List<List<Response>> getLastResponses();
    List<List<Response>> deleteResponses();
}
