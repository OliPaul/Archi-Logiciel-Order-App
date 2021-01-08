package CustomerService.use_case;

import CustomerService.domain.Response;

import java.util.List;

public interface IResponse {

    List<Response> getAllResponses();
    List<Response> getLastResponses();
}
