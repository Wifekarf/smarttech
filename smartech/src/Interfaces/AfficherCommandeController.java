package Interfaces;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import models.Commandee;
import service.CommandeeService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AfficherCommandeController implements Initializable {

    @FXML
    private ListView<String> commandesListView;

    private CommandeeService commandeeService;
    private ObservableList<String> commandesList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        commandeeService = new CommandeeService();
        commandesList = FXCollections.observableArrayList();

        // Charger la liste de commandes depuis la base de données
        List<Commandee> commandes = commandeeService.afficherCommandees(utilisateur) ; 

        // Construire la liste de chaînes pour l'affichage
        for (Commandee commande : commandes) {
            String commandeString = "ID : " + commande.getId() +
                    " - Service : " + commande.getService() +
                    " - Date : " + commande.getDate();
            commandesList.add(commandeString);
        }

        // Ajouter la liste de chaînes à la ListView
        commandesListView.setItems(commandesList);
    }
}

