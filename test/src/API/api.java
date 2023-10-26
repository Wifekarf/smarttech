/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package API;
//
//import java.net.*;
//import java.util.Base64;
//import java.io.*;
//
//public class api {
//    public void sms(String username, String password, String to, String message) {
//        try {
//            String myURI = "https://api.bulksms.com/v1/messages";
//
//            // Change these values to match your own account
//            String myUsername = "eyamrad";
//            String myPassword = "050MA755eya";
//
//            // The details of the message we want to send
//            String myData = "{to: \"" + to + "\", encoding: \"UNICODE\", body: \"" + message + "\"}";
//
//            // Build the request based on the supplied settings
//            URL url = new URL(myURI);
//            HttpURLConnection request = (HttpURLConnection) url.openConnection();
//            request.setDoOutput(true);
//
//            // Supply the credentials
//            String authStr = myUsername + ":" + myPassword;
//            String authEncoded = Base64.getEncoder().encodeToString(authStr.getBytes());
//            request.setRequestProperty("Authorization", "Basic " + authEncoded);
//
//            // We want to use HTTP POST
//            request.setRequestMethod("POST");
//            request.setRequestProperty("Content-Type", "application/json");
//
//            // Write the data to the request
//            try (OutputStreamWriter out = new OutputStreamWriter(request.getOutputStream())) {
//                out.write(myData);
//            }
//
//            // Try ... catch to handle errors nicely
//            try (InputStream response = request.getInputStream()) {
//                BufferedReader in = new BufferedReader(new InputStreamReader(response));
//                String replyText;
//                while ((replyText = in.readLine()) != null) {
//                    System.out.println(replyText);
//                }
//            } catch (IOException ex) {
//                System.out.println("An error occurred: " + ex.getMessage());
//                try (BufferedReader in = new BufferedReader(new InputStreamReader(request.getErrorStream()))) {
//                    // Print the details that come with the error
//                    String replyText;
//                    while ((replyText = in.readLine()) != null) {
//                        System.out.println(replyText);
//                    }
//                }
//            }
//            request.disconnect();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//}
