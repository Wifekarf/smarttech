package Interfaces;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import models.Commandee;
import service.CommandeeService;

public class SupprimerCommandeController implements Initializable {

    @FXML
    private TextField CommandeIdTextField;

    private CommandeeService commandeService;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Définissez un gestionnaire d'événements pour le bouton de suppression
        commandeService = new CommandeeService();
        ConfirmerSuppression.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    // Récupérez l'ID de la commande à supprimer
                    int commandeId = Integer.parseInt(CommandeIdTextField.getText());

                    // Créez une instance de Commande avec l'ID
                    Commandee commandeASupprimer = new Commandee();
                    commandeASupprimer.setId(commandeId);

                    // Appelez la méthode de service pour supprimer la commande
                    commandeService.supprimerCommandee(commandeASupprimer);
                    
                    // Vous pouvez ajouter un message de succès ici

                } catch (Exception ex) {
                    Logger.getLogger(SupprimerCommandeController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    @FXML
    private Button ConfirmerSuppression; // Ajoutez cette ligne
}
