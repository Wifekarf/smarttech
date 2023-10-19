package Interfaces;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.time.LocalDate;
import models.Commandee;
import models.Facture;
import service.FactureService;

public class AjoutFactureController implements Initializable {

    @FXML
    private TextField CommandeIdTextField;
    @FXML
    private TextField MontantTextField;
    @FXML
    private Button ConfirmerFacture;
    @FXML
    private Button AnnulerFacture;
    @FXML
    private Button AfficherFactures;

    private FactureService factureService;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ConfirmerFacture.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                factureService = new FactureService();

                try {
                    int commandeId = Integer.parseInt(CommandeIdTextField.getText());
                    double montant = Double.parseDouble(MontantTextField.getText());

                    Facture nouvelleFacture = new Facture();
                    Commandee commandee = new Commandee();
                    commandee.setId(commandeId);
                    nouvelleFacture.setCommandee(commandee);
                    nouvelleFacture.setMontant(montant);
                    nouvelleFacture.setDate(LocalDate.now());

                    factureService.ajouterFacture(nouvelleFacture);
                } catch (Exception ex) {
                    Logger.getLogger(AjoutFactureController.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    ConfirmerFacture.getScene().setRoot(FXMLLoader.load(getClass().getResource("AjouterFacture.fxml")));
                } catch (Exception ex) {
                    Logger.getLogger(AjoutFactureController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
