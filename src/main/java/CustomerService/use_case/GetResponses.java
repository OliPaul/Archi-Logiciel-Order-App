package CustomerService.use_case;

import CustomerService.domain.Response;
import CustomerService.domain.ResponseDAO;

import java.util.List;

public class GetResponses implements IResponse{

    private final ResponseDAO responseDAO;

    public GetResponses(ResponseDAO responseDAO) {
        this.responseDAO = responseDAO;
    }

    @Override
    public List<Response> getAllResponses() {

        //Get responses list
        List<Response> allResponses = responseDAO.getResponse();
        return allResponses;
    }

    @Override
    public List<Response> getLastResponses() {
        return null;
    }
}
