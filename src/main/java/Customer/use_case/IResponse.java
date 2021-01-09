package Customer.use_case;

import Customer.domain.Response;

import java.util.List;

public interface IResponse {

    String storeCustomerResponse(List<Response> responseList);
    List<Response> getCustomerResponse(String userID);
}
