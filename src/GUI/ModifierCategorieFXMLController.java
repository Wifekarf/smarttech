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
public class ModifierCategorieFXMLController implements Initializable {

    private TextField txtNomCategorie;
    @FXML
    private TextField txtNouNomCategorie;
    @FXML
    private TextField TXTnOUVdESCRIPTION;
    @FXML
    private Button btnmodifier;
    @FXML
    private ComboBox<Categorie> combox;
    @FXML
    private Button btnretour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            CategorieService categorieService = new CategorieService();
            List<Categorie> categories = categorieService.getAllCategories();

            combox.setConverter(new StringConverter<Categorie>() {
                
                public String toString(Categorie categorie) {
                    return categorie.getNomCategorie();
                }

                
                public Categorie fromString(String string) {
                    return null;
                }
            });

            combox.getItems().addAll(categories);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void modifiercategorie(ActionEvent event) throws SQLException {{
    try {
        Categorie ancienneCategorie = combox.getValue(); 
        String nouveauNomCategorie = txtNouNomCategorie.getText();
        String nouvelleDescription = TXTnOUVdESCRIPTION.getText();

        if (ancienneCategorie == null || nouveauNomCategorie.isEmpty() || nouvelleDescription.isEmpty()) {
            System.out.println("Veuillez remplir tous les champs.");
            return; 
        }

        CategorieService categorieService = new CategorieService();

        Categorie nouvelleCategorie = new Categorie(nouveauNomCategorie, nouvelleDescription);

        categorieService.modifierCategorie(nouvelleCategorie, ancienneCategorie.getNomCategorie());
        System.out.println("Categorie modified successfully.");
    } catch (SQLException ex) {
        System.out.println("Error modifying Categorie.");
        ex.printStackTrace(); 
    }}}

    @FXML
    private void retourAfficheC(ActionEvent event) {
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
    

