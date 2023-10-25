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
public class SupprimerCategorieFXMLController implements Initializable {

    private TextField txtNomCategorie;
    @FXML
    private Button btSuppCategorie;
    private CategorieService categorieService = new CategorieService();
    @FXML
    private ComboBox<Categorie> comboNomcategoriesupp;
    @FXML
    private Button btnretour;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
        List<Categorie> categories = categorieService.getAllCategories();
        
        comboNomcategoriesupp.setConverter(new StringConverter<Categorie>() {
            @Override
            public String toString(Categorie categorie) {
                return categorie.getNomCategorie();
            }

            @Override
            public Categorie fromString(String string) {
                return null; // Non utilisé ici
            }
        });

        comboNomcategoriesupp.getItems().addAll(categories);
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
        
        // TODO
    }    

    @FXML
    private void SuppCategorie(ActionEvent event) throws SQLException {
     try {
        Categorie selectedCategorie = comboNomcategoriesupp.getValue();

        if (selectedCategorie == null) {
            System.out.println("Veuillez sélectionner une catégorie.");
            return;
        }

        categorieService.supprimerCategorie(selectedCategorie.getNomCategorie());
        System.out.println("Catégorie supprimée avec succès.");
    } catch (SQLException ex) {
        System.out.println("Erreur lors de la suppression de la catégorie.");
        ex.printStackTrace();
    }
}

    @FXML
    private void retourcateg(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("affichierCategorieFXML.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) btnretour.getScene().getWindow(); // Obtient la fenêtre actuelle
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
