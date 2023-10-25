/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. */
                                                                   
package GUI;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/*
 *
 * @author ASUS
 */                                               
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
    /*    try {
    Parent root = FXMLLoader.load(getClass().getResource("/GUI/AjouterCategorieFXMLController.fxml"));
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
} catch (IOException e) {
    e.printStackTrace();
}*/
 
      //   Parent root= FXMLLoader.load(getClass().getResource("/GUI/AjouterService.fxml"));
               //  Parent root= FXMLLoader.load(getClass().getResource("/GUI/AfficheService.fxml"));
                //  Parent root= FXMLLoader.load(getClass().getResource("/GUI/ajouterCategorieFXML.fxml"));               
                  Parent root= FXMLLoader.load(getClass().getResource("/GUI/pageacceuilleFXML.fxml"));
                //  Parent root= FXMLLoader.load(getClass().getResource("/GUI/StatistiqueFXML.fxml"));

        Scene scene=new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
