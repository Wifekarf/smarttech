/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


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
    @FXML
    private TextField tftype1;
    @FXML
    private TextField tfNomP;
    @FXML
    private Button btn1annuler;

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
                    sp.modifierProduit(new Produits(tfnbP.getLength(),tfprix2.getText(),tfdescription2.getText(),tfNomP.getText(),tfimage2.getText(), (Type_produit) tftype1.getPseudoClassStates()));
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
    @FXML
 private void retourAccueil(ActionEvent event) {
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
