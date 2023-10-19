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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.Utilisateurs;
import services.ServiceUtilisateurs;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class SupprimerUtilisateursController implements Initializable {

    @FXML
    private TextField fxid;
    @FXML
    private Button fxsupprimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void delete(ActionEvent event) {
         String idText = fxid.getText();

        // Vérifiez si le champ d'ID est vide
        if (idText.isEmpty()) {
            afficherMessageErreur("Veuillez saisir l'ID de l'utilisateur.");
            return; // Arrêtez l'opération si le champ est vide
        }

        
            // Convertissez l'ID en entier (vous pouvez également gérer les erreurs ici)
            int id = Integer.parseInt(idText);

            // Utilisez un service pour supprimer l'utilisateur
            ServiceUtilisateurs serviceUtilisateurs = new ServiceUtilisateurs();
            boolean  suppressionReussie = serviceUtilisateurs.deleteUser(new Utilisateurs( id, "", "", "", "", ""));

            // Affichez un message à l'utilisateur en fonction du résultat de la suppression
            if (suppressionReussie) {
                afficherMessageInformation("Utilisateur supprimé avec succès.");
                fxid.clear(); // Effacez le champ d'ID après la suppression
            } else {
                afficherMessageErreur("Échec de la suppression de l'utilisateur. Vérifiez l'ID.");
            }
        }

    
    

    // Méthode pour afficher une boîte de dialogue d'erreur
    private void afficherMessageErreur(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Méthode pour afficher une boîte de dialogue d'information
    private void afficherMessageInformation(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    

    }
    

