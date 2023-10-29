/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FXMLacceuilController implements Initializable {

    @FXML
    private Button btnAffichlivreur;
    @FXML
    private Button btnAffichcommande;
  private Stage stage;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void affichelivreur(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLdelivery.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) btnAffichlivreur.getScene().getWindow(); // Obtient la fenêtre actuelle
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    @FXML
    private void affichecommande(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLProduit.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) btnAffichcommande.getScene().getWindow(); // Obtient la fenêtre actuelle
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
    void setStage(Stage newStage) {
    // Set the stage for this controller
    this.stage = newStage;
}

}
