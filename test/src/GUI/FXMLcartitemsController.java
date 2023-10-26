/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.fxml.Initializable;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLcartitemsController implements Initializable {
    @FXML
    private ListView<Product> myListViewCart;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize your ListView and other components here
    }

    public void initializeCartItems(List<Product> selectedProducts) {
        myListViewCart.getItems().addAll(selectedProducts);
    }

    @FXML
    private void onConfirmerClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLfinal.fxml"));
            Parent root = loader.load();
            FXMLfinalController finalController = loader.getController();
            finalController.setStage(stage);

            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onDeleteItemClick(ActionEvent event) {
        Product selectedProduct = myListViewCart.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            myListViewCart.getItems().remove(selectedProduct);
            // Perform any additional logic for deleting the selected item from the cart
        }
    }
}