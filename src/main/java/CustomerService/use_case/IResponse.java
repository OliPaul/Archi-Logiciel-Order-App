package CustomerService.use_case;

import Customer.domain.Response;

import java.util.List;

public interface IResponse {

    List<List<Response>> getAllResponses();
    List<List<Response>> getLastResponses();
    List<List<Response>> deleteResponses();
}
