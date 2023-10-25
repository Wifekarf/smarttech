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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Mybd;

/**
 * CategorieService class for handling database operations related to categories.
 */
public class CategorieService {

    Connection connection;

    public CategorieService() {
        this.connection = Mybd.getInstance().getConnection();
    }

    public void ajouterCategorie(Categorie categorie) throws SQLException {
        String req = "INSERT INTO categorie (NomCategorie, DescriptionCategorie) VALUES (?, ?)";
        PreparedStatement ps = connection.prepareStatement(req);
        ps.setString(1, categorie.getNomCategorie());
        ps.setString(2, categorie.getDescriptionCategorie());
        ps.executeUpdate();
    }

    public void modifierCategorie(Categorie categorie, String ancienNomCategorie) throws SQLException {
        String req = "UPDATE categorie SET NomCategorie = ?, DescriptionCategorie = ? WHERE NomCategorie = ?";
        PreparedStatement ps = connection.prepareStatement(req);

        ps.setString(1, categorie.getNomCategorie());
        ps.setString(2, categorie.getDescriptionCategorie());
        ps.setString(3, ancienNomCategorie);

        ps.executeUpdate();
    }

    public void supprimerCategorie(String nomCategorie) throws SQLException {
        String req = "DELETE FROM categorie WHERE NomCategorie = ?";
        PreparedStatement ps = connection.prepareStatement(req);
        ps.setString(1, nomCategorie);
        ps.executeUpdate();
    }

    public List<Categorie> getAllCategories() throws SQLException {
        List<Categorie> Categories = new ArrayList<>();
        String req = "SELECT * FROM categorie";
        Statement stm = connection.createStatement();
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
