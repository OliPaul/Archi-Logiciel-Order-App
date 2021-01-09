package CustomerService.use_case;

import Customer.domain.Response;
import CustomerService.domain.IResponseDAO;
import CustomerService.domain.ResponseProcessing;

import java.util.List;

public class Responses implements IResponse {

    private final IResponseDAO IResponseDAO;

    public Responses(IResponseDAO IResponseDAO) {
        this.IResponseDAO = IResponseDAO;
    }

    @Override
    public List<List<Response>> getAllResponses() {

        //Get responses list
        List<List<Response>> responses = IResponseDAO.getResponse();

        return responses;
    }

    @Override
    public List<List<Response>> getLastResponses() {
        //Get responses list
        List<List<Response>> responses = IResponseDAO.getResponse();

        return new ResponseProcessing(responses).getLast();
    }

    @Override
    public List<List<Response>> deleteResponses() {
        //Get responses list
        List<List<Response>> responses = IResponseDAO.getResponse();

        return IResponseDAO.deleteResponse(new ResponseProcessing(responses).deleteResponse());
    }
}
