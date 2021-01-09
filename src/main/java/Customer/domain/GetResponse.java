package Customer.domain;

import java.util.List;

public class GetResponse {

    List<List<Response>> responseList;

    public GetResponse(List<List<Response>> responseList) {
        this.responseList = responseList;
    }

    public List<Response> execute(String userID){

        List<List<Response>> tempResponsesList = null;

        if(responseList.equals(null)){
            //On récupère les datas depuis l'api et on ajoute aux résultats la clé answer avec "undefined" comme valeur et on retoune la liste
        }

        //Dans le cas ou on a une liste de réponses dans le fichier, on vérifie si l'utilisateur est bien dans la liste
        //Si c'est le cas on retourne sa derniere liste de réponses
        responseList.forEach((responses -> {
            responses.forEach((order -> {
                if(order.getUserId().equals(userID)){
                    tempResponsesList.add(responses);
                }
                return;
            }));
        }));

        //Sinon on récupère les datas depuis l'api et on ajoute aux résultats la clé answer avec "undefined" comme valeur et on retoune la liste

        return tempResponsesList.get(tempResponsesList.size() - 1);
    }
}
