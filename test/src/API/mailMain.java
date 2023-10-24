package API;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class mailMain {

    public static void main(String[] args) {
        String recipient = "aya.mrade@gmail.com";
        String subject = "Your Delivery";
        String message = "thank you for choosing smartech,your delivery has been added succesfully ! , you will receive your delivery next 48h";
        
        // Replace with your actual email subject and message
        new Gmailer().sendMail(recipient, subject, message);
    }
}
