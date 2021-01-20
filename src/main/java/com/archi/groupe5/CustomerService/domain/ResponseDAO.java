package com.archi.groupe5.CustomerService.domain;

import com.archi.groupe5.Customer.domain.Response;

import java.util.List;

public interface ResponseDAO {

    //Delete responses in file
    List<List<Response>> deleteResponse(List<List<Response>> responseList);
    //Retrieve responses from file
    List<List<Response>> getResponse();
}
