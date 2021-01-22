package com.archi.groupe5.Customer.use_case;

import com.archi.groupe5.Customer.domain.Responses;
import com.archi.groupe5.Customer.domain.Response;
import com.archi.groupe5.Customer.domain.ResponseDAO;

import java.util.List;

public class GetCustomerResponse {

    private final ResponseDAO responseDAO;

    public GetCustomerResponse(ResponseDAO responseDAO) {
        this.responseDAO = responseDAO;
    }

    public List<Response> execute(String userID) {
        List<List<Response>> responseList = responseDAO.getResponse();
        Responses getResponse = new Responses(responseList);

        // pourquoi faire cet appel ici quand on récupère les réponses de l'utilisateur ?
        // c'est plutôt lors du store qu'il faut valider l'invariant (toutes les commandes ont une seule réponse valide
        List<Response> responses = getResponse.checkIfCustomerHasResponse(userID);

        return responses;
    }
}
