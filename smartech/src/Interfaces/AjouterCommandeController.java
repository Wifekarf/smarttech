/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import models.Commandee;
import models.Utilisateurs;
import service.CommandeeService;

public class AjouterCommandeController implements Initializable {

    @FXML
    private TextField AjouterService;
    @FXML
    private DatePicker AjouterDate; // Champ pour la date
    @FXML
    private TextField AjouterUserId; // Champ pour l'identifiant de l'utilisateur

    @FXML
    private Button ConfirmerCommande;

    private CommandeeService commandeeService;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ConfirmerCommande.setOnAction((ActionEvent event) -> {
            commandeeService = new CommandeeService();
            try {
                // Récupérer les valeurs des champs de texte
                String service = AjouterService.getText();
                LocalDate date = AjouterDate.getValue();
                int userId = Integer.parseInt(AjouterUserId.getText());
                
                // Créer une nouvelle commande avec les valeurs collectées
                Commandee nouvelleCommande = new Commandee();
                nouvelleCommande.setService(service);
                nouvelleCommande.setDate(date);
                
                Utilisateurs utilisateur = new Utilisateurs();
                utilisateur.setId(userId);
                nouvelleCommande.setUtilisateur(utilisateur);
                
                // Ajouter la nouvelle commande à la base de données
                commandeeService.ajouterCommandee(nouvelleCommande);
            } catch (NumberFormatException ex) {
                Logger.getLogger(AjouterCommandeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                // Recharger la page d'ajout de commande après confirmation
                ConfirmerCommande.getScene().setRoot(FXMLLoader.load(getClass().getResource("AjouterCommande.fxml")));
            } catch (IOException ex) {
                Logger.getLogger(AjouterCommandeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}


////    @FXML
//    private void btnAnnulerClicked(ActionEvent event) {
//        // Clear input fields or handle cancel action.
//         if (AjouterService != null) {
//            AjouterService.clear(); // Vous pouvez effectuer d'autres actions ici si nécessaire.
//        }
//    }
//
//    @FXML
//    private void btnConfirmerCommandeClicked(ActionEvent event) {
//        // Assurez-vous que AjouterService n'est pas null avant de l'utiliser.
//        if (AjouterService != null) {
//            String service = AjouterService.getText();
//            Utilisateurs utilisateur = new Utilisateurs(); // Vous devez initialiser un utilisateur.
//            LocalDate date = LocalDate.now(); // Vous devez obtenir la date souhaitée.
//
//            Commandee commandee = new Commandee(0, utilisateur, service, date);
//
//            commandeeService.ajouterCommandee(commandee);
//
//            // Vous pouvez effectuer d'autres actions ici si nécessaire.
//            AjouterService.clear();
//        }
//        // Call a method to refresh the view (if needed).
//        refreshCommandeView();
//    }
//
//    private void btnRefreshCommandeClicked(ActionEvent event) {
//        // Refresh your view or table of Commandees.
//        refreshCommandeView();
//    }
//
//    private void refreshCommandeView() {
//        // Implement logic to refresh the Commandee list in your JavaFX table or UI components.
//        // You can retrieve data from the CommandeeService and update your UI accordingly.
//    }
//
//    @FXML
//    private void btnAfficherCommandeClicked(ActionEvent event) {
//    }

