/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import services.CommandeeService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Commandee;

public class SupprimerCommandeController implements Initializable {

    @FXML
    private ComboBox<Commandee> idCommandeField;
    @FXML
    private Button SupprimerCommande;
    private Label messageLabel;

    private CommandeeService commandeeService;
    @FXML
    private Button annulerButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        commandeeService = new CommandeeService();
        try {
            // Fetch the list of Commandee objects
            idCommandeField.getItems().setAll(commandeeService.afficherCommandes());
        } catch (Exception e) {
            // Handle exceptions gracefully, for example, by showing an error message
            e.printStackTrace(); // You can replace this with proper error handling
        }
    }

    @FXML
private void SuppCommande(ActionEvent event) {
    Commandee selectedCommande = idCommandeField.getValue();

    if (selectedCommande != null) {
        int idCommande = selectedCommande.getId(); // Get the ID of the selected Commandee
        commandeeService.supprimerCommandee(idCommande);
        messageLabel.setText("Commande supprimée avec succès !");
    } else {
        messageLabel.setText("Veuillez sélectionner une commande.");
    }
}

    @FXML
    private void retourPage1(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Page1.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) annulerButton.getScene().getWindow(); // Obtient la fenêtre actuelle
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
   
    }

}
