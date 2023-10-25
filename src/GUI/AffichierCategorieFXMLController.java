/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import models.Categorie;
import services.CategorieService;
import java.net.URL;
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

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AffichierCategorieFXMLController implements Initializable {

    @FXML
    private TableView<Categorie> tablelistcategorie;
    @FXML
    private TableColumn<Categorie, Integer> colonneidCategorie;
    @FXML
    private TableColumn<Categorie, String> colonnenomCategorie;
    @FXML
    private TableColumn<Categorie, String> colonnedescriptionCategorie;
    @FXML
    private Button btnretour;
    @FXML
    private Button btnAjouterCat;
    @FXML
    private Button btnsuppcateg;
    @FXML
    private Button btnmodifiercat;
    @FXML
    private Button btnStat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CategorieService cs = new CategorieService();
        ArrayList<Categorie> Categories;
        
         try {
            Categories = (ArrayList<Categorie>) cs.getAllCategories();
            ObservableList obs = FXCollections.observableArrayList(Categories);
        tablelistcategorie.setItems(obs);
        colonneidCategorie.setCellValueFactory(new PropertyValueFactory<>("idCategorie"));
        colonnenomCategorie.setCellValueFactory(new PropertyValueFactory<>("nomCategorie"));
        colonnedescriptionCategorie.setCellValueFactory(new PropertyValueFactory<>("descriptionCategorie"));
        
        } catch (SQLException ex) {
            Logger.getLogger(AffichierCategorieFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        
        
    }
        
    }

    @FXML
    private void retourjouterserv(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterService.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) btnretour.getScene().getWindow(); // Obtient la fenêtre actuelle
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void ajoutercateg(ActionEvent event) {
        
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterCategorieFXML.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) btnAjouterCat.getScene().getWindow(); // Obtient la fenêtre actuelle
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @FXML
    private void supprimerCateg(ActionEvent event) {
        
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SupprimerCategorieFXML.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) btnsuppcateg.getScene().getWindow(); // Obtient la fenêtre actuelle
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @FXML
    private void modifiercate(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierCategorieFXML.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) btnmodifiercat.getScene().getWindow(); // Obtient la fenêtre actuelle
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Statis(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("StatistiqueFXML.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) btnStat.getScene().getWindow(); // Obtient la fenêtre actuelle
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
    

