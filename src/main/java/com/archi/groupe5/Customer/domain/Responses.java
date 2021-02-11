package com.archi.groupe5.Customer.domain;

import com.archi.groupe5.Customer.domain.Response;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Responses {

    List<List<Response>> responseList;

    public Responses() { }

    public Responses(List<List<Response>> responseList) {
        this.responseList = responseList;
    }

    public List<Response> checkIfCustomerHasResponse(String userID){
        if(responseList == null){
            return customerHasNotResponse(userID);
        }

        return custommerHasResponse(userID);
    }

    public List<Response> custommerHasResponse(String userID) {
        List<List<Response>> tempResponsesList = new ArrayList<>();

        responseList.forEach((responses -> {

            ArrayList list = (ArrayList) responses;
            list.forEach((order -> {
                Response aResponse = new Gson().fromJson(new Gson().toJson(order), Response.class);
                if (aResponse.getUserId().equals(userID)) {
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

    public List<Response> processing(List<HashMap<String, String>> customerResponsesList){
        List<Response> responseList = new ArrayList<>();
        AtomicReference<Boolean> hasNoResponseToOrder = new AtomicReference<>(false);
        Date dateResponse = new Date();


        //Parcourir la data reçue et l'affecter à notre liste de réponses
        customerResponsesList.forEach((map) -> {

            //Si on a une réponse qui n'est pas définie, on interrompt la boucle
            if(map.get("answer").equals("undefined")){
                hasNoResponseToOrder.set(true);
                return;
            }

            responseList.add(new Response(map.get("id").toString(), map.get("price").toString(), map.get("userId").toString(), map.get("answer").toString(), dateResponse));
        });

        if(hasNoResponseToOrder.get().equals(true)){
            return null;
        }

        return responseList;
    }

}