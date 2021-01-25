package com.archi.groupe5.Customer.use_case;

import com.archi.groupe5.Customer.domain.Response;
import com.archi.groupe5.Customer.domain.ResponseDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class StoreCustomerResponse {

    private final ResponseDAO responseDAO;

    public StoreCustomerResponse(ResponseDAO responseDAO) {
        this.responseDAO = responseDAO;
    }

    public String execute(List<HashMap<String, String>> customerResponsesList){
        List<Response> responseList = new ArrayList<>();
        AtomicReference<Boolean> hasNoResponseToOrder = new AtomicReference<>(false);
        Date dateResponse = new Date();
        String mailToCustomer = "";


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
            mailToCustomer = "Vous n'avez pas répondu à au moins une commande.";
        }else{
            mailToCustomer = responseDAO.storeResponse(responseList);
        }

        return mailToCustomer;
    }
}
