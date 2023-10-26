/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Produits;

public class DataService {
    private Connection connection;
    private MyDB myDB;

    public DataService() {
        myDB = MyDB.getInstance();
        connection = myDB.getConnection();
    }

    public List<Produits> getAllProduits() throws SQLException {
    List<Produits> productList = new ArrayList<>();
    String query = "SELECT * FROM produits";

    try (PreparedStatement statement = connection.prepareStatement(query);
         ResultSet resultSet = statement.executeQuery()) {
        while (resultSet.next()) {
            Produits produit = new Produits(
                resultSet.getInt("idP"),
                resultSet.getFloat("prix"),
                resultSet.getString("description"),
                resultSet.getString("nom_produit")
            );
            productList.add(produit);
        }
    } catch (SQLException ex) {
        ex.printStackTrace(); // Log the exception
    }

    return productList;
}



    // Add more database interaction methods as needed

    public List<String> getProductData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
