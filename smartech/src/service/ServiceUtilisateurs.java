/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Utilisateurs;
import util.Mybd;

public class ServiceUtilisateurs {
   
    private final Connection connection = Mybd.getInstance().getConnection();

    public ServiceUtilisateurs() {
    }
    
    

    public void ajouterUser(Utilisateurs user) {
        String req = "INSERT INTO utilisateurs (nom, prenom, mdp, email, role) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement; 
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, user.getNom());
            preparedStatement.setString(2, user.getPrenom());
            preparedStatement.setString(3, user.getmdp());
            preparedStatement.setString(4, user.getemail());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.executeUpdate();
            System.out.println("Utilisateur ajouté avec succès!");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUtilisateurs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Utilisateurs> afficherUser() {
        List<Utilisateurs> users = new ArrayList<>();
        String req = "SELECT * FROM utilisateurs WHERE 1";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(req);
            while (resultSet.next()) {
                Utilisateurs user = new Utilisateurs();
                user.setId(resultSet.getInt("Id"));
                user.setNom(resultSet.getString("Nom"));
                user.setPrenom(resultSet.getString("Prenom"));
                user.setmdp(resultSet.getString("mdp"));
                user.setemail(resultSet.getString("email"));
                user.setRole(resultSet.getString("role"));
               
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUtilisateurs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    public void modifierUser(Utilisateurs user) {
    String req = "UPDATE utilisateurs SET nom`=?,prenom`=?,`mdp`=?,`email`=?,`role`=? WHERE id=?";
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(req);
        preparedStatement.setString(1, user.getNom());
        preparedStatement.setString(2, user.getPrenom());
        preparedStatement.setString(3, user.getmdp());
        preparedStatement.setString(4, user.getemail());
        preparedStatement.setString(5, user.getRole());
        preparedStatement.setInt(6, user.getId());
        int rowsUpdated = preparedStatement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("User updated successfully!");
        } else {
            System.out.println("No user found with the given ID.");
        }
    } catch (SQLException ex) {
        Logger.getLogger(ServiceUtilisateurs.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    public void deleteUser(Utilisateurs user) {
    String req = "DELETE FROM utilisateurs WHERE id=?";
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(req);
        preparedStatement.setInt(1, user.getId());
        
        preparedStatement.executeUpdate();
        System.out.println("Supprimée");
    } catch (SQLException ex) {
        Logger.getLogger(ServiceUtilisateurs.class.getName()).log(Level.SEVERE, null, ex);
    }
    }  
   /* 
    public void deleteUserWithCascade(int userId) {
    try {
        // Delete Facture records associated with the user
        String deleteFactureQuery = "DELETE FROM Facture WHERE idCommande IN (SELECT id FROM Commandee WHERE id_user = ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteFactureQuery)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
        }

        // Delete Commandee records associated with the user
        String deleteCommandeeQuery = "DELETE FROM Commandee WHERE id_user = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteCommandeeQuery)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
        }

        // Finally, delete the user
        String deleteUserQuery = "DELETE FROM Utilisateurs WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteUserQuery)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
            System.out.println("User deleted successfully.");
        }
    } catch (SQLException e) {
        System.err.println("Error while deleting user: " + e.getMessage());
    }
}*/

     public Utilisateurs getUserById(int userId) {
        Utilisateurs user = null;
        String req = "SELECT * FROM utilisateurs WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new Utilisateurs();
                user.setId(resultSet.getInt("id"));
                user.setNom(resultSet.getString("Nom"));
                user.setPrenom(resultSet.getString("Prenom"));
                user.setmdp(resultSet.getString("mdp"));
                user.setemail(resultSet.getString("email"));
                user.setRole(resultSet.getString("role"));   
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUtilisateurs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

}
