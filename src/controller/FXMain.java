/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author DELL
 *//**
 *
 * @author DELL
 */
public class FXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {        
        Parent root=FXMLLoader.load(getClass().getResource("FXMLajoutp.fxml"));
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("ajouter un produit!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
