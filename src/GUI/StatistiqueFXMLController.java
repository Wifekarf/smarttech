package GUI;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import models.Service;
import models.Categorie;

import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import services.ServiceService;

public class StatistiqueFXMLController implements Initializable {

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;
    @FXML
    private Button btn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            
            List<Service> services = ServiceService.getAllServices();

            
            Map<String, Integer> categorieCounts = new HashMap<>();

            for (Service service : services) {
                int categoryId = service.getFk_idCategorie();
                Categorie categorie = Categorie.getCategorieById(categoryId);

                if (categorie != null) {
                    String categoryName = categorie.getNomCategorie();
                    categorieCounts.put(categoryName, categorieCounts.getOrDefault(categoryName, 0) + 1);
                }
            }

            // Alimenter les données du graphique
            XYChart.Series<String, Integer> series = new XYChart.Series<>();
            for (Map.Entry<String, Integer> entry : categorieCounts.entrySet()) {
                series.getData().add(new XYChart.Data<>(entry.getKey(), entry.getValue()));
            }

            barChart.getData().add(series);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void homesta(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("StatistiqueFXML.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) btn.getScene().getWindow(); 
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
