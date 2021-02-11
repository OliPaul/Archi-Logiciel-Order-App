package com.archi.groupe5.Customer.infra.dao;

import com.archi.groupe5.Customer.domain.Response;
import com.archi.groupe5.Customer.domain.ResponseDAO;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerInFileResponse implements ResponseDAO {

    public String storeResponse(List<Response> responses) {

        if(responses == null){
            return "Vous n\'avez pas répondu à au moins une commande.";
        }

        //Récupérer les réponses dans notre fichier de réponses.
        List<List<Response>> responsesList = this.getResponse() == null ? new ArrayList<>() : this.getResponse();

        responsesList.add(responses);
        //Write responses list in file
        try {
            File responsesFile = new File("responses.txt");
            FileOutputStream fos = new FileOutputStream(responsesFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            String jsonResponse = new Gson().toJson(responsesList);
            oos.writeObject(jsonResponse);
            oos.flush();
            oos.close();
            fos.close();

            return "Votre réponse a bien été prise en compte.";

        } catch (Exception e) {
            //Return error when write in file
            e.printStackTrace();
            return "Erreur lors de l'engistrement de votre réponse.";
        }


    }

    public List<List<Response>> getResponse() {
        //Read list of responses list in file
        List<List<Response>> responses = null;
        try {
            File responsesFile = new File("responses.txt");
            FileInputStream fis = new FileInputStream(responsesFile);
            ObjectInputStream ois = new ObjectInputStream(fis);

            if(ois.available() == 0){
                responses = (List<List<Response>>) new Gson().fromJson(ois.readObject().toString(), ArrayList.class);
            }

            ois.close();
            fis.close();

        } catch (Exception e) {
            //Return error when read in file
            e.printStackTrace();
            responses = null;
        }

        return responses;
    }
}
