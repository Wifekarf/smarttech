/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.FactureService;
import models.Facture;

public class AfficherFactureController implements Initializable {

    @FXML
    private TableView<Facture> table;

    @FXML
    private TableColumn<Facture, Integer> IdFacture;
    @FXML
    private TableColumn<Facture, Integer> IdCommande;
    @FXML
    private TableColumn<Facture, Double> Montant;
    @FXML
    private TableColumn<Facture, String> Date;
    @FXML
    private Button AnnulerAffichage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FactureService factureService = new FactureService();

        // Chargez les factures depuis la base de données
        List<Facture> factures = factureService.afficherFactures();

        // Créez une liste observable pour les factures
        ObservableList<Facture> factureList = FXCollections.observableArrayList(factures);

        // Associez les colonnes du TableView aux propriétés de la classe Facture
        IdFacture.setCellValueFactory(new PropertyValueFactory<>("idFacture"));
        IdCommande.setCellValueFactory(new PropertyValueFactory<>("idCommande"));
        Montant.setCellValueFactory(new PropertyValueFactory<>("Montant"));
        Date.setCellValueFactory(new PropertyValueFactory<>("date"));

        // Ajoutez les factures au TableView
        table.setItems(factureList);
    }

    @FXML
    private void AnnuleAffich(ActionEvent event) { 
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterFacture.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) AnnulerAffichage.getScene().getWindow(); // Obtient la fenêtre actuelle
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
