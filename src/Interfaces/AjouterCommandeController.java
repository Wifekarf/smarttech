/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import models.Commandee;
import models.Service;
import models.Utilisateurs;
import services.CommandeeService;
import services.ServiceService;
import services.ServiceUtilisateurs;

public class AjouterCommandeController implements Initializable {

    @FXML
    private ComboBox<String> AjouterUserId;
    @FXML
    private ComboBox<String> AjouterService; // Change le type de ComboBox en String
    @FXML
    private DatePicker AjouterDate;
    @FXML
    private Button ConfirmerCommande;

    private CommandeeService commandeeService;
    private ServiceUtilisateurs utilisateursService;
    private ServiceService serviceService;
    @FXML
    private Button AnnulerrCommande;
    @FXML
    private Button AfficherCommande;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        commandeeService = new CommandeeService();
        utilisateursService = new ServiceUtilisateurs();
        serviceService = new ServiceService(); 
        
        

        // Remplir le ComboBox pour les utilisateurs à partir de la base de données
        fillUserComboBox();

        // Remplir le ComboBox pour les services à partir de la base de données
        fillServiceComboBox();

        ConfirmerCommande.setOnAction((ActionEvent event) -> {
            String selectedService = AjouterService.getValue();
            LocalDate date = AjouterDate.getValue();
            String selectedUserName = AjouterUserId.getValue();

            // Rechercher l'utilisateur par nom dans la base de données
            Utilisateurs utilisateur = utilisateursService.getUserByName(selectedUserName);

            if (utilisateur != null) {
                Commandee nouvelleCommande = new Commandee();
                nouvelleCommande.setService(selectedService);
                nouvelleCommande.setDate(date);
                nouvelleCommande.setUtilisateur(utilisateur);
                commandeeService.ajouterCommandee(nouvelleCommande);
            } else {
                System.out.println("Utilisateur non trouvé.");
            }

            try {
                // Recharger la page d'ajout de commande après confirmation
                ConfirmerCommande.getScene().setRoot(FXMLLoader.load(getClass().getResource("AjouterCommande.fxml")));
            } catch (IOException ex) {
                Logger.getLogger(AjouterCommandeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
     public void supprimerCommandesDepassees() {
        commandeeService.supprimerLignesDepassees();
    }
     
    private void fillServiceComboBox() {
        try {
            List<Service> services = serviceService.getAllServices();
            ObservableList<String> serviceItems = FXCollections.observableArrayList();

            for (Service service : services) {
                serviceItems.add(service.getNomService());
            }

            AjouterService.setItems(serviceItems);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void fillUserComboBox() {
        List<Utilisateurs> utilisateurs = utilisateursService.afficherUser();
        ObservableList<String> userItems = FXCollections.observableArrayList();
        for (Utilisateurs utilisateur : utilisateurs) {
            userItems.add(utilisateur.getNom());
        }
        AjouterUserId.setItems(userItems);
    }

    @FXML
    private void retourPage1(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Page1.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) ConfirmerCommande.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void AfficherCommande(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherCommades.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) ConfirmerCommande.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void AjouterService(ActionEvent event) {
        // Implémentez la logique pour ajouter un nouveau service si nécessaire
    }
}






