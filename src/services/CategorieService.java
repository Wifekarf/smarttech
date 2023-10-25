/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import models.Categorie;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import MyDB.MyConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


        
        

/**
 *
 * @author ASUS
 */
public class CategorieService {
    
    Connection connextion;
    
    public CategorieService() {
        this.connextion = MyConnection.getInstance().getConnection();
    }
    /*****************************/
    public void ajouterCategorie(Categorie categorie) throws SQLException {
        String req ="INSERT INTO `categorie`(`NomCategorie`, `DescriptionCategorie`) VALUES (?,?)";
        PreparedStatement ps = connextion.prepareStatement(req);
        ps.setString(1, categorie.getNomCategorie());
        ps.setString(2, categorie.getDescriptionCategorie());
        ps.executeUpdate();
    }
    // Supprimer Categorie
    
   public void modifierCategorie(Categorie categorie, String ancienNomCategorie) throws SQLException {
    String req = "UPDATE `categorie` SET `nomCategorie`=?, `descriptionCategorie`=? WHERE nomCategorie=?";
    PreparedStatement ps = connextion.prepareStatement(req);
    
    // Configurez les paramètres
    ps.setString(1, categorie.getNomCategorie());
    ps.setString(2, categorie.getDescriptionCategorie());
    ps.setString(3, ancienNomCategorie); // Utilisez l'ancien nom de catégorie pour identifier la ligne à mettre à jour
    
    ps.executeUpdate();
}
    public void supprimerCategorie(String nomCategorie  ) throws SQLException {
        String req ="DELETE FROM `categorie` WHERE nomCategorie = ? ";
        PreparedStatement ps = connextion.prepareStatement(req);
        ps.setString(1, nomCategorie);
        
        ps.executeUpdate();
    }
    /*******************************/
    public List<Categorie> getAllCategories() throws SQLException {
    List<Categorie> Categories = new ArrayList<>();
    String req = "SELECT * FROM categorie"; // 
    Connection connextion = MyConnection.getInstance().getConnection();
    Statement stm = connextion.createStatement();
    ResultSet rst = stm.executeQuery(req);

    while (rst.next()) {
        Categorie categorie = new Categorie(
                rst.getInt("IdCategorie"),
                rst.getString("NomCategorie"),
                rst.getString("DescriptionCategorie")
        );
        Categories.add(categorie);
    }
    return Categories;
}


        
        
        
                
        
            
            
    
        
        

        
        
        
        
    }



    
    



    
    
    
    
    
    

