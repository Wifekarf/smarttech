/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import services.Serviceproduit;
import models.Produits;
import models.Type_produit;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class FXMLaffichepController implements Initializable {

    @FXML
    private ListView<?> listProduit;
    @FXML
    private Button btnafficheProduit;
    @FXML
    private Button btnsuppProduit;
    private Produits selectedProduitToDelete;
    private Produits selectedProduitToModify;

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
    }
    
    @FXML
    public void supprimerProduit(ActionEvent event) {
    if (selectedProduitToDelete != null) {
        Serviceproduit sp = new Serviceproduit();
        try {
            sp.supprimerProduit(selectedProduitToDelete); // Supprimez l'élément sélectionné
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
    Serviceproduit sp = new Serviceproduit();
    try {
        ArrayList<Produits> arrayList = (ArrayList<Produits>) sp.afficheProduit();
            ObservableList obs = FXCollections.observableArrayList(arrayList);
            listProduit.setItems(obs);
    } catch (Exception ex) {
        Logger.getLogger(FXMLafficheTypeController.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
}
