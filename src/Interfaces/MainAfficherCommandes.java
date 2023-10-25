/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author MSI
 */
public class MainAfficherCommandes extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Charger le fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherCommades.fxml")); 
        Parent root = loader.load();

        // Créer une scène
        Scene scene = new Scene(root);

        // Définir le titre de la fenêtre
        primaryStage.setTitle("Liste Commandes"); 

        // Définir la scène dans la fenêtre
        primaryStage.setScene(scene);

        // Afficher la fenêtre
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     **/
    public static void main(String[] args) {
        launch(args);
    } 
    
    
}
