package API;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Gmailer {
    private String username = "aya.mrade@gmail.com";
    private String password = "ejdr hwmi vcrg qhxy";
    private final Properties emailProperties = new Properties();

    public Gmailer() {
        loadEmailProperties();
    }

   private void loadEmailProperties() {
    try (FileInputStream input = new FileInputStream("C:src/API/email.properties")) {
        emailProperties.load(input);
        username = emailProperties.getProperty("mail.smtp.username");
        password = emailProperties.getProperty("mail.smtp.password");
    } catch (FileNotFoundException e) {
        System.err.println("Properties file not found");
    } catch (IOException e) {
        System.err.println("Error reading properties file");
    }
}



    public void saveEmailProperties() {
        String propertiesFilePath = "C:src/API/email.properties";
        try (FileOutputStream output = new FileOutputStream(propertiesFilePath)) {
            emailProperties.setProperty("mail.smtp.host", "your_SMTP_host");
            emailProperties.setProperty("mail.smtp.port", "your_SMTP_port");
            emailProperties.setProperty("mail.smtp.username", username);
            emailProperties.setProperty("mail.smtp.password", password);

            emailProperties.store(output, "Email Configuration");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMail(String to, String subject, String message) {
    String host = emailProperties.getProperty("mail.smtp.host");
    String port = emailProperties.getProperty("mail.smtp.port");
    // ... other email sending logic
    System.out.println("Sending email to: " + to);
    System.out.println("Host: " + host);
    System.out.println("Port: " + port);
    System.out.println("Subject: " + subject);
    System.out.println("Message: " + message);
}

}
