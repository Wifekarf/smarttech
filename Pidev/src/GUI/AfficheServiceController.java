/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Service;
import Service.ServiceService;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
    }    
    

