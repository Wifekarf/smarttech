/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import models.Type_produit;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import services.Servicetype;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class FXMLajoutTypeController implements Initializable {
    
    @FXML
    private Button btnajouType;
    @FXML
    private TextField tfNom_type;
    @FXML
    private TextField tfDescription;
    
   

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    btnajouType.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            Servicetype st = new Servicetype();

            // Récupérer les données saisies
            String nomType = tfNom_type.getText();
            String description = tfDescription.getText();

            // Vérifier si les champs sont vides
            if (nomType.isEmpty() || description.isEmpty()) {
                // Afficher un message d'erreur (ou gérer l'erreur d'une autre manière)
                // Par exemple, en utilisant une boîte de dialogue
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erreur de saisie");
                alert.setHeaderText("Veuillez remplir tous les champs.");
                alert.showAndWait();
            } else {
                try {
                    st.ajouterType(new Type_produit(nomType, description));
                    // Naviguer vers la vue suivante (FXMLafficheType.fxml)
                    Parent root = FXMLLoader.load(getClass().getResource("FXMLafficheType.fxml"));
                    btnajouType.getScene().setRoot(root);
                } catch (Exception ex) {
                    Logger.getLogger(FXMLajoutTypeController.class.getName()).log(Level.SEVERE, null, ex);
                    // Gérer l'erreur d'une autre manière si nécessaire
                }
            }
        }
    });
    }
}