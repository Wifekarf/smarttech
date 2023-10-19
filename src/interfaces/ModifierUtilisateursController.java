/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
public class ModifierUtilisateursController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   


    @FXML
    private TextField fxemail;

    @FXML
    private TextField fxmdp;

    @FXML
    private Button fxmodifier;

    @FXML
    private TextField fxnom;

    @FXML
    private TextField fxprenom;

    @FXML
    void update(ActionEvent event) {
         String nom = fxnom.getText();
        String prenom = fxprenom.getText();
        String email = fxemail.getText();
        String mdp = fxmdp.getText();
         

        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || mdp.isEmpty() ) {
        afficherMessageErreur("Veuillez remplir tous les champs.");
        return;
    }

    // Vérifiez que le mot de passe contient au moins 8 caractères
    if (mdp.length() < 8) {
        afficherMessageErreur("Le mot de passe doit contenir au moins 8 caractères.");
        return;
    }

    // Utilisez un service pour mettre à jour l'utilisateur
    ServiceUtilisateurs serviceUtilisateurs = new ServiceUtilisateurs();
    boolean modificationReussie = serviceUtilisateurs.modifierUser(new Utilisateurs(nom, prenom, email, mdp, ""));

    // Affichez un message à l'utilisateur en fonction du résultat de la modification
    if (modificationReussie) {
        afficherMessageInformation("Utilisateur modifié avec succès.");
        fxnom.clear();
        fxprenom.clear();
        fxemail.clear();
        fxmdp.clear();
        
    } else {
        afficherMessageErreur("Échec de la modification de l'utilisateur. Vérifiez l'existence de l'utilisateur.");
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








    
        // Récupérez les valeurs saisies par l'utilisateur 
       
        
 

