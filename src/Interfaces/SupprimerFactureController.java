/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import models.Facture;
import services.FactureService;

public class SupprimerFactureController implements Initializable {

    @FXML
    private ComboBox<Facture> idFactureField; // Update the ComboBox type to Facture
    private Label messageLabel;

    private FactureService factureService;
    @FXML
    private Button SupprimerFacture;
    @FXML
    private Button AnnulerSuppression;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        factureService = new FactureService();

        // Load existing factures into the ComboBox
        try {
            idFactureField.getItems().setAll(factureService.afficherFactures());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void SuppFacture(ActionEvent event) {
        Facture selectedFacture = idFactureField.getValue();

        if (selectedFacture != null) {
            int idFacture = selectedFacture.getIdFacture();

            // Call the method to delete the selected Facture
            factureService.supprimerFacture(idFacture);

            messageLabel.setText("Facture supprimée avec succès !");
        } else {
            messageLabel.setText("Veuillez sélectionner une facture.");
        }
    }

    
    @FXML
    private void retourPage2(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Page2.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) AnnulerSuppression.getScene().getWindow(); // Obtient la fenêtre actuelle
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

//    private void SupprimerFacture(ActionEvent event) {
//        String idFactureText = idFactureField.getText();
//
//        try {
//            int idFacture = Integer.parseInt(idFactureText);
//
//            // Créez un objet Facture avec l'ID spécifié
////            Facture facture = new Facture();
////            facture.setIdFacture(idFacture);
//
//            // Appelez la méthode supprimerFacture avec l'objet Facture
//            factureService.supprimerFacture(idFacture);
//
//            messageLabel.setText("Facture supprimée avec succès !");
//        } catch (NumberFormatException e) {
//            messageLabel.setText("ID de facture invalide !");
//        }
//    }