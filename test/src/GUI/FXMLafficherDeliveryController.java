package GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import GUI.FXMLdeliveryController;
import Service.LivraisonService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import models.Livraison;

public class FXMLafficherDeliveryController {

    @FXML
    private Button btnStatestiquee;

    

    @FXML
    private ListView<Livraison> myListeView;
    @FXML
    private Button btnupdate;
    @FXML
    private Button btnmodifier1;
    @FXML
    private Button btnsupprimer;

    private Livraison selectedLivraisonToDelete;
    private Livraison selectedLivraisonToModify;

    public void initialize() {
        LivraisonService sp = new LivraisonService();
        try {
            List<Livraison> arrayList = sp.getAllLivraisons();
            ObservableList<Livraison> obs = FXCollections.observableArrayList(arrayList);
            myListeView.setItems(obs);

            // Add a listener to handle item selection
            myListeView.setOnMouseClicked(this::handleListViewSelection);

            btnsupprimer.setOnAction(event -> {
                if (selectedLivraisonToDelete != null) {
                    try {
                        sp.supprimerLivraison(selectedLivraisonToDelete.getIdLivraison());
                        obs.remove(selectedLivraisonToDelete);
                        selectedLivraisonToDelete = null;
                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLafficherDeliveryController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

            btnmodifier1.setOnAction(event -> {
                if (selectedLivraisonToModify != null) {
                    try {
                        // Load the FXML file for modification
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLdelivery.fxml"));
                        Parent root = loader.load();
                        
                        // Pass the selected Livraison to the FXMLdeliveryController
                        FXMLdeliveryController deliveryController = loader.getController();
                        deliveryController.setLivraison(selectedLivraisonToModify);

                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.show();
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLafficherDeliveryController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

            btnupdate.setOnAction(event -> {
                // Clear the existing data in the ListView
                obs.clear();

                // Load the updated data from the database
                List<Livraison> updatedList = null;
                try {
                    updatedList = sp.getAllLivraisons();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                obs.addAll(updatedList);
            });

        } catch (SQLException ex) {
            Logger.getLogger(FXMLafficherDeliveryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void handleListViewSelection(MouseEvent event) {
        Livraison selectedLivraison = myListeView.getSelectionModel().getSelectedItem();
        if (selectedLivraison != null) {
            selectedLivraisonToDelete = selectedLivraison;
            selectedLivraisonToModify = selectedLivraison;
        }
    }
    @FXML
   
private void handleBtnStatestiquee(ActionEvent event) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLstatistic.fxml"));
        Parent root = loader.load();
//         FXMLstatisticController fXMLstatisticController = loader.getController();
//         fXMLstatisticController.getClass()
        Scene scene = new Scene(root);
        Stage stage = (Stage) btnStatestiquee.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}