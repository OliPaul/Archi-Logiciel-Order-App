package com.archi.groupe5.Customer.infra.controller;

import com.archi.groupe5.Customer.domain.Response;
import com.archi.groupe5.Customer.use_case.GetCustomerResponse;
import com.archi.groupe5.Customer.use_case.StoreCustomerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@RestController
public class CustomerController {

    private final GetCustomerResponse getCustomerResponse;
    private final StoreCustomerResponse storeCustomerResponse;

    public CustomerController(GetCustomerResponse getCustomerResponse, StoreCustomerResponse storeCustomerResponse) {
        this.getCustomerResponse = getCustomerResponse;
        this.storeCustomerResponse = storeCustomerResponse;
    }

    @PostMapping("/customer/responses/{id}")
    public ResponseEntity<String> storeResponses(@RequestBody List<HashMap<String, String>> customerResponsesList, @PathVariable(required = true, name = "id") String userID){
        List<Response> responseList = new ArrayList<>();
        Date dateResponse = new Date();
        AtomicReference<Boolean> hasNoResponseToOrder = new AtomicReference<>(false);
        String responseText = "";

        //Parcourir la data reçue dans le body et l'affecter à notre liste de réponses
        customerResponsesList.forEach((map) -> {

            // ce contrôle doit ce faire dans la class Responses, c'est un invariant domain
            // vous devez envoyer tous les réponses dans le domain qui va valider la cohérence des données
            // si jamais c'est pas un controller http qui fait appel au use case
            // il va falloir recoder cette vérification
            //Si on a une réponse qui n'est pas définie, on interrompt la boucle
            if(map.get("answer").equals("undefined")){
                hasNoResponseToOrder.set(true);
                return;
            }

            responseList.add(new Response(map.get("id").toString(), map.get("price").toString(), userID, map.get("answer"), dateResponse));
        });

        //Mantenant on stocke ces reponses dans notre fichier de réponses et on retourne un message à l'utilisateur
        responseText = hasNoResponseToOrder.get() ? "Vous n'avez pas répondu à au moins une réponse." : storeCustomerResponse.execute(responseList);
        return new ResponseEntity<>(responseText, HttpStatus.OK);
    }

    @GetMapping("/customer/responses/{id}")
    public ResponseEntity<List<Response>> displayResponses(@PathVariable(required = true, name = "id") String userID){
        List<Response> responseList = getCustomerResponse.execute(userID);

        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }
}
