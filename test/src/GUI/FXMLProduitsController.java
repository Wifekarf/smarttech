/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import models.Produits;
import Service.ProduitsService;
import javafx.collections.ObservableList;

public class FXMLProduitsController implements Initializable {

    @FXML
    private ListView<Produits> productList;

    private ProduitsService produitsService;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        produitsService = new ProduitsService();
        
        // Call the method to fetch all products from the database
        try {
            productList.setItems((ObservableList<Produits>) produitsService.getAllProduits());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    
}