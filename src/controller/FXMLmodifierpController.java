/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import services.Serviceproduit;
import models.Produits;
import models.Type_produit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;


/**
 * FXML Controller class
 *
 * @author DELL
 */
public class FXMLmodifierpController implements Initializable {

    @FXML
    private TextField tfprix2;
    @FXML
    private TextField tfdescription2;
    private TextField tfimage2;
    @FXML
    private Button btn1modifier;
    @FXML
    private TextField tfnbP;
    private TextField tftype1;
    @FXML
    private TextField tfNomP;
    @FXML
    private Button btnanuulerM;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btn1modifier.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Serviceproduit sp = new Serviceproduit();
                try {
                    sp.modifierProduit(new Produits(tfnbP.getLength(),tfprix2.getLength(),tfdescription2.getText(),tfNomP.getText(),tfimage2.getAccessibleText(), new Type_produit( Integer.parseInt(tftype1.getText()),"", "")));
                            } catch (Exception ex) {
                Logger.getLogger(FXMLmodifierpController.class.getName()).log(Level.SEVERE, null, ex);
                    }    
             // FXMLLoader loader = new FXMLLoader(FXMLajoutTypeController.this.getClass().getResource("./FXMLafficheType.fxml"));
            
                try {
                   btn1modifier.getScene().setRoot(FXMLLoader.load(getClass().getResource("FXMLaffichep.fxml")));
                }
                catch (IOException ex) {
                    Logger.getLogger(FXMLmodifierpController.class.getName()).log(Level.SEVERE, null, ex);
                    }
               
            }
        });
        // TODO
    }    
    
}
