package Customer.use_case;

import Customer.domain.GetResponse;
import Customer.domain.IResponseDAO;
import Customer.domain.Response;

import java.util.List;

public class Responses implements IResponse {

    private final IResponseDAO iResponseDAO;


    public Responses(IResponseDAO iResponseDAO) {
        this.iResponseDAO = iResponseDAO;
    }

    @Override
    public String storeCustomerResponse(List<Response> responseList) {
        String mailToCustomer = iResponseDAO.storeResponse(responseList);

        return mailToCustomer;
    }

    @Override
    public List<Response> getCustomerResponse(String userID) {
        List<List<Response>> responseList = iResponseDAO.getResponse();
        GetResponse getResponse = new GetResponse(responseList);

        List<Response> responses = getResponse.execute(userID);

        return responses;
    }
}
