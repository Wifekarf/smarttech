/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import models.Produits;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import services.Servicetype;
import models.Type_produit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import services.Serviceproduit;
/**
 * FXML Controller class
 *
 * @author DELL
 */
public class FXMLafficheTypeController implements Initializable {

    @FXML
    private ListView<?> listType;
    @FXML
    private Button btnsuppType;
    @FXML
    private Button btnModifierType;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Servicetype st = new Servicetype();
        try {
            ArrayList<Type_produit> arrayList = (ArrayList<Type_produit>) st.afficheType();
            ObservableList obs = FXCollections.observableArrayList(arrayList);
            listType.setItems(obs);
            
        } catch (Exception ex) {
            Logger.getLogger(FXMLafficheTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML
    private void ModifierType(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLmodifierType.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


