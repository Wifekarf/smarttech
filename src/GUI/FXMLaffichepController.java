/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import services.Serviceproduit;
import models.Produits;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class FXMLaffichepController implements Initializable {

    @FXML
    private ListView<?> listProduit;
    @FXML
    private Button btnsuppProduit;
    @FXML
    private Button btnModifierProduit;
    @FXML
    private Button btnstat;
    private Serviceproduit sp;
    private Produits selectedProduits;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    Serviceproduit sp = new Serviceproduit();
        try {
            ArrayList<Produits> arrayList = (ArrayList<Produits>) sp.afficheProduit();
            ObservableList obs = FXCollections.observableArrayList(arrayList);
            listProduit.setItems(obs);
            
        } catch (Exception ex) {
            Logger.getLogger(FXMLaffichepController.class.getName()).log(Level.SEVERE, null, ex);
        }
        btnsuppProduit.setOnAction(event -> {
            ArrayList<Produits> arrayList = (ArrayList<Produits>) sp.afficheProduit();
            ObservableList obs = FXCollections.observableArrayList(arrayList);
                if (selectedProduits != null) {
                    try {
                        sp.supprimerProduit(5);
                        obs.remove(selectedProduits);
                        selectedProduits= null;
                    } catch (Exception ex) {
                        Logger.getLogger(FXMLaffichepController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
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
//     private void supprimerProduit(ActionEvent event) {
//        Produits selectedProduit ;
//        if (selectedProduit != null) {
//                    try {
//                        sp.supprimerProduit(selectedProduit.getIdP());
//                        obs.remove(selectedLivraisonToDelete);
//                        selectedLivraisonToDelete = null;
//                    } catch (SQLException ex) {
//                        Logger.getLogger(FXMLafficherDeliveryController.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//        
//    }
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
    
}


