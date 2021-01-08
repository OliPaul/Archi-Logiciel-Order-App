package CustomerService.infra.controller;

import CustomerService.domain.Response;
import CustomerService.use_case.IResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerServiceController {

    private final IResponse iResponse;

    public CustomerServiceController(IResponse iResponse) {
        this.iResponse = iResponse;
    }

    @GetMapping("/customerservice/responses/all")
    public ResponseEntity<List<Response>> computeInterest() {
        final List<Response> responseList = iResponse.getAllResponses();

        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }
}
