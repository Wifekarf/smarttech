/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import models.Type_produit;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.Servicetype;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class FXMLajoutTypeController implements Initializable {
    
    @FXML
    private Button btnajouType;
    @FXML
    private TextField tfNom_type;
    @FXML
    private TextField tfDescription;
    @FXML
    private Button btnAnnulT;
    
   

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btnajouType.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Servicetype st = new Servicetype();
                
                try {
                    st.ajouterType(new Type_produit(tfNom_type.getText(), tfDescription.getText()));
                    }
                catch (Exception ex) {
                    Logger.getLogger(FXMLajoutTypeController.class.getName()).log(Level.SEVERE, null, ex);
                    }    
             // FXMLLoader loader = new FXMLLoader(FXMLajoutTypeController.this.getClass().getResource("./FXMLafficheType.fxml"));
            
                try {
                    btnajouType.getScene().setRoot(FXMLLoader.load(getClass().getResource("FXMLafficheType.fxml")));
                }
                catch (IOException ex) {
                    Logger.getLogger(FXMLajoutTypeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        });
    }
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