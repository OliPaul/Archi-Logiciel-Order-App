package CustomerService.domain;

import Customer.domain.Response;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ResponseProcessing {

    List<List<Response>> responseList = null;

    public ResponseProcessing(List<List<Response>> responseList) {
        this.responseList = responseList;
    }

    public List<List<Response>> getLast(){

        List<List<Response>> tempResponseList = null;
        List<List<Response>> finalResponseList = null;
        AtomicReference<String> elementProcessed = new AtomicReference<>("");

        responseList.forEach((responses) -> {
            if(!elementProcessed.equals(responses.get(0).getUserId())){
                elementProcessed.set(responses.get(0).getUserId());
                responseList.forEach((allResponses) -> {
                    if(allResponses.get(0).getUserId().equals(elementProcessed)){
                        tempResponseList.add(allResponses);
                    }
                });

                finalResponseList.add(tempResponseList.get(tempResponseList.size() - 1));
            }

        });

        return finalResponseList;
    }

    public List<List<Response>> deleteResponse(){
        responseList.forEach((responses -> {
            responses.forEach((order -> {
                order.setAnswer("undefined");
            }));
        }));

        return responseList;
    }
}
