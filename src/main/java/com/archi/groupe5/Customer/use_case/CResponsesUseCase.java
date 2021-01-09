package com.archi.groupe5.Customer.use_case;

import com.archi.groupe5.Customer.domain.GetResponse;
import com.archi.groupe5.Customer.domain.IResponseDAO;
import com.archi.groupe5.Customer.domain.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CResponsesUseCase implements IResponse {

    private final IResponseDAO iResponseDAO;


    public CResponsesUseCase(IResponseDAO iResponseDAO) {
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
