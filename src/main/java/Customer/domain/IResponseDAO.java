package Customer.domain;

import Customer.domain.Response;

import java.util.List;

public interface IResponseDAO {

    //Store responses in file
    String storeResponse(List<Response> responseList);
    //Retrieve responses from file
    List<List<Response>> getResponse();
}
