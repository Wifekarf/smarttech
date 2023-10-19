/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import models.Utilisateurs;
import services.ServiceUtilisateurs;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class AjouterUtilisateursController implements Initializable {

    @FXML
    private AnchorPane fxajouter;
    @FXML
    private TextField fxmdp;
    @FXML
    private TextField fxemail;
    @FXML
    private TextField fxprenom;
    @FXML
    private TextField fxnom;
    @FXML
    private TextField fxrole;
    @FXML
    private Button fxajouet;

    /**
     * Initializes the controller class.
     */
  @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Créez une liste d'options pour le ComboBox (client et prestataire)
      
    }

    @FXML
    private void add(ActionEvent event) {
        String nom = fxnom.getText();
        String prenom = fxprenom.getText();
        String email = fxemail.getText();
        String mdp = fxmdp.getText();
      String role = fxrole.getText(); 

        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || mdp.isEmpty() || role == null) {
            afficherMessageErreur("Veuillez remplir tous les champs.");
            return;
        }
        
        if (mdp.length() < 8) {
            afficherMessageErreur("Le mot de passe doit contenir au moins 8 caractères.");
            return;
        }

        // Utilisez un service pour ajouter l'utilisateur
        ServiceUtilisateurs serviceUtilisateurs = new ServiceUtilisateurs();
        boolean ajoutReussi = serviceUtilisateurs.ajouterUser(new Utilisateurs(nom, prenom, email, mdp, role));

        if (ajoutReussi) {
            afficherMessageInformation("Utilisateur ajouté avec succès.");
            fxnom.clear();
            fxprenom.clear();
            fxemail.clear();
            fxmdp.clear();
             fxrole.clear();
        } else {
            afficherMessageErreur("Échec de l'ajout de l'utilisateur.");
        }
    }

   private void afficherMessageErreur(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void afficherMessageInformation(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
