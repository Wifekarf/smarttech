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
import models.Reclamation;
import services.ServiceReclamation;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class ModifierReclamationController implements Initializable {

    @FXML
    private TextField fxid;
    @FXML
    private TextField fxdescription;
    @FXML
    private Button fxmodifier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void updaterec(ActionEvent event) {
         String description = fxdescription.getText();
        String fxidText = fxid.getText();
int reclamationId = Integer.parseInt(fxidText);
         
         
         
          // Vérifiez que l'ID n'est pas vide
   
         
         
         
         
          // Vérifiez que la description n'est pas vide et ne dépasse pas 100 caractères
    if (description.isEmpty()) {
        afficherMessageErreur("La description ne peut pas être vide.");
    } else if (description.length() > 100) {
        afficherMessageErreur("La description ne doit pas dépasser 100 caractères.");
    } else  if (fxidText.isEmpty()) {
    } else {
        afficherMessageErreur("Veuillez saisir l'ID de la réclamation.");
        
        
       

    // Utilisez un service pour vérifier l'existence de la réclamation
    ServiceReclamation serviceReclamation = new ServiceReclamation();
    Reclamation existingReclamation = serviceReclamation.getReclamationById(reclamationId);

    if (existingReclamation != null) {
        // La réclamation existe, vous pouvez maintenant effectuer la mise à jour
        // Créez une instance de Reclamation avec les nouvelles valeurs
        Reclamation reclamation = new Reclamation();
        reclamation.setId_rec(reclamationId);
        reclamation.setDescription(description);
        // ... d'autres attributs de la réclamation

        // Appelez la méthode de mise à jour de votre service
        boolean modificationReussie = serviceReclamation.modifierReclamation(reclamation);

        // Affichez un message à l'utilisateur en fonction du résultat de la modification
        if (modificationReussie) {
            afficherMessageInformation("Réclamation modifiée avec succès.");
            fxdescription.clear();
        } else {
            afficherMessageErreur("Échec de la modification de la réclamation. Vérifiez l'existence de la réclamation.");
        }
    } else {
        afficherMessageErreur("La réclamation avec l'ID donné n'existe pas.");
    }
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
