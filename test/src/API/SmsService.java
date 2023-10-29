package API;

import models.Panier;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsService {
     public static final String ACCOUNT_SID = "AC15afdb9a8e4bfd9aae28ee44a2e57cf6";
    public static final String AUTH_TOKEN = "4d9d2442b8c8a30c119d80bea27940ff";

    public static void sendSMS(Panier P) {
        Twilio.init("AC15afdb9a8e4bfd9aae28ee44a2e57cf6", "4d9d2442b8c8a30c119d80bea27940ff");

        String messageBody = "Nouvell apelle d'offre a service  ";
       com.twilio.rest.api.v2010.account.Message message = com.twilio.rest.api.v2010.account.Message.creator(
    new PhoneNumber("+21654487169"),
    new PhoneNumber("+13347216512"),
    messageBody
       
).create();

        System.out.println(message.getSid());
    }
}
