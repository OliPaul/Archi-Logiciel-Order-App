package com.archi.groupe5.CustomerService.use_case;

import com.archi.groupe5.Customer.domain.Response;
import com.archi.groupe5.CustomerService.domain.IResponseDAO;
import com.archi.groupe5.CustomerService.domain.ResponseProcessing;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CSResponsesUseCase implements IResponse {

    private final IResponseDAO IResponseDAO;

    public CSResponsesUseCase(IResponseDAO IResponseDAO) {
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
