package Customer.infra.dao;

import Customer.domain.Response;
import Customer.domain.IResponseDAO;
import org.apache.commons.logging.Log;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class InFileResponse implements IResponseDAO {

    public String storeResponse(List<Response> responses) {

        //Récupérer les réponses dans notre fichier de réponses.
        List<List<Response>> responsesList = this.getResponse();

        responsesList.add(responses);
        //Write responses list in file
        try {
            File responsesFile = new File("responses");
            FileOutputStream fos = new FileOutputStream(responsesFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(responsesList);
            oos.flush();
            oos.close();
            fos.close();

            return "Votre réponse a bien été prise en compte.";

        } catch (Exception e) {
            //Return error when write in file
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
        }

        return responses;
    }
}
