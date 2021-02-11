package com.archi.groupe5.Customer.use_case;

import org.springframework.stereotype.Component;

@Component
public class SendEmail {

    public String execute(String message){
        return message;
    }
}

