/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import models.Service;
import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;

/**
 *
 * @author ASUS
 */
public class SendSMS {
     public static final String ACCOUNT_SID = "AC334d825bae3dc8b8e439ed47ad166937";
    public static final String AUTH_TOKEN = "d6a47e9aab71397422c10d507a6de05d";

    public static void sendSMS(Service P) {
        Twilio.init("AC334d825bae3dc8b8e439ed47ad166937", "d6a47e9aab71397422c10d507a6de05d");

        String messageBody = "Nouvell apelle d'offre a service  ";
       com.twilio.rest.api.v2010.account.Message message = com.twilio.rest.api.v2010.account.Message.creator(
    new PhoneNumber("+21651775223"),
    new PhoneNumber("+16506009928"),
    messageBody
       
).create();

        System.out.println(message.getSid());
    }
}
    

