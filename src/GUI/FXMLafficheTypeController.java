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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import models.Type_produit;

import services.Servicetype;
import models.Type_produit;
import services.Serviceproduit;
/**
 * FXML Controller class
 *
 * @author DELL
 */
public class FXMLafficheTypeController implements Initializable {

    @FXML
    private ListView<Type_produit> listType;
    @FXML
    private Button btnsuppType;
    @FXML
    private Button btnModifierType;
     private Button btnupdate;
     private Type_produit selectedTypeTODelete;
     private Servicetype st;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    Servicetype st = new Servicetype();
        try {
            ArrayList<Type_produit> arrayList =(ArrayList<Type_produit>)  st.afficheType();
            ObservableList<Type_produit> obs = FXCollections.observableArrayList(arrayList);
            listType.setItems(obs);
            
//            List<Produits> arrayList =  sp.afficheProduit();
//            ObservableList<Produits> obs = FXCollections.observableArrayList(arrayList);
//            listProduit.setItems(obs);
            
            listType.setOnMouseClicked(this::handleListViewSelection);
      
            btnsuppType.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            if (selectedTypeTODelete != null) {
                try {
                 st.supprimerType(5);
                obs.remove(selectedTypeTODelete);
                selectedTypeTODelete= null;
                } catch (SQLException ex) {
                 Logger.getLogger(FXMLafficheTypeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        }
       });
        btnupdate.setOnAction(event -> {
                // Clear the existing data in the ListView
                obs.clear();

                // Load the updated data from the database
                List<Type_produit> updatedList = null;
                try {
                    updatedList = st.afficheType();
                } catch (Exception ex) {
                    Logger.getLogger(FXMLafficheTypeController.class.getName()).log(Level.SEVERE, null, ex);
                }
                obs.addAll(updatedList);
            });

        } catch (Exception ex) {
            Logger.getLogger(FXMLafficheTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    

        
    }
    private void handleListViewSelection(MouseEvent event) {
        Type_produit selectedType_produit = (Type_produit) listType.getSelectionModel().getSelectedItem();
        if (selectedType_produit != null) {
            selectedType_produit = selectedType_produit;
            //selectedLivraisonToModify = selectedLivraison;
        }
    }
    @FXML
    private void ModifierType(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLmodifierType.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


