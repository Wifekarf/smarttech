/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import models.Produits;
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
public class Serviceproduit {
    private final DataSource myDataSource = DataSource.getInstance();
    
    private final Connection cnx = myDataSource.getConnection();
    
    public void ajouterProduit(Produits produit) {
        //int IdP = produit.getTp().getIdP();
        //Serviceproduit sp =new Serviceproduit();
        Servicetype st = new Servicetype();
        //if (sp.TypeExist(IdP)){
        String req = "INSERT INTO produits (prix, description, image, nom_produit, nombre_produits, idT) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = cnx.prepareStatement(req);
           // preparedStatement.setInt(1, produit.getId());
            preparedStatement.setInt(1, produit.getPrix()); 
            preparedStatement.setString(2, produit.getDescription());
            preparedStatement.setString(3, produit.getImage());
            preparedStatement.setString(4, produit.getNom_produit());
            preparedStatement.setInt(5, produit.getNbP());
            preparedStatement.setInt(6, produit.getTp().getIdT());
            

            
                   preparedStatement.executeUpdate();
            
            System.out.println("produit ajouté avec succes");
            
        }
        catch (SQLException ex) {
            Logger.getLogger(Serviceproduit.class.getName()).log(Level.SEVERE,null,ex);   
        }
    }
    
    public List<Produits> afficheProduit(){
    List<Produits> produits = new ArrayList<>();
    String req = "SELECT * FROM `produits`";
    try{ 
        Statement stm = cnx.createStatement();
        ResultSet resultSet = stm.executeQuery(req);
        while (resultSet.next()) {
            Produits produit = new Produits();
            
            produit.setPrix(resultSet.getInt("Prix"));
            produit.setDescription(resultSet.getString("Description"));
            produit.setImage(resultSet.getString("image"));
            produit.setNom_produit(resultSet.getString("Nom_produit"));
            produit.setNbP(resultSet.getInt("nombre_produits"));
            
            produits.add(produit);
        }
    }
    catch(SQLException ex){
        Logger.getLogger(Serviceproduit.class.getName()).log(Level.SEVERE,null,ex);
    
    }return produits;
       
    
    }


    public void modifierProduit(Produits p) {
        String req =" UPDATE `produits` SET`prix`=?,`description`=?,`image`=?,`nom_produit`=? WHERE idP=?";
        try{
            PreparedStatement preparedStatement = cnx.prepareStatement(req);
            preparedStatement.setInt(1,p.getPrix()); 
            preparedStatement.setString(2,p.getDescription());
            preparedStatement.setString(3,p.getImage());
            preparedStatement.setString(4,p.getNom_produit());
            preparedStatement.setInt(5,p.getNbP());
            
            int rowUpdated = preparedStatement.executeUpdate();
            if (rowUpdated > 0)
            {
            System.out.println("produit modifié avec succes");
            }
            else{
                System.out.println("no produit found");
                }
        }
        catch(SQLException ex) {
            Logger.getLogger(Serviceproduit.class.getName()).log(Level.SEVERE,null,ex);
                }        
        }
        
    
    public void supprimerProduit(int idProduit) throws SQLException {
        String req = "DELETE FROM `produits` WHERE idP=?";
        
        
            PreparedStatement preparedStatement = cnx.prepareStatement(req);
            preparedStatement.setInt(1,idProduit);
            preparedStatement.executeUpdate();
        
        
    }

    public Produits getproduitById(int produitId) {
        Produits produit = null;
        String req = "SELECT * FROM `produits` WHERE idP=?";
        try{
        PreparedStatement preparedStatement = cnx.prepareStatement(req);
        preparedStatement.setInt(1, produitId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next())
        {produit = new Produits();
        
        produit.setPrix(resultSet.getInt("prix"));
        produit.setDescription(resultSet.getString("description"));
        produit.setImage(resultSet.getString("image"));
        produit.setNom_produit(resultSet.getString("nom_produit"));
        produit.setNbP(resultSet.getInt("nombre_produit"));
        }
        }
        catch(SQLException ex){
        Logger.getLogger(Serviceproduit.class.getName()).log(Level.SEVERE,null,ex);
        }
        return produit;
    }
    } 

   
   

    
