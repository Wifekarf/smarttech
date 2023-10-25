/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import models.Type_produit;
import services.Servicetype;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
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
    public void start(Stage stage) throws IOException {        
  

Parent root = FXMLLoader.load(getClass().getResource("accueil.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("Gestion de produit");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

//        Parent root1=FXMLLoader.load(getClass().getResource("FXMLajoutp.fxml"));
//        Scene scene1 = new Scene(root1);
//        
//        stage.setTitle("ajouter un produit!");
//        stage.setScene(scene1);
//        stage.show();

//Parent root2=FXMLLoader.load(getClass().getResource("FXMLmodifierType.fxml"));
//        Scene scene2 = new Scene(root2);
//        
//        stage.setTitle("modifier un produit!");
//        stage.setScene(scene2);
//        stage.show();


        
//        Parent root3=FXMLLoader.load(getClass().getResource("FXMLajoutType.fxml"));
//        Scene scene3 = new Scene(root3);
//        
//        stage.setTitle("ajouter un type!");
//        stage.setScene(scene2);
//        stage.show();
//        
//        Parent root4=FXMLLoader.load(getClass().getResource("FXMLmodifierType.fxml"));
//        Scene scene1 = new Scene(root4);
//        
//        stage.setTitle("modifier un type!");
//        stage.setScene(scene1);
//        stage.show();
        
//     