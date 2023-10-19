/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.Connection;
import Entities.Categorie;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import MyDB.MyConnection;

        
        

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



    
    



    
    
    
    
    
    

