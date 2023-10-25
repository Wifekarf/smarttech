/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
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
import services.CommandeeService;
import models.Commandee;
import models.Utilisateurs;

public class AfficherCommadesController implements Initializable {

    @FXML
    private TableView<Commandee> table;

    @FXML
    private TableColumn<Commandee, Integer> IdCommande;
    @FXML
    private TableColumn<Commandee, Integer> idUser;
    @FXML
    private TableColumn<Commandee, String> Service;
    @FXML
    private TableColumn<Commandee, String> Date;
    @FXML
    private Button AnnulerAffichage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Définir comment chaque colonne doit afficher les données
        IdCommande.setCellValueFactory(new PropertyValueFactory<>("id"));
        idUser.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        Service.setCellValueFactory(new PropertyValueFactory<>("service"));
        Date.setCellValueFactory(new PropertyValueFactory<>("Date"));


        // Chargez les données depuis la base de données et les afficher dans le TableView
        Utilisateurs utilisateur = new Utilisateurs();
        utilisateur.setId(1); // Remplacez par l'ID de l'utilisateur actuel

        CommandeeService commandeeService = new CommandeeService();
        
        // Chargez les commandes de l'utilisateur actuel
        List<Commandee> commandes = commandeeService.afficherCommandees(utilisateur);
        
        // Ajoutez les commandes au TableView
        table.getItems().addAll(commandes);
    }

    @FXML
    private void AnnulerAffi(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterCommande.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) AnnulerAffichage.getScene().getWindow(); // Obtient la fenêtre actuelle
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

