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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import service.Serviceproduit;
import entity.Produits;

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
    
}
