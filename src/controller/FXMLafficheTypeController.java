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
import service.Servicetype;
import entity.Type_produit;
import java.util.Collection;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
/**
 * FXML Controller class
 *
 * @author DELL
 */
public class FXMLafficheTypeController implements Initializable {

    @FXML
    private ListView<?> listType;
    @FXML
    private Button btnafficheType;
    @FXML
    private Button btnsuppType;
    private Servicetype st;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Servicetype st = new Servicetype();
        st.afficheType();
    }
    public void loadData() {
        afficheType();
    }
    @SuppressWarnings("empty-statement")
    public void afficheType() {
//        ListView<Type_produit> type_produitView = new ListView<>();
//        ObservableList<String> type_names = FXCollections.observableArrayList("ID: " + type_produit.getIdT()+
//                                 ", Nom de type: " + type_produit.getNom_type()+
//                                 ", Description : " + type_produit.getDescription());
//        
        
        
        List<Type_produit> type_produits = st.afficheType();
        ObservableList<String> type_names = FXCollections.observableArrayList("ID: "," Nom de type: "," Description : " );
        // Ajouter les noms d'équipements à la liste observable
        type_produits.forEach((type_produit) -> { 
            type_names.add("ID: " + type_produit.getIdT()+
                                 ", Nom de type: " + type_produit.getNom_type()+
                                 ", Description : " + type_produit.getDescription());
    });   
        // Charger les données dans la ListView
        listType.setOrientation(Orientation.HORIZONTAL); ;
        
    }
}


