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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.Facture;
import services.FactureService;
import java.time.LocalDate;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class ModifierFactureController implements Initializable {

    @FXML
    private TextField montantTextField;
    @FXML
    private ComboBox<Facture> idFacturextField;
    @FXML
    private DatePicker dateDatePicker;
    @FXML
    private Button ModifierFacture;
    private Button AnnulerSuppression;
    @FXML
    private Button AnnulerModification;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        chargerFactures();

        ModifierFacture.setOnAction((ActionEvent event) -> {
            modifierFacture();
        });
    }

    private void chargerFactures() {
        FactureService factureService = new FactureService();
        idFacturextField.getItems().setAll(factureService.afficherFactures());
    }

    private void modifierFacture() {
        Facture facture = idFacturextField.getValue();

        if (facture != null) {
            double nouveauMontant = Double.parseDouble(montantTextField.getText());
            LocalDate nouvelleDate = dateDatePicker.getValue();

            facture.setMontant(nouveauMontant);
            facture.setDate(nouvelleDate);

            FactureService factureService = new FactureService();
            factureService.modifierFacture(facture, facture.getIdFacture());

            System.out.println("Facture modifiée avec succès!");
        } else {
            System.out.println("Veuillez sélectionner une facture.");
        }
    }

  

    @FXML
    private void retourPage2(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Page2.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) AnnulerModification.getScene().getWindow(); // Obtient la fenêtre actuelle
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

