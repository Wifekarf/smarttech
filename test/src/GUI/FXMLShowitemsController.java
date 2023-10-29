/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import models.Panier;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FXMLShowitemsController implements Initializable {

    @FXML
    private ListView<Panier> listeliste;
     private Stage stage; // Reference to the stage
    private Panier cart; // The cart object that holds selected products

    // Set the stage for this controller
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
