/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import models.Service;
import services.ServiceService;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ModifierserviceFXMLController implements Initializable {

    @FXML
    private TextField txtfieldLocation;
    @FXML
    private TextField txtfieldPrix;
    @FXML
    private DatePicker txtfieldDateAvaliable;
    @FXML
    private TextField txtfieldNomService;
    @FXML
    private TextField txtfieldCategorie;
    @FXML
    private DatePicker txtfieldDateCreation;
    private TextField txtfieldanciennom;
    @FXML
    private Button btnConfirmer;
    @FXML
    private ComboBox<Service> comboNomServiceModifier;
    @FXML
    private Button btnretour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
        List<Service> services = ServiceService.getAllServices();
        
        comboNomServiceModifier.setConverter(new StringConverter<Service>() {
            
            public String toString(Service service) {
                return service.getNomService();
            }

           
            public Service fromString(String string) {
                return null; // Non utilisé ici
            }
        });

        comboNomServiceModifier.getItems().addAll(services);
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    
}

    @FXML
    private void modfierService(ActionEvent event) {
        try {
        Service selectedService = comboNomServiceModifier.getValue();

        if (selectedService == null) {
            System.out.println("Veuillez sélectionner un service.");
            return;
        }

        String ancienNomService = selectedService.getNomService();
        String nouveauNomService = txtfieldNomService.getText();
        String categorieText = txtfieldCategorie.getText();
        String localisation = txtfieldLocation.getText();
        String prixText = txtfieldPrix.getText();

        if (nouveauNomService.isEmpty() || categorieText.isEmpty() || localisation.isEmpty() || prixText.isEmpty() ||
                txtfieldDateAvaliable.getValue() == null || txtfieldDateCreation.getValue() == null) {
            System.out.println("Veuillez remplir tous les champs.");
            return;
        }

        String dateAvaliableText = txtfieldDateAvaliable.getValue().toString();
        String dateCreationText = txtfieldDateCreation.getValue().toString();

        int categorie = Integer.parseInt(categorieText);
        int prix = Integer.parseInt(prixText);
        Date Datedisponibilté = Date.valueOf(dateAvaliableText);
        Date Dateducréation = Date.valueOf(dateCreationText);

        ServiceService serviceService = new ServiceService();

        Service service = new Service(nouveauNomService, Dateducréation, localisation, prix, Datedisponibilté, categorie);

        serviceService.modifierService(service, ancienNomService);
        System.out.println("Service modified successfully.");
    } catch (Exception e) {
        System.out.println("Error");
    }
    }

    @FXML
    private void retouraffiche(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficheService.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) btnretour.getScene().getWindow(); 
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    
    }
    
//}
