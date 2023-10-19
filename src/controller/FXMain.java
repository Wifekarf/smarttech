/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Type_produit;
import service.Servicetype;
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
//        Parent root=FXMLLoader.load(getClass().getResource("FXMLajoutp.fxml"));
//        Scene scene = new Scene(root);
//        
//        stage.setTitle("ajouter un produit!");
//        stage.setScene(scene);
//        stage.show();
        
        Parent p=FXMLLoader.load(getClass().getResource("FXMLajoutType.fxml"));
        Scene scene = new Scene(p);
        
        stage.setTitle("ajouter un type!");
        stage.setScene(scene);
        stage.show();
        
//        Servicetype st = new Servicetype();
//        ListView <Type_produit> type_produits = st.afficheType();
//        ObservableList<String> type_names = FXCollections.observableArrayList("ID: "," Nom de type: "," Description : " );
//        // Ajouter les noms d'équipements à la liste observable
//        type_produits.forEach((type_produit) -> { 
//            type_names.add("ID: " + type_produit.getIdT()+
//                                 ", Nom de type: " + type_produit.getNom_type()+
//                                 ", Description : " + type_produit.getDescription());
//    });   
//        // Charger les données dans la ListView
//        type_produits.setOrientation(Orientation.HORIZONTAL); ;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
