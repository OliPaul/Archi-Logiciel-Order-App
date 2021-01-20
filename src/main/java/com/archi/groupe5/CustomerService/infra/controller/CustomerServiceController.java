package com.archi.groupe5.CustomerService.infra.controller;

import com.archi.groupe5.Customer.domain.Response;
import com.archi.groupe5.CustomerService.use_case.DeleteResponses;
import com.archi.groupe5.CustomerService.use_case.GetAllResponses;
import com.archi.groupe5.CustomerService.use_case.GetLastResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerServiceController {

    private final GetAllResponses getAllResponses;
    private final GetLastResponses getLastResponses;
    private final DeleteResponses deleteResponses;

    public CustomerServiceController(GetAllResponses getAllResponses, GetLastResponses getLastResponses, DeleteResponses deleteResponses) {
        this.getAllResponses = getAllResponses;
        this.getLastResponses = getLastResponses;
        this.deleteResponses = deleteResponses;
    }

    @GetMapping("/customerservice/responses/all")
    public ResponseEntity<List<List<Response>>> getAllResponses() {
        final List<List<Response>> responseList = getAllResponses.execute();

        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @GetMapping("/customerservice/responses/last")
    public ResponseEntity<List<List<Response>>> getLastResponses() {
        final List<List<Response>> responseList = getLastResponses.execute();

        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @GetMapping("/customerservice/responses/delete")
    public ResponseEntity<List<List<Response>>> deleteResponses() {
        final List<List<Response>> responseList = deleteResponses.execute();

        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }
}
