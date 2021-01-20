package com.archi.groupe5.Customer.domain;

import com.archi.groupe5.Customer.domain.Response;

import java.util.List;

public class Responses {

    List<List<Response>> responseList;

    public Responses(List<List<Response>> responseList) {
        this.responseList = responseList;
    }

    public List<Response> checkIfCustomerHasResponse(String userID){
        if(responseList.equals(null)){
            return customerHasNotResponse(userID);
        }

        return custommerHasResponse(userID);
    }

    public List<Response> custommerHasResponse(String userID) {
        List<List<Response>> tempResponsesList = null;

        responseList.forEach((responses -> {
            responses.forEach((order -> {
                if (order.getUserId().equals(userID)) {
                    tempResponsesList.add(responses);
                }
                return;
            }));
        }));

        return tempResponsesList.get(tempResponsesList.size() - 1);
    }

    public List<Response> customerHasNotResponse(String userID) {
        List<List<Response>> tempResponsesList = null;

        //On récupère les datas depuis l'api et on ajoute aux résultats la clé answer avec "undefined" comme valeur et on retoune la liste

        return tempResponsesList.get(tempResponsesList.size() - 1);

    }

}