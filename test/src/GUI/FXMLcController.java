package GUI;

import models.Livraison;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import javafx.scene.control.ListCell;
import javafx.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;

public class FXMLcController implements Initializable {
    

    @FXML
    private Button btnPanier;

    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    @FXML
    private Button btnCartItems;

    @FXML
    private Label lblSuccessMessage;
   
    @FXML
    private ListView<Product> myListVieww;
    private Product selectedProductsToAdd;
    private Product selectedProductsToInsert;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Your initialization code here
        myListVieww.setCellFactory(new Callback<ListView<Product>, ListCell<Product>>() {
            @Override
            public ListCell<Product> call(ListView<Product> param) {
                return new ListCell<Product>() {
                    @Override
                    protected void updateItem(Product item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item.getName());
                        } else {
                            setText(null);
                        }
                    }
                };
            }
        });

        // Create and add Product objects to the ListView
        Product[] products = {
            new Product("Samsung", "desc1", 500.0),
            new Product("iPhone", "desc2", 1500.0),
            new Product("PC", "desc3", 2500.0)
        };

        myListVieww.getItems().addAll(products);
        myListVieww.setOnMouseClicked(this::handleListViewSelection);
    }

    @FXML
    private void addToPanier() {
         btnPanier.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             @SuppressWarnings("empty-statement")
             public void handle(ActionEvent event) {
                 if (selectedProductsToAdd != null) {
                     Product.createPanier(selectedProductsToAdd);
                     selectedProductsToAdd = null;
                 }
             }
         });
        // Get the selected product from the ListView
        Product selectedProduct = myListVieww.getSelectionModel().getSelectedItem();

        if (selectedProduct != null) {
            // Insert the selected product into the "panier" table
            insertProductIntoPanier(selectedProduct);
        }
    }

    private void insertProductIntoPanier(Product selectedProduct) {
        try (Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "")) {
            String sql = "INSERT INTO panier (product_name, product_description, product_price) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = connexion.prepareStatement(sql)) {
                stmt.setString(1, selectedProduct.getName());
                stmt.setString(2, selectedProduct.getDescription());
                stmt.setDouble(3, selectedProduct.getPrice());
                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    // Product inserted successfully, show the message on lblSuccessMessage
                    lblSuccessMessage.setText("Product added successfully!");
                    System.out.println("Product added to Panier: " + selectedProduct.getName());
                } else {
                    lblSuccessMessage.setText("Failed to add the product.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            lblSuccessMessage.setText("Error: " + e.getMessage());
        }
    }

    @FXML
    private void openCartItems(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLcartitems.fxml"));
            Parent root = loader.load();
            FXMLcartitemsController cartItemsController = loader.getController();
            

            // Pass the list of selected products to the FXMLcartitemsController
            List<Product> selectedProducts;
            selectedProducts = new ArrayList<>(myListVieww.getSelectionModel().getSelectedItems());
            cartItemsController.initializeCartItems(selectedProducts);

            btnCartItems.getScene().setRoot(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
private void handleListViewSelection(MouseEvent event) {
        Product selectedProducts = myListVieww.getSelectionModel().getSelectedItem();
        if (selectedProducts != null) {
            selectedProductsToAdd = selectedProducts;
            selectedProductsToInsert = selectedProducts;
        }
    }
    
}
