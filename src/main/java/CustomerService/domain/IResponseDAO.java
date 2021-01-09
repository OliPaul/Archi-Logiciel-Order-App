package CustomerService.domain;

import Customer.domain.Response;

import java.util.List;

public interface IResponseDAO {

    //Delete responses in file
    List<List<Response>> deleteResponse(List<List<Response>> responseList);
    //Retrieve responses from file
    List<List<Response>> getResponse();
}
