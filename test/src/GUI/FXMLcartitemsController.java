package GUI;


import java.io.IOException;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Panier;
import models.Produits;

public class FXMLcartitemsController implements Initializable {
    private ListView<Produits> myListViewCart;

    private Stage stage; // Reference to the stage
    private Panier cart; // The cart object that holds selected products
    @FXML
    private AnchorPane btnsupP;
    @FXML
    private Button btnconfirmer;
    @FXML
    private Button SupPanier;
    @FXML
    private Button btnincreaseQuantity;
    @FXML
    private Button btndecreaseQuantity;
    private Label totalPriceLabel;
    @FXML
    private Button btnbackto;
    public void setStage(Stage stage) {
        this.stage = stage;
    }
   @FXML
   private ListView<Produits> cartProductList;

   public ListView<Produits> getCartProductList() {
       return cartProductList;
   }
   public double calculateTotalPrice() {
       double totalPrice = 0.0;
    
       for (Produits product : myListViewCart.getItems()) {
           double prix = product.getPrix(); // Get the product's price
           int quantity = product.getQuantity(); // Get the product's quantity
           totalPrice += prix * quantity;
       }
    
       totalPriceLabel.setText("Total Price: $" + totalPrice); // Update the label with the total price
    
       return totalPrice;
   }

   // Initialize the controller
   @Override
   public void initialize(URL url, ResourceBundle rb) {
       myListViewCart = cartProductList; // Assign the cartProductList to myListViewCart

       myListViewCart.setCellFactory(param -> new ListCell<Produits>() {
           @Override
           protected void updateItem(Produits item, boolean empty) {
               super.updateItem(item, empty);
               if (empty || item == null) {
                   setText(null);
               } else {
                   setText(item.getNom_produit()); // Set the name or description of the product
               }
           }
       });
       // You can perform any initialization here
   }

   // Initialize the cart items
   public void initializeCartItems(List<Produits> selectedProducts) {
       // You can initialize the cart items here
   }

   // Handle confirmation button click
   @FXML
private void onConfirmerClick(ActionEvent event) {
    Alert confirmationDialog = new Alert(AlertType.CONFIRMATION);
    confirmationDialog.setTitle("Confirmation");
    confirmationDialog.setHeaderText("Are you sure you want to confirm?");
    confirmationDialog.setContentText("Click OK to proceed or Cancel to stay on this page.");

    ButtonType buttonTypeOK = new ButtonType("OK", ButtonData.OK_DONE);
    ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

    confirmationDialog.getButtonTypes().setAll(buttonTypeOK, buttonTypeCancel);

    Optional<ButtonType> result = confirmationDialog.showAndWait();

    if (result.isPresent() && result.get() == buttonTypeOK) {
        loadFinalView();
    }
}

private void loadFinalView() {
    try {
        // Load the final view
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLfinal.fxml"));
        Parent root = loader.load();

        // Get the controller of the final view
        FXMLfinalController finalController = loader.getController();

        // Set the stage and cart in the final view's controller
        finalController.setStage(stage);
        finalController.setCart(cart);

        // Set the final view as the new scene
        Scene scene = new Scene(root);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.show();

        // Close the current stage
        Stage currentStage = (Stage) btnconfirmer.getScene().getWindow();
        currentStage.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}



   // Handle item deletion button click
   @FXML
private void onDeleteItemClick(ActionEvent event) {
    Produits selectedProduct = myListViewCart.getSelectionModel().getSelectedItem();
    if (selectedProduct != null) {
        // Create a confirmation dialog
        Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationDialog.setTitle("Confirmation");
        confirmationDialog.setHeaderText("Delete Item");
        confirmationDialog.setContentText("Are you sure you want to delete this item?");

        // Customize the buttons of the confirmation dialog
        ButtonType yesButton = new ButtonType("Yes", ButtonData.OK_DONE);
        ButtonType noButton = new ButtonType("No", ButtonData.CANCEL_CLOSE);
        confirmationDialog.getButtonTypes().setAll(yesButton, noButton);

        // Show the confirmation dialog and wait for the user's response
        Optional<ButtonType> result = confirmationDialog.showAndWait();

        if (result.isPresent() && result.get() == yesButton) {
            // User clicked "Yes," proceed with deletion
            myListViewCart.getItems().remove(selectedProduct);
            // Remove the selected product from the cart
            cart.removeProductFromCart(selectedProduct);
            calculateTotalPrice(); // Recalculate the total price after removal
        }
    }
}


   @FXML
   private void onIncreaseQuantityClick(ActionEvent event) {
       Produits selectedProduct = myListViewCart.getSelectionModel().getSelectedItem();
       if (selectedProduct != null) {
           selectedProduct.setQuantity(selectedProduct.getQuantity() + 1);
           updateCartListView();
       }
   }

   @FXML
   private void onDecreaseQuantityClick(ActionEvent event) {
       Produits selectedProduct = myListViewCart.getSelectionModel().getSelectedItem();
       if (selectedProduct != null && selectedProduct.getQuantity() > 0) {
           selectedProduct.setQuantity(selectedProduct.getQuantity() - 1);
           updateCartListView();
       }
   }

   @FXML
private void onBackToClick(ActionEvent event) {
    try {
        // Load the FXMLProduit view
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLProduit.fxml"));
        Parent root = loader.load();

        // Get the controller of the FXMLProduit view
        FXMLProduitController produitController = loader.getController();

        // Set the stage in the FXMLProduit controller
        Stage newStage = new Stage(); // Create a new stage for the new scene
        produitController.setStage(newStage);

        // Set the FXMLProduit view as the new scene on the new stage
        newStage.setScene(new Scene(root));
        newStage.show(); // Show the new stage

        // Close the current stage
        Stage currentStage = (Stage) btnbackto.getScene().getWindow();
        currentStage.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}


   private void updateCartListView() {
       // Refresh the cart items list view to reflect the changes in quantities
       myListViewCart.refresh();
   }

   // Set the cart for this controller
   public void setCart(Panier cart) {
       this.cart = cart;
   }
}