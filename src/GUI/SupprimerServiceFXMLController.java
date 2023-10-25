/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import models.Service;
import services.ServiceService;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class SupprimerServiceFXMLController implements Initializable {

    private TextField txtNomduService;
    private ServiceService ServiceService = new ServiceService();
    @FXML
    private Button btnService;
    @FXML
    private ComboBox<Service> comboSuppService;
    @FXML
    private Button btnretouraffiche;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
       try {
        List<Service> services = ServiceService.getAllServices();
        
        comboSuppService.setConverter(new StringConverter<Service>() {
            
            public String toString(Service service) {
                return service.getNomService();
            }

           
            public Service fromString(String string) {
                return null; // Non utilisé ici
            }
        });

        comboSuppService.getItems().addAll(services);
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    }    

    @FXML
    private void SuppService(ActionEvent event) throws SQLException {
      try {
        Service selectedService = comboSuppService.getValue();

        if (selectedService == null) {
            System.out.println("Veuillez sélectionner un service.");
            return;
        }

        ServiceService.supprimerService(selectedService.getNomService());
        System.out.println("Service supprimé avec succès.");
    } catch (SQLException ex) {
        System.out.println("Erreur lors de la suppression du service.");
        ex.printStackTrace();
    }
}

    @FXML
    private void retourpageaff(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficheService.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) btnretouraffiche.getScene().getWindow(); 
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
