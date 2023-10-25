
package GUI;

import api.SendSMS;
import models.Categorie;
import models.Service;
import services.ServiceService;
import services.CategorieService;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.StringConverter;
import org.controlsfx.control.Notifications;

public class AjouterServiceController {

    @FXML
    private TextField txtfieldLocation;

    @FXML
    private TextField txtfieldPrix;

    @FXML
    private DatePicker txtfieldDateAvaliable;

    @FXML
    private TextField txtfieldNomService;

    @FXML
    private Button btnAddService;

    @FXML
    private DatePicker txtfieldDateCreation;

    @FXML
    private ComboBox<Categorie> combocategorie;

    private ServiceService serviceService = new ServiceService();
    @FXML
    private Button butonretour;
    private Button btnajoutercategorie;
    @FXML
    private Button btnaffichecateg;

    public void initialize() {
        try {
            CategorieService categorieService = new CategorieService();
            List<Categorie> categories = categorieService.getAllCategories();

            // Utilisation d'un StringConverter pour personnaliser l'affichage dans le ComboBox
            combocategorie.setConverter(new StringConverter<Categorie>() {
                
                public String toString(Categorie categorie) {
                    return categorie.getNomCategorie();
                }

                
                public Categorie fromString(String string) {
                    // Cette méthode peut rester vide si vous n'avez pas besoin de convertir de String en Categorie
                    return null;
                }
            });

            combocategorie.getItems().addAll(categories);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void AddService(ActionEvent event) throws SQLException {
        String nomService = txtfieldNomService.getText();
    Date dateCreation = Date.valueOf(txtfieldDateCreation.getValue());
    String location = txtfieldLocation.getText();
    String prixText = txtfieldPrix.getText();
    String timeAvailableText = txtfieldDateAvaliable.getValue().toString();

    if (nomService.isEmpty() || location.isEmpty() || prixText.isEmpty() || timeAvailableText.isEmpty()) {
        // Afficher un message d'erreur ou prendre toute autre mesure appropriée
        System.out.println("Veuillez remplir tous les champs.");
        return; // Sortir de la méthode si un champ est vide
    }

    int prix = Integer.parseInt(prixText);
    Date timeAvailable = Date.valueOf(timeAvailableText);

    Categorie selectedCategorie = combocategorie.getValue();
    String nomCategorie = selectedCategorie.getNomCategorie();

    serviceService.ajouterService(nomService, dateCreation, location, prix, timeAvailable, nomCategorie);
    
    System.out.println("DONE");
    try {
            SendSMS sm = new SendSMS();
            Service Service = null;
            sm.sendSMS(Service);
            System.out.println("SMS envoyé avec succès");
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    Image img = new Image("image/logo.png");
    Notifications notificationBuilder = Notifications.create()
                
                .title("Nouvelle Service Exist")
                .text("Saved")
                .graphic(new ImageView(img))
                .hideAfter(Duration.seconds(5))
                .position(Pos.BOTTOM_RIGHT);
                notificationBuilder.show();
    
}

    @FXML
    private void retourAffiche(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficheService.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) butonretour.getScene().getWindow(); // Obtient la fenêtre actuelle
            stage.setScene(scene);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

//    private void addcategoriee(ActionEvent event) {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterCategorieFXML.fxml"));
//            Parent root = loader.load();
//            Scene scene = new Scene(root);
//
//            Stage stage = (Stage) btnajoutercategorie.getScene().getWindow(); // Obtient la fenêtre actuelle
//            stage.setScene(scene);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @FXML
    private void affichecateg(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("affichierCategorieFXML.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) btnaffichecateg.getScene().getWindow(); // Obtient la fenêtre actuelle
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
        
    }