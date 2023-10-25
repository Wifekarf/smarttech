package Interfaces;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import models.Commandee;
import services.CommandeeService;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ModifierCommandeController implements Initializable {

    @FXML
    private ComboBox<Commandee> AjouterIDcommande;
    @FXML
    private ComboBox<String> AjouterService; // Updated ComboBox type
    @FXML
    private DatePicker AjouterDate;
    @FXML
    private Button ModifierCommande;
    @FXML
    private Button annulerButton;

    private CommandeeService commandeeService;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        commandeeService = new CommandeeService();

        // Load existing commandes into the ComboBox
        AjouterIDcommande.getItems().setAll(commandeeService.afficherCommandes());

        // Initialize the AjouterService ComboBox with your service data
        // AjouterService.getItems().addAll("Service1", "Service2", "Service3"); // Replace with actual service data
    }

    @FXML
    private void ModifCommande(ActionEvent event) {
        Commandee selectedCommande = AjouterIDcommande.getValue();
        if (selectedCommande != null) {
            String nouveauService = AjouterService.getValue();
            LocalDate nouvelleDate = AjouterDate.getValue();

            // Update the selected command with the new values
            selectedCommande.setService(nouveauService);
            selectedCommande.setDate(nouvelleDate);

            // Call the modification method in the service
            commandeeService.modifierCommandee(selectedCommande, selectedCommande.getId());

            // Display a success message or handle errors
            System.out.println("Commande modifiée avec succès!");
        } else {
            System.out.println("Aucune commande sélectionnée.");
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
