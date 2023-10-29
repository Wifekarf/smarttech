package GUI;

import Service.LivraisonService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import models.Livraison;

public class FXMLstatisticController implements Initializable {

    @FXML
    private BarChart<String, Integer> chartDelivery;
    @FXML
    private Button btnretouuur;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize the LivraisonService
        LivraisonService livraisonService = new LivraisonService();

        try {
            // Retrieve all the deliveries
            List<Livraison> deliveries = livraisonService.getAllLivraisons();

            // Create a map to store the delivery statistics
            Map<String, Integer> deliveryStats = new HashMap<>();

            // Calculate the total number of deliveries for each category
            for (Livraison delivery : deliveries) {
                String category = delivery.getNom(); // Assuming 'nom' represents the category
                int count = deliveryStats.getOrDefault(category, 0);
                deliveryStats.put(category, count + 1);
            }

            // Create the data series for the chart
            XYChart.Series<String, Integer> series = new XYChart.Series<>();
            for (Map.Entry<String, Integer> entry : deliveryStats.entrySet()) {
                series.getData().add(new XYChart.Data<>(entry.getKey(), entry.getValue()));
            }

            // Add the series to the chart
            chartDelivery.getData().add(series);

        } catch (SQLException ex) {
            // Handle any exceptions
            ex.printStackTrace();
        }
    }
    @FXML
private void onBackToClick(ActionEvent event) {
    try {
        // Load the FXMLProduit view
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLacceuil.fxml"));
        Parent root = loader.load();

        // Get the controller of the FXMLProduit view
        FXMLacceuilController acceuilController = loader.getController();

        // Set the stage in the FXMLProduit controller
        Stage newStage = new Stage(); // Create a new stage for the new scene
        acceuilController.setStage(newStage);

        // Set the FXMLProduit view as the new scene on the new stage
        newStage.setScene(new Scene(root));
        newStage.show(); // Show the new stage

        // Close the current stage
        Stage currentStage = (Stage) btnretouuur.getScene().getWindow();
        currentStage.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}