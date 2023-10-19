/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import entity.Produits;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import service.Serviceproduit;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class FXMLajoutpController implements Initializable {

    @FXML
    private TextField tfnom_produit;
    @FXML
    private TextField tfprix;
    @FXML
    private TextField tfdescription;
    @FXML
    private ImageView tfimage;
    @FXML
    private Button btn1ajout;
    @FXML
    private TextField tfnbP;
    @FXML
    private TextField tftype;
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btn1ajout.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent event) {
            Serviceproduit sp = new Serviceproduit();
            try {
                sp.ajouterProduit(new Produits(tfnbP.getLength(), tfnom_produit.getText(),tfprix.getText(),tfdescription.getText(),tfimage.getText()));
                
            } catch (Exception ex) {
                Logger.getLogger(FXMLajoutpController.class.getName()).log(Level.SEVERE, null, ex);
            }
            FXMLLoader loader =new FXMLLoader(getClass().getResource("./FXMLaffichep.fxml"));
           Parent root;
            try {
                root=loader.load();
                btn1ajout.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(FXMLajoutpController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        });
    }
}


        