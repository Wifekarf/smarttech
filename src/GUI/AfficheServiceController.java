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
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.FileOutputStream;



/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AfficheServiceController implements Initializable {
    

    @FXML
    private TableColumn<Service, String> colonneNomService;
    @FXML
    private TableColumn<Service, Integer> colonneCategorie;
    @FXML
    private TableColumn<Service, String> colonneLocalisation;
    @FXML
    private TableColumn<Service, Integer> colonnePrix;
    @FXML
    private TableColumn<Service, Date> colonneDateAvailable;
    @FXML
    private TableColumn<Service, Date> colonneDatecreation;
    @FXML
    private TableView<Service> table;
    @FXML
    private Button btnajouterservice;
    @FXML
    private Button btnhome;
    @FXML
    private Button btnsupp;
    @FXML
    private Button btnmodifiServ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ServiceService ss = new ServiceService();
        ArrayList<Service> Services;
        try {
            Services = (ArrayList<Service>) ss.getAllServices();
            ObservableList obs = FXCollections.observableArrayList(Services);
            table.setItems(obs);
            colonneNomService.setCellValueFactory(new PropertyValueFactory<>("nomService"));
            colonneCategorie.setCellValueFactory(new PropertyValueFactory<>("fk_idCategorie"));
            colonneLocalisation.setCellValueFactory(new PropertyValueFactory<>("location"));
            colonnePrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
            colonneDateAvailable.setCellValueFactory(new PropertyValueFactory<>("timeAvailable"));
            colonneDatecreation.setCellValueFactory(new PropertyValueFactory<>("dateCreation"));
        } catch (SQLException ex) {
            Logger.getLogger(AfficheServiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }    

    @FXML
    private void addservice(ActionEvent event) {
       try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterService.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage stage = (Stage) btnajouterservice.getScene().getWindow(); // Obtenir la fenêtre actuelle
        stage.setScene(scene);
    } catch (Exception e) {
        e.printStackTrace();
    }
        
    }

    @FXML
    private void homepage(ActionEvent event) {
         try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pageacceuilleFXML.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage stage = (Stage) btnhome.getScene().getWindow(); // Obtenir la fenêtre actuelle
        stage.setScene(scene);
    } catch (Exception e) {
        e.printStackTrace();
    }
         
        
    }

    @FXML
    private void suppservp(ActionEvent event) {
         try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SupprimerServiceFXML.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage stage = (Stage) btnsupp.getScene().getWindow(); // Obtenir la fenêtre actuelle
        stage.setScene(scene);
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    @FXML
    private void modiservp(ActionEvent event) {
        
         try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierserviceFXML.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage stage = (Stage) btnmodifiServ.getScene().getWindow(); 
        stage.setScene(scene);
    } catch (Exception e) {
        e.printStackTrace();
    }
        
    }

    }    
    

