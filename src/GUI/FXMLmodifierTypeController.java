/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import models.Type_produit;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.Servicetype;

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
    @FXML
    private Button btnAnnulerType1;
   

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
                } catch (Exception ex) {
                Logger.getLogger(FXMLmodifierTypeController.class.getName()).log(Level.SEVERE, null, ex);
                    }    
             // FXMLLoader loader = new FXMLLoader(FXMLajoutTypeController.this.getClass().getResource("./FXMLafficheType.fxml"));
            
                try {
                   btnmodifierType.getScene().setRoot(FXMLLoader.load(getClass().getResource("FXMLafficheType.fxml")));
                }
                catch (IOException ex) {
                    Logger.getLogger(FXMLmodifierTypeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            
        
        });
        // TODO
    }  
//    private void annuler(ActionEvent event) {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("accueil.fxml"));
//            Parent root = loader.load();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @FXML
    private void annuler(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("accueil.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
           
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
