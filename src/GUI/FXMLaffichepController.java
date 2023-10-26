/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.event.ActionEvent;
import services.Serviceproduit;
import models.Produits;

import java.net.URL;
import java.sql.SQLException;
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


/**
 * FXML Controller class
 *
 * @author DELL
 */
public class FXMLaffichepController implements Initializable {

    @FXML
    private ListView<Produits> listProduit;
    @FXML
    private Button btnsuppProduit;
    
    private Button btnupdate;
    
    @FXML
    private Button btnModifierProduit;
    @FXML
    private Button btnstat;
    private Serviceproduit sp;
    private Produits selectedProduitTODElete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    Serviceproduit sp = new Serviceproduit();
        try {
            List<Produits> arrayList =  sp.afficheProduit();
            ObservableList<Produits> obs = FXCollections.observableArrayList(arrayList);
            listProduit.setItems(obs);
            
        listProduit.setOnMouseClicked(this::handleListViewSelection);
      btnsuppProduit.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            if (selectedProduitTODElete != null) {
                try {
                 sp.supprimerProduit(5);
                obs.remove(selectedProduitTODElete);
                selectedProduitTODElete= null;
                } catch (SQLException ex) {
                 Logger.getLogger(FXMLaffichepController.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        }
       });
        
        btnupdate.setOnAction(event -> {
                // Clear the existing data in the ListView
                obs.clear();

                // Load the updated data from the database
                List<Produits> updatedList = null;
                try {
                    updatedList = sp.afficheProduit();
                } catch (Exception ex) {
                    Logger.getLogger(FXMLaffichepController.class.getName()).log(Level.SEVERE, null, ex);
                }
                obs.addAll(updatedList);
            });

        } catch (Exception ex) {
            Logger.getLogger(FXMLaffichepController.class.getName()).log(Level.SEVERE, null, ex);
        }
    

        
    }
    private void handleListViewSelection(MouseEvent event) {
        Produits selectedProduits = listProduit.getSelectionModel().getSelectedItem();
        if (selectedProduits != null) {
            selectedProduitTODElete = selectedProduits;
            //selectedLivraisonToModify = selectedLivraison;
        }
    }
    @FXML
    private void Statistque(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLstat.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }    

    @FXML
     private void ModifierProduit(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLmodifierp.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
           
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     //    @FXML
//     private void supprimerProduit(ActionEvent event) {
//        Produits selectedProduit ;
//        ArrayList<Produits> arrayList = (ArrayList<Produits>) sp.afficheProduit();
//            ObservableList obs = FXCollections.observableArrayList(arrayList);
//        if (selectedProduits != null) {
//            sp.supprimerProduit(selectedProduits.getIdP());
//            obs.remove(selectedProduits);
//            selectedProduits = null;
//                }
//        
//    }
     
}


