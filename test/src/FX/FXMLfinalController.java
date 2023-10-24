/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FX;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLfinalController implements Initializable {
    @FXML
    private TextField tfadressefinal;
    @FXML
    private Button btnok;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialization code goes here
    }

    @FXML
    private void onOkButtonClick(ActionEvent event) {
       
        String address = tfadressefinal.getText();
        
        
        System.out.println("Address entered: " + address);
        
       
    }

    void setStage(Stage stage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

