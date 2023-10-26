/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Panier;
import models.Produits;
import models.Utilisateurs;
import Service.PanierService;
import Service.ProduitsService;

public class FXMLProduitssController implements Initializable {

    @FXML
    private TableView<Produits> tableViewProduits;

    @FXML
    private TableColumn<Produits, Integer> colId;

    @FXML
    private TableColumn<Produits, String> colNom;

    @FXML
    private TableColumn<Produits, Float> colPrix;

    @FXML
    private TableColumn<Produits, String> colDescription;

    @FXML
    private Button btnAjoutPanier;

    @FXML
    private Label messageLabel;

    private ProduitsService produitsService;
    private PanierService panierService;
    private Utilisateurs utilisateur;
    private Panier panier;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        produitsService = new ProduitsService();
        panierService = new PanierService();
        utilisateur = getCurrentUser(); // Implement this method to get the current user

        // Get the list of produits from the service
        List<Produits> produitsList = null;
        try {
            produitsList = produitsService.getAllProduits();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLProduitssController.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Convert the ArrayList to an ObservableList
        ObservableList<Produits> observableProduitsList = FXCollections.observableArrayList(produitsList);

        // Set the cell value factory for each column
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

        // Set the data for the table view
        tableViewProduits.setItems(observableProduitsList);
    }

    @FXML
    private void addToCart() throws SQLException {
        Produits selectedProduit = tableViewProduits.getSelectionModel().getSelectedItem();

        if (selectedProduit != null) {
            if (panier == null) {
                panier = new Panier();
                panier.setUtilisateur(utilisateur);
                panier.setCartItems(new ArrayList<>());
            }

            panier.getCartItems().add(selectedProduit);

            if (panier.getPanierId() == 0) {
                panierService.createPanier(panier);
            } else {
                panierService.updatePanier(panier);
            }
            messageLabel.setText("Produit ajouté au panier avec succès.");
        } else {
            messageLabel.setText("Veuillez sélectionner un produit.");
        }
    }

    private Utilisateurs getCurrentUser() {
        // Implement this method to get the current user from your authentication system
        // Return the Utilisateurs object representing the current user
        return new Utilisateurs(/* Provide appropriate values for the user */);
    }
}