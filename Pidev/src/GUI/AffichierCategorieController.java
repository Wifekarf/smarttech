/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Categorie;
import Entities.Service;
import Service.CategorieService;
import java.net.URL;
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
public class AffichierCategorieController implements Initializable {

    @FXML
    private TableView<Categorie> table;
    @FXML
    private TableColumn<Categorie, Integer> idcategoriecolonne;
    @FXML
    private TableColumn<Categorie, String> nomcategoriecolonne;
    @FXML
    private TableColumn<Categorie, String> colonneDescription;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
        CategorieService cs = new CategorieService();
        ArrayList<Categorie> Categories;
        
        try {
            Categories = (ArrayList<Categorie>) cs.getAllCategories();
        } catch (SQLException ex) {
            Logger.getLogger(AffichierCategorieController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList obs = FXCollections.observableArrayList(Categories);
        table.setItems(obs);
        idcategoriecolonne.setCellValueFactory(new PropertyValueFactory<>("idCategorie"));
        nomcategoriecolonne.setCellValueFactory(new PropertyValueFactory<>("nomCategorie"));
        colonneDescription.setCellValueFactory(new PropertyValueFactory<>("descriptionCategorie"));
        
    }
        
    }    
    

