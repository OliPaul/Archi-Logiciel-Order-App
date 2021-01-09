package CustomerService.infra.controller;

import Customer.domain.Response;
import CustomerService.use_case.IResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerServiceController {

    private final IResponse iResponse;

    public CustomerServiceController(IResponse iResponse) {
        this.iResponse = iResponse;
    }

    @GetMapping("/customerservice/responses/all")
    public ResponseEntity<List<List<Response>>> getAllResponses() {
        final List<List<Response>> responseList = iResponse.getAllResponses();

        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @GetMapping("/customerservice/responses/last")
    public ResponseEntity<List<List<Response>>> getLastResponses() {
        final List<List<Response>> responseList = iResponse.getLastResponses();

        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }
}
