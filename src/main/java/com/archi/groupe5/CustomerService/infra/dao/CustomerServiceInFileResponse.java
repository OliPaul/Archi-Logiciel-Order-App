package com.archi.groupe5.CustomerService.infra.dao;

import com.archi.groupe5.Customer.domain.Response;
import com.archi.groupe5.CustomerService.domain.ResponseDAO;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class CustomerServiceInFileResponse implements ResponseDAO {

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
