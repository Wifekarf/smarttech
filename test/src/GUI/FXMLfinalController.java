package GUI;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Panier;

public class FXMLfinalController implements Initializable {

    @FXML
    private TextField tfadressefinal;
    @FXML
    private Button btnok;

    private Stage stage;
    private Panier cart;
    @FXML
    private Button btnreturrrn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialization code goes here
    }

    // Add a method to set the stage
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    // Add a method to set the cart
    public void setCart(Panier cart) {
        this.cart = cart;
    }

    @FXML
    private void onOkButtonClick() {
        // Handle the "OK" button click here
        sendConfirmationSms();

        showConfirmationWarning();
    }

    private void sendConfirmationSms() {
        // Replace with your Twilio Account SID and Auth Token
        String twilioAccountSid = "AC15afdb9a8e4bfd9aae28ee44a2e57cf6";
        String twilioAuthToken = "4d9d2442b8c8a30c119d80bea27940ff";

        Twilio.init(twilioAccountSid, twilioAuthToken);

        // Replace with your Twilio phone numbers
        String fromPhoneNumber = "+13347216512";
        String toPhoneNumber = "+21654487169";

        // Send the SMS
        Message message = Message.creator(
            new PhoneNumber(toPhoneNumber), // Recipient's phone number
            new PhoneNumber(fromPhoneNumber), // Your Twilio phone number
            "Merci de choisir Smartech,Votre commande a passé avec succès,la laivraison est a 48h." // SMS message
        ).create();

        // Check for errors in message creation
        if (message.getSid() != null) {
            System.out.println("SMS sent successfully with SID: " + message.getSid());
        } else {
            System.out.println("Failed to send SMS.");
        }
    }

    private void showConfirmationWarning() {
        Alert warning = new Alert(AlertType.WARNING);
        warning.setTitle("Confirmation");
        warning.setHeaderText("Votre commande a passé avec succès.");
        warning.showAndWait();
    }

    @FXML
    private void onBackToClick(ActionEvent event) {
        
    try {
        // Load the FXMLProduit view
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLacceuil.fxml"));
        Parent root = loader.load();

        // Get the controller of the FXMLProduit view
        FXMLacceuilController acceuilController = loader.getController();

        // Set the stage in the FXMLProduit controller
        Stage newStage = new Stage(); // Create a new stage for the new scene
        acceuilController.setStage(newStage);

        // Set the FXMLProduit view as the new scene on the new stage
        newStage.setScene(new Scene(root));
        newStage.show(); // Show the new stage

        // Close the current stage
        Stage currentStage = (Stage) btnreturrrn.getScene().getWindow();
        currentStage.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    }

