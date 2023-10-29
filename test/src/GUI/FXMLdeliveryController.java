/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// FXMLdeliveryController.java
// FXMLdeliveryController.java
package GUI;

import Service.LivraisonService;
import java.io.IOException;
import java.net.URL;
import models.Livraison;
import statistics.DeliveryStatistics;

import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

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
    private Label remarqueLabel;
    @FXML
    private Button btnmodifier;
    @FXML
    private Label modifierLabel;
    @FXML
    private Label totalDeliveriesLabel;
    @FXML
    private Label inTransitDeliveriesLabel;
    @FXML
    private Label deliveredDeliveriesLabel;

    private Livraison selectedLivraisonToModify;
    public void setLivraison(Livraison selectedLivraisonToModify) {
        this.selectedLivraisonToModify = selectedLivraisonToModify;
        tfnom.setText(selectedLivraisonToModify.getNom());
        tfprenom.setText(selectedLivraisonToModify.getPrenom());
        tfadresse.setText(selectedLivraisonToModify.getAdresse());
        tfprix.setText(String.valueOf(selectedLivraisonToModify.getPrix()));
        tfnbrecom.setText(String.valueOf(selectedLivraisonToModify.getNbreCommandes()));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnajout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String nom = tfnom.getText();
                String prenom = tfprenom.getText();
                String adresse = tfadresse.getText();
                String prixText = tfprix.getText();
                String nbrecomText = tfnbrecom.getText();

                if (nom.isEmpty() || prenom.isEmpty() || adresse.isEmpty() || prixText.isEmpty() || nbrecomText.isEmpty()) {
                    showAlert(Alert.AlertType.WARNING, "Validation Error", "Veuillez remplir tous les champs");
                    return;
                }

                int prix;
                int nbrecom;
                try {
                    prix = Integer.parseInt(prixText);
                    nbrecom = Integer.parseInt(nbrecomText);
                } catch (NumberFormatException e) {
                    showAlert(Alert.AlertType.WARNING, "Validation Error", "Les champs 'Prix' et 'Nombre de commandes' doivent être des entiers");
                    return;
                }

                LivraisonService livraisonService = new LivraisonService();
                try {
                    Livraison livraison = new Livraison(nom, prenom, adresse, prix, nbrecom);
                    livraisonService.ajouterLivraison(livraison);
                    
                    updateStatistics();
                    showInfoAlert("Success", "Livraison ajoutée");
                    loadNextScene("FXMLafficherDelivery.fxml");
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLdeliveryController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

       btnmodifier.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        LivraisonService livraisonService = new LivraisonService();
        try {
            String nom = tfnom.getText();
            String prenom = tfprenom.getText();
            String adresse = tfadresse.getText();
            String prixText = tfprix.getText();
            String nbrecomText = tfnbrecom.getText();

            if (nom.isEmpty() || prenom.isEmpty() || adresse.isEmpty() || prixText.isEmpty() || nbrecomText.isEmpty()) {
                showAlert(Alert.AlertType.WARNING, "Validation Error", "Veuillez remplir tous les champs");
                return;
            }

            int prix;
            int nbrecom;
            try {
                prix = Integer.parseInt(prixText);
                nbrecom = Integer.parseInt(nbrecomText);
            } catch (NumberFormatException e) {
                showAlert(Alert.AlertType.WARNING, "Validation Error", "Les champs 'Prix' et 'Nombre de commandes' doivent être des entiers");
                return;
            }

            Livraison livraisonToUpdate = new Livraison(nom, prenom, adresse, prix, nbrecom);

            if (selectedLivraisonToModify != null) {
                livraisonToUpdate.setID(selectedLivraisonToModify.getID());
                livraisonService.modifierLivraison(livraisonToUpdate);
                modifierLabel.setText("Delivery modified");
                updateStatistics();
                showInfoAlert("Success", "Delivery modified");
                loadNextScene("FXMLafficherDelivery.fxml");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLdeliveryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
});

    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void showInfoAlert(String title, String content) {
        showAlert(Alert.AlertType.INFORMATION, title, content);
    }

    private void updateStatistics() {
        List<Livraison> allDeliveries = fetchDataFromSource();
        if (allDeliveries != null) {
            int totalDeliveries = DeliveryStatistics.calculateTotalDeliveries(allDeliveries);
            int inTransitDeliveries = DeliveryStatistics.calculateDeliveriesInTransit(allDeliveries);
            int deliveredDeliveries = DeliveryStatistics.calculateDeliveredDeliveries(allDeliveries);
            totalDeliveriesLabel.setText("Total Deliveries: " + totalDeliveries);
            inTransitDeliveriesLabel.setText("In Transit: " + inTransitDeliveries);
            deliveredDeliveriesLabel.setText("Delivered: " + deliveredDeliveries);
        }
    }

    private List<Livraison> fetchDataFromSource() {
        LivraisonService livraisonService = new LivraisonService();
        try {
            return livraisonService.getAllLivraisons();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLdeliveryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void loadNextScene(String FXMLdelivery) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLafficherDelivery.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) btnajout.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(FXMLdeliveryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
