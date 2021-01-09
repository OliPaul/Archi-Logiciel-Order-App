package com.archi.groupe5.Customer.infra.dao;

import com.archi.groupe5.Customer.domain.Response;
import com.archi.groupe5.Customer.domain.IResponseDAO;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CInFileResponse implements IResponseDAO {

    public String storeResponse(List<Response> responses) {

        System.out.println(responses.get(0).getId());

        //Récupérer les réponses dans notre fichier de réponses.
        List<List<Response>> responsesList = this.getResponse() == null ? new ArrayList<>() : this.getResponse();

        responsesList.add(responses);
        //Write responses list in file
        try {
            File responsesFile = new File("responses");
            FileOutputStream fos = new FileOutputStream(responsesFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(responsesList.toString());
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
            File responsesFile = new File("responses");
            FileInputStream fis = new FileInputStream(responsesFile);
            ObjectInputStream ois = new ObjectInputStream(fis);

            responses = (List<List<Response>>) ois.readObject();

            ois.close();
            fis.close();

        } catch (Exception e) {
            //Return error when write in file
            e.printStackTrace();
            responses = null;
        }

        return responses;
    }
}
