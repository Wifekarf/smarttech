/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.Type_produit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tool.DataSource;

/**
 *
 * @author DELL
 */
public class Servicetype {

    private final DataSource myDataSource = DataSource.getInstance();
    
    Connection cnx = myDataSource.getConnection();
    
    public boolean typeExists(int IdT) {
    String req = "SELECT COUNT(*) FROM type_produit WHERE IdT = ?";
    try {
        PreparedStatement preparedStatement = cnx.prepareStatement(req);
        preparedStatement.setInt(1, IdT);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            return count >0;
        }
    } catch (SQLException ex) {
        Logger.getLogger(Servicetype.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
}
    
    public void ajouterType(Type_produit type_produit) {
        try {
            String req = "INSERT INTO `type_produit`( `nom_type`, `description`) VALUES (?,?)";
            
            PreparedStatement preparedStatement = cnx.prepareStatement(req);
            preparedStatement.setString(1, type_produit.getNom_type());
            preparedStatement.setString(2, type_produit.getDescription());
            preparedStatement.executeUpdate();
            System.out.println("type ajoute avec succes");
        } catch (SQLException ex) {
             Logger.getLogger(Servicetype.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

     public List<Type_produit> afficheType() {
         
        List<Type_produit> type_produits = new ArrayList<>();
        String req = "SELECT * FROM `type_produit`";
        
        try{
            Statement stm = cnx.createStatement();
            ResultSet resultSet = stm.executeQuery(req);
            while (resultSet.next()) {
                Type_produit type_produit = new Type_produit();
                
                
                type_produit.setNom_type(resultSet.getString("nom_type"));
                type_produit.setDescription(resultSet.getString("description"));
            type_produits.add(type_produit);
            }
        
    }
        
        
     catch (SQLException ex) {
         Logger.getLogger(Servicetype.class.getName()).log(Level.SEVERE, null, ex);
    }
    return type_produits;
    }
    

    public void supprimerType(Type_produit type_produit){
        String req = "DELETE FROM `type_produit` WHERE IdT=?";
               try {
            PreparedStatement preparedStatement = cnx.prepareStatement(req);
             preparedStatement.setInt(1,type_produit.getIdT());
          
             int rowsDeleted = preparedStatement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("type supprimer avec succée!");
        } else {
            System.out.println(" Aucune type avec cette ID ");
        }
    } catch (SQLException ex) {
        Logger.getLogger(Servicetype.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }
    
    public void modifierType(Type_produit type_produit) {
    
          
     
            String req ="UPDATE `type_produit` SET `nom_type`=?,`description`=? WHERE IdT=?";
             try {
                 PreparedStatement preparedStatement = cnx.prepareStatement(req);
             
            
            preparedStatement.setString(1, type_produit.getNom_type());
            preparedStatement.setString(2, type_produit.getDescription());
            preparedStatement.setInt(3,type_produit.getIdT());                      
            
           
            int rowsUpdated = preparedStatement.executeUpdate();

        if (rowsUpdated > 0) {
            System.out.println("type modifier avec succée!");
        } else {
            System.out.println("Aucune type avec cette ID");
        }
        }
         catch (SQLException ex) {
              Logger.getLogger(Servicetype.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

       
        public Type_produit getTypeById(int IdT) {
        Type_produit type_produit = null;
        String req = "SELECT * FROM `type_produit` WHERE IdT = ?";
        try {
            PreparedStatement preparedStatement = cnx.prepareStatement(req);
            preparedStatement.setInt(1, IdT);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                type_produit = new Type_produit();
                type_produit.setIdT(resultSet.getInt("IdT"));
                type_produit.setNom_type(resultSet.getString("Nom type"));
                type_produit.setDescription(resultSet.getString("Description type"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servicetype.class.getName()).log(Level.SEVERE, null, ex);
        }
        return type_produit;
    }
    /**
     *
     * @param t
     * @return
     */
   
    
}
