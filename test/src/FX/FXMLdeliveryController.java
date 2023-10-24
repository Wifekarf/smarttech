/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FX;

import Service.LivraisonService;
import models.Livraison;

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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLdeliveryController implements Initializable {

    @FXML
    private Button btnajout;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tfadresse;
    @FXML
    private TextField tfprix;
    @FXML
    private TextField tfnbrecom;
    @FXML
    private Label remarqueLabel;
    @FXML
    private Button btnmodifier;
    @FXML
    private Label modifierLabel;

    private Livraison selectedLivraisonToModify;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnajout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LivraisonService livraisonService = new LivraisonService();
                try {
                    Livraison livraison = new Livraison(tfnom.getText(), tfprenom.getText(), tfadresse.getText(), (int) Double.parseDouble(tfprix.getText()), Integer.parseInt(tfnbrecom.getText()));
                    livraisonService.ajouterLivraison(livraison);
                    // Set the text of the remarqueLabel after a successful addition
                    remarqueLabel.setText("Delivery added");

                    // Load the next FXML file (FXMLafficherDelivery.fxml) after addition
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLafficherDelivery.fxml"));
                    Parent root = loader.load();
                    btnajout.getScene().setRoot(root);
                } catch (SQLException | IOException ex) {
                    Logger.getLogger(FXMLdeliveryController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btnmodifier.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LivraisonService livraisonService = new LivraisonService();
                try {
                    Livraison livraisonToUpdate = new Livraison(
                        tfnom.getText(),
                        tfprenom.getText(),
                        tfadresse.getText(),
                        (int) Double.parseDouble(tfprix.getText()),
                        Integer.parseInt(tfnbrecom.getText())
                    );

                    if (selectedLivraisonToModify != null) {
                        // Set the ID of the Livraison object you want to update
                        livraisonToUpdate.setID(selectedLivraisonToModify.getID());

                        livraisonService.modifierLivraison(livraisonToUpdate);
                        modifierLabel.setText("Delivery modified");

                        // Load the next FXML file (FXMLafficherDelivery.fxml) after modification
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLafficherDelivery.fxml"));
                        Parent root = loader.load();
                        btnmodifier.getScene().setRoot(root);
                    }
                } catch (SQLException | IOException ex) {
                    Logger.getLogger(FXMLdeliveryController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    void setLivraison(Livraison selectedLivraisonToModify) {
        this.selectedLivraisonToModify = selectedLivraisonToModify;

        // Display the details of the selectedLivraisonToModify in the input fields
        tfnom.setText(selectedLivraisonToModify.getNom());
        tfprenom.setText(selectedLivraisonToModify.getPrenom());
        tfadresse.setText(selectedLivraisonToModify.getAdresse());
        tfprix.setText(String.valueOf(selectedLivraisonToModify.getPrix()));
        tfnbrecom.setText(String.valueOf(selectedLivraisonToModify.getNbreCommandes()));
    }
}
