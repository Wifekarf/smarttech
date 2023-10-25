/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import MyDB.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class Categorie {

    public static Categorie getCategorieById(int id) throws SQLException {
        String req = "SELECT * FROM categorie WHERE IdCategorie = ?";
        Connection connection = MyConnection.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(req);
        ps.setInt(1, id);

        ResultSet rst = ps.executeQuery();

        if (rst.next()) {
            return new Categorie(
                rst.getInt("IdCategorie"),
                rst.getString("NomCategorie"),
                rst.getString("DescriptionCategorie")
            );
        }

        return null; 
    }



    
        
    private int idCategorie;
    private String nomCategorie;
    private String descriptionCategorie;

    public Categorie() {
    }

    public Categorie(String nomCategorie, String descriptionCategorie) {
        this.nomCategorie = nomCategorie;
        this.descriptionCategorie = descriptionCategorie;
    }

    public Categorie(int idCategorie, String nomCategorie, String descriptionCategorie) {
        this.idCategorie = idCategorie;
        this.nomCategorie = nomCategorie;
        this.descriptionCategorie = descriptionCategorie;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public String getDescriptionCategorie() {
        return descriptionCategorie;
    }

    public void setDescriptionCategorie(String descriptionCategorie) {
        this.descriptionCategorie = descriptionCategorie;
    }

    @Override
    public String toString() {
        return "Categorie{" + "idCategorie=" + idCategorie + ", nomCategorie=" + nomCategorie + ", descriptionCategorie=" + descriptionCategorie + '}';
    }

    
}