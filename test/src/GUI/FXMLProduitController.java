package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import models.Produits;
import Service.ProduitsService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import models.Panier;

public class FXMLProduitController {

    @FXML
    private ListView<Produits> productList;

    private ProduitsService produitsService;
    @FXML
    private Button btnShowPanier;
    @FXML
    private Button btnAjoutPanier;
    public void setCart(Panier cart) {
        this.cart = cart;
    }
    private Stage stage;
public void setStage(Stage stage) {
    this.stage = stage;
}


    private Panier cart; // Create a Panier instance to maintain the cart

    public FXMLProduitController() {
        produitsService = new ProduitsService();
        cart = new Panier(); // Initialize the cart when the controller is created
    }

    public void initialize() throws SQLException {
        // Retrieve the produits list from the service
        ArrayList<Produits> produitsList = (ArrayList<Produits>) produitsService.getAllProduits();

        // Convert the ArrayList to an ObservableList
        ObservableList<Produits> observableProduitsList = FXCollections.observableArrayList(produitsList);

        // Set the ObservableList in the productList
        productList.setItems(observableProduitsList);
    }

    @FXML
    private void handleAjoutPanier(ActionEvent event) {
        Produits selectedProduct = productList.getSelectionModel().getSelectedItem();
        


        if (selectedProduct != null) {
            // Add the selected product to the cart (maintained by the controller)
            cart.addProductToCart(selectedProduct);

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Product added to cart successfully!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please select a product to add to the cart.");
            alert.showAndWait();
        }
        System.out.println("handleShowPanier method executed.");
    }

  @FXML
private void handleShowPanier(ActionEvent event) {
    try {
        // Pass the cart to the cart items view
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLcartitems.fxml"));
        Parent cartParent = loader.load();

        // Get the controller for the cart items view
        FXMLcartitemsController cartItemsController = loader.getController();

        // Pass the cart to the cart items controller
        cartItemsController.setCart(cart);

        // Get the ListView component from the cart items controller
        ListView<Produits> cartProductList = cartItemsController.getCartProductList();

        // Set the list of products in the cart to the ListView
        cartProductList.setItems(cart.getProducts());

        // Create a new stage for the cart scene
        Stage cartStage = new Stage();

        // Set the root node of the cart scene (loaded from FXML) on the new stage
        Scene cartScene = new Scene(cartParent);
        cartStage.setScene(cartScene);

        // Show the cart scene
        cartStage.show();
    } catch (IOException e) {
        e.printStackTrace();

        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Failed to load the cart scene. Please try again.");
        alert.showAndWait();
    }
}

   


}