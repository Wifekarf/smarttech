/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Type_produit;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import service.Servicetype;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class FXMLajoutTypeController implements Initializable {

    @FXML
    private TextField tfNom_type;
    @FXML
    private TextField tfDescription;
    @FXML
    private Button btnajouType;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Servicetype st = new Servicetype();
        btnajouType.setOnAction(e->{
            try {
                st.ajouterType(new Type_produit(tfNom_type.getText(),tfDescription.getText()));
            } catch (Exception ex) {
                Logger.getLogger(FXMLajoutTypeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        // TODO
    }    
    
}
