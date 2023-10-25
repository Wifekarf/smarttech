/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import models.Categorie;
import services.CategorieService;
import services.ServiceService;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjouterCategorieFXMLController implements Initializable {

    @FXML
    private TextField txtNomCategorie;
    @FXML
    private TextField txtDescriptionCategorie;
    @FXML
    private Button btnConfirmer;
    private CategorieService categorieService = new CategorieService();
    @FXML
    private Button btnretour;

    /**
     * 
     */
   @FXML
    void AddCategorie(ActionEvent event) throws SQLException {
         try {
        String nomCategorie = txtNomCategorie.getText();
        String descriptionCategorie = txtDescriptionCategorie.getText();

        if (nomCategorie.isEmpty() || descriptionCategorie.isEmpty()) {
            System.out.println("Veuillez remplir tous les champs.");
            return; // Sortir de la méthode si un champ est vide
        }

        System.out.println(descriptionCategorie);
        System.out.println(nomCategorie);

        Categorie categorie = new Categorie(nomCategorie, descriptionCategorie);
        categorieService.ajouterCategorie(categorie);

        System.out.println("DONE");
        Notifications notificationBuilder = Notifications.create()
                .title("Nouvelle Categorie Exist")
                .text("Saved")
                .hideAfter(Duration.seconds(5))
                .position(Pos.BOTTOM_RIGHT);
                notificationBuilder.show();
                        
    } catch (Exception e) {
        System.out.println("Erreur : " + e.getMessage());
        e.printStackTrace(); 
    }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }

    @FXML
    private void retourAjouterser(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("affichierCategorieFXML.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) btnretour.getScene().getWindow(); 
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

  
    
}
