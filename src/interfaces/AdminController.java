/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.AfficheAdmin;
import models.Reclamation;
import models.Utilisateurs;
import services.ServiceReclamation;
import services.ServiceUtilisateurs;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class AdminController implements Initializable {

    @FXML
    private TableView<AfficheAdmin> table;
    @FXML
    private TableColumn<AfficheAdmin, Integer> fxid_user;
    @FXML
    private TableColumn<AfficheAdmin, String> fxnom;
    @FXML
    private TableColumn<AfficheAdmin, String> fxemail;
    @FXML
    private TableColumn<AfficheAdmin, Integer> fxid_rec;
    @FXML
    private TableColumn<AfficheAdmin, String> fxobjet;
    @FXML
    private TableColumn<AfficheAdmin, String> fxdate;
    @FXML
    private TableColumn<AfficheAdmin, String> fxdescription;
    @FXML
    private TableColumn<AfficheAdmin, String> fxrole;
    @FXML
    private TableColumn<AfficheAdmin, String> fxetat;
    @FXML
    private TextField fxid;
    @FXML
    private Button fxsupprimer;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<AfficheAdmin> list = FXCollections.observableArrayList();

   try {
         ServiceReclamation es=new ServiceReclamation();
        
         
        list.addAll(es.readAll());
    System.out.println(list);
        // TODO
    }   catch (SQLException ex) {    
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    System.out.println("affiche successeful");
           fxdescription.setCellValueFactory(new PropertyValueFactory<AfficheAdmin, String>("description"));
          fxobjet.setCellValueFactory(new PropertyValueFactory<AfficheAdmin, String>("objet_reclamation"));
         fxdate.setCellValueFactory(new PropertyValueFactory<AfficheAdmin, String>("date_reclamation"));
         fxrole.setCellValueFactory(new PropertyValueFactory<AfficheAdmin, String>("role"));
         fxnom.setCellValueFactory(new PropertyValueFactory<AfficheAdmin, String>("nom"));
         fxemail.setCellValueFactory(new PropertyValueFactory<AfficheAdmin, String>("email"));
        fxetat.setCellValueFactory(new PropertyValueFactory<AfficheAdmin, String>("etat_reclamation"));
         
         
         
         
       table.setItems((ObservableList<AfficheAdmin>) list);
         
         //} catch (SQLException ex) {
         
         //}
     } 

    @FXML
    private void deleterec(ActionEvent event) {
        String idText = fxid.getText();

if (idText.isEmpty()) {
    afficherMessageErreur("Veuillez saisir l'ID de la réclamation.");
    return; // Arrêtez l'opération si le champ est vide
}

// Convertissez l'ID en entier (vous pouvez également gérer les erreurs ici)
int id = Integer.parseInt(idText);

// Utilisez un service pour supprimer la réclamation
ServiceReclamation serviceReclamation = new ServiceReclamation();
boolean suppressionReussie = serviceReclamation.deleteReclamation(new Reclamation(id, "", new Utilisateurs(), "", "", ""));

// Affichez un message à l'utilisateur en fonction du résultat de la suppression
if (suppressionReussie) {
    afficherMessageInformation("Réclamation supprimée avec succès.");
    fxid.clear(); // Effacez le champ d'ID après la suppression
} else {
    afficherMessageErreur("Échec de la suppression de la réclamation. Vérifiez l'ID.");
}






        }

    
    

    // Méthode pour afficher une boîte de dialogue d'erreur
    private void afficherMessageErreur(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Méthode pour afficher une boîte de dialogue d'information
    private void afficherMessageInformation(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    
    }

