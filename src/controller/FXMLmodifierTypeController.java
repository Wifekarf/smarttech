/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Type_produit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
public class FXMLmodifierTypeController implements Initializable {

    @FXML
    private TextField tfDescription2;
    @FXML
    private Button btnmodifierType;
    @FXML
    private TextField tfnomType;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnmodifierType.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Servicetype st = new Servicetype();
                try {
                    st.modifierType( new Type_produit(tfDescription2.getText(),tfnomType.getText()));
                } catch (Exception e) {
                
                }
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        
        });
        // TODO
    }    
    
}
