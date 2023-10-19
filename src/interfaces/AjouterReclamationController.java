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
import javafx.scene.image.ImageView;
import models.Reclamation;
import models.Utilisateurs;
import services.ServiceReclamation;
import services.ServiceUtilisateurs;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class AjouterReclamationController implements Initializable {

    @FXML
    private TextField fxobjet;
    @FXML
    private TextField fxdescription;
    @FXML
    private TextField fxid_user;
    @FXML
    private TextField fxdate;
    @FXML
    private Button fxajouterrec;
    @FXML
    private TextField fxetat;
    @FXML
    private ImageView fximage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void add(ActionEvent event) {
        String objet = fxobjet.getText();
        String description = fxdescription.getText();
        String date = fxdate.getText();
        String etat = fxetat.getText();

        if (fxid_user.getText().isEmpty() || objet.isEmpty() || date.isEmpty() || description.isEmpty()) {
            afficherMessageErreur("Veuillez remplir tous les champs.");
            return;
        }

        // Utilisez un service pour ajouter la réclamation
        ServiceReclamation serviceReclamation = new ServiceReclamation();

        // Récupérez l'ID de l'utilisateur sous forme de chaîne depuis le champ fxid_user
        String id_user_str = fxid_user.getText();

        try {
            // Convertissez l'ID de l'utilisateur en entier
            int id_user = Integer.parseInt(id_user_str);

            // Récupérez l'utilisateur associé à cet ID (assurez-vous que l'utilisateur existe)
           int userId = id_user;
            ServiceUtilisateurs serviceUtilisateurs = new ServiceUtilisateurs();
Utilisateurs utilisateur = serviceUtilisateurs.getUserById(userId);

            if (utilisateur != null) {
    // L'utilisateur a été trouvé, vous pouvez maintenant utiliser les propriétés de l'objet utilisateur
    System.out.println("Utilisateur trouvé : " + utilisateur.getNom());
} else {
    System.out.println("Aucun utilisateur trouvé avec l'ID spécifié.");
}

            // Ajoutez la réclamation avec l'utilisateur associé
            boolean ajoutReussi = serviceReclamation.ajouterReclamation(new Reclamation(description, utilisateur, objet, date,etat));

            if (ajoutReussi) {
                afficherMessageInformation("Réclamation ajoutée avec succès.");
                fxobjet.clear();
                fxdescription.clear();
                fxid_user.clear();
                fxdate.clear();
                fxetat.clear();
            } else {
                afficherMessageErreur("Échec de l'ajout de la réclamation.");
            }
        } catch (NumberFormatException e) {
            afficherMessageErreur("L'ID de l'utilisateur doit être un nombre entier.");
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

