/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author mznou
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       
        Parent root;
        try {
//            root=FXMLLoader.load(getClass().getResource("location_category.fxml"));
          //   Scene scene = new Scene(root);
                    root=FXMLLoader.load(getClass().getResource("location_category.fxml"));

             

             
                    Scene scene = new Scene(root, 1000, 600);

        primaryStage.setTitle("SMART TECH");
        primaryStage.setScene(scene);
        
        // Set window width and height
       // primaryStage.setWidth(1000);
      //  primaryStage.setHeight(800);
        
        // Make window non-resizable
        primaryStage.setResizable(false);
        
        primaryStage.show();
             
             
             
             
             
             
             
        primaryStage.setTitle("SMARTTECH");
        primaryStage.setScene(scene);
        primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }}
  
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
