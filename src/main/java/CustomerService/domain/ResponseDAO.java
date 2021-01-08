package CustomerService.domain;

import java.util.List;

public interface ResponseDAO {

    //Store responses in file
    List<Response> storeResponse(List<Response> responseList);
    //Retrieve responses from file
    List<Response> getResponse();
}
