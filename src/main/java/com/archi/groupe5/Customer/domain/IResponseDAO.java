package com.archi.groupe5.Customer.domain;

import org.springframework.stereotype.Service;

import java.util.List;

public interface IResponseDAO {

    //Store responses in file
    String storeResponse(List<Response> responseList);
    //Retrieve responses from file
    List<List<Response>> getResponse();
}
