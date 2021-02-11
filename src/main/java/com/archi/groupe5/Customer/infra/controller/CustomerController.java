package com.archi.groupe5.Customer.infra.controller;

import com.archi.groupe5.Customer.domain.Response;
import com.archi.groupe5.Customer.use_case.GetCustomerResponse;
import com.archi.groupe5.Customer.use_case.SendEmail;
import com.archi.groupe5.Customer.use_case.StoreCustomerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class CustomerController {

    private final GetCustomerResponse getCustomerResponse;
    private final StoreCustomerResponse storeCustomerResponse;
    private final SendEmail sendEmail;

    public CustomerController(GetCustomerResponse getCustomerResponse, StoreCustomerResponse storeCustomerResponse, SendEmail sendEmail) {
        this.getCustomerResponse = getCustomerResponse;
        this.storeCustomerResponse = storeCustomerResponse;
        this.sendEmail = sendEmail;
    }

    @PostMapping("/customer/responses/{id}")
    public ResponseEntity<String> storeResponses(@RequestBody List<HashMap<String, String>> customerResponsesList, @PathVariable(required = true, name = "id") String userID){
        String responseText = "";

        responseText = storeCustomerResponse.execute(customerResponsesList);
        //Send Email
        System.out.println(sendEmail.execute(responseText));
        return new ResponseEntity<>(responseText, HttpStatus.OK);
    }

    @GetMapping("/customer/responses/{id}")
    public ResponseEntity<List<Response>> displayResponses(@PathVariable(required = true, name = "id") String userID){
        List<Response> responseList = getCustomerResponse.execute(userID);

        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }
}
