package CustomerService.infra.dao;

import Customer.domain.Response;
import CustomerService.domain.IResponseDAO;

import java.io.*;
import java.util.List;

public class InFileResponse implements IResponseDAO {

    public List<List<Response>> deleteResponse(List<List<Response>> responseList) {
        //Write responses list in file
        try {
            File responsesFile = new File("responses");
            FileOutputStream fos = new FileOutputStream(responsesFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(responseList);
            oos.flush();
            oos.close();
            fos.close();

        } catch (Exception e) {
            //Return error when write in file
            return null;
        }

        return responseList;
    }

    public List<List<Response>> getResponse() {
        //Read responses list in file
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
        }

        return responses;
    }
}
