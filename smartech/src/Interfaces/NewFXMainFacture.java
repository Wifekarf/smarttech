package Interfaces;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NewFXMainFacture extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Charger l'interface AjouterFacture.fxml
        Parent root = FXMLLoader.load(getClass().getResource("AjoutFacture.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("Ajout de Facture");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
