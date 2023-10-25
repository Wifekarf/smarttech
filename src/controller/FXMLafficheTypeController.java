/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import services.Servicetype;
import models.Type_produit;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
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
    
    private Type_produit selectedTypeToDelete;
    private Type_produit selectedTypeToModify;
    @FXML
    private Button btnmodifierType;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Servicetype st = new Servicetype();
        try {
            ArrayList<Type_produit> arrayList = (ArrayList<Type_produit>) st.afficheType();
            ObservableList obs = FXCollections.observableArrayList(arrayList);
            listType.setItems(obs);
            } catch (Exception ex) {
            Logger.getLogger(FXMLafficheTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        
        //listType.setOnMouseClicked(this::handleListViewSelection);
        
    @FXML
    public void supprimerType(ActionEvent event) {
    if (selectedTypeToDelete != null) {
        Servicetype st = new Servicetype();
        try {
            st.supprimerType(selectedTypeToModify); // Supprimez l'élément sélectionné
            refreshListView(); // Rafraîchissez la liste après la suppression
        } catch (Exception ex) {
            Logger.getLogger(FXMLafficheTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

private void refreshListView() {
    // Réinitialisez votre liste de types en fonction de la base de données ou de la source de données
    // Par exemple, réexécutez le code pour remplir la liste comme dans la méthode 'initialize'.
    // Assurez-vous de rafraîchir la liste affichée.
    Servicetype st = new Servicetype();
    try {
        ArrayList<Type_produit> arrayList = (ArrayList<Type_produit>) st.afficheType();
        ObservableList<Type_produit> obs = FXCollections.observableArrayList(arrayList);
        listType.setItems(obs);
    } catch (Exception ex) {
        Logger.getLogger(FXMLafficheTypeController.class.getName()).log(Level.SEVERE, null, ex);
    }
}
        
//        btnsuppType.setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent event) {
//                    if (selectedTypeToDelete != null)
//                        try {
//                            st.supprimerType(selectedTypeToDelete.getIdT());
//                            obs.remove(selectedTypeToDelete);
//                            selectedTypeToDelete = null;
//                        } catch (Exception ex) {
//                          Logger.getLogger(FXMLafficheTypeController.class.getName()).log(Level.SEVERE, null, ex); 
//                        }   
//                }
//            });
//        
//          btnmodifierType.setOnAction(event -> {
//                if (selectedTypeToModify != null) {
//                    try {
//                        // Load the FXML file for modification
//                        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLmodifierType.fxml"));
//                        Parent root = loader.load();
//                        
//                        // Pass the selected Livraison to the FXMLdeliveryController
//                        FXMLafficheTypeController afficheController = loader.getController();
//                        afficheController.setType_produit(selectedTypeToModify);
//
//                        Stage stage = new Stage();
//                        stage.setScene(new Scene(root));
//                        stage.show();
//                    } catch (IOException ex) {
//                        Logger.getLogger(FXMLafficheTypeController.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            });
        
        
    
//         private void handleListViewSelection(MouseEvent event) {
//        Type_produit selectedType = listType.getSelectionModel().getSelectedItem();
//        if (selectedType != null) {
//            selectedTypeToDelete = selectedType;
//            selectedTypeToModify = selectedType;
//        }
//    }

}



