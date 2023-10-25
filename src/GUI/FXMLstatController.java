package GUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;
import models.Produits;
import services.Serviceproduit;

public class FXMLstatController implements Initializable {
    @FXML
    private BarChart<?, ?> chartProduit;

    // Other FXML components for filters or additional statistics

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize your chart and statistics here
        initChart();
    }

    private void initChart() {
        // Create an instance of Serviceproduit to fetch data from your database
        Serviceproduit serviceProduit = new Serviceproduit();
        
        // Get your statistics data, e.g., a list of Produits
        List<Produits> productList = serviceProduit.afficheProduit();

        // Create a new XYChart.Series for the data
        XYChart.Series series = new XYChart.Series();

        // Set a name for the series (e.g., "Product Statistics")
        series.setName("Product Statistics");

        // Add data to the series
        for (Produits produit : productList) {
            // You can customize how you want to display the data on the chart
            // For example, you can use produit.getNom_produit() as the X value and produit.getNbP() as the Y value.
            series.getData().add(new XYChart.Data(produit.getNom_produit(), produit.getNbP()));
        }

        // Add the series to the chart
        chartProduit.getData().add(series);

        // Customize the chart further (e.g., add axis labels, chart title, etc.)
//        CategoryAxis xAxis = new CategoryAxis();
//        NumberAxis yAxis = new NumberAxis();
//        chartProduit.setTitle("Product Statistics");
//        xAxis.setLabel("Product Name");
//        yAxis.setLabel("Number of Products");
//
//        // Apply the axes to the chart
//        chartProduit.setCategoryGa;
//        chartProduit.setNumber(yAxis);
    }
}

       
    

