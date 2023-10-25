/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// CommandeeService.java

package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Commandee;
import models.Utilisateurs;
import util.Mybd;


public class CommandeeService {
    
    private final Connection connection = Mybd.getInstance().getConnection();

   
    public void ajouterCommandee(Commandee commandee) {
        String req = "INSERT INTO Commandee (id_user, service, date) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, commandee.getUtilisateur().getId());
            preparedStatement.setString(2, commandee.getService());
            preparedStatement.setDate(3, java.sql.Date.valueOf(commandee.getDate()));
            preparedStatement.executeUpdate(); 
            System.out.println("Commandee ajoutée avec succès!");
        } catch (SQLException ex) {
            Logger.getLogger(CommandeeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modifierCommandee(Commandee commandee ,int id ) {
        String req = "UPDATE Commandee SET service=?, date=? WHERE id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, commandee.getService());
            preparedStatement.setDate(2, java.sql.Date.valueOf(commandee.getDate())); 
            preparedStatement.setInt(3, id);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Commandee mise à jour avec succès!");
            } else {
                System.out.println("Aucune Commandee trouvée avec l'ID donné.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommandeeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


     
     public void supprimerCommandee(int idcommandee) {
        String req = "DELETE FROM Commandee WHERE id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1,idcommandee );
            preparedStatement.executeUpdate();
            System.out.println("Commandee supprimée avec succès!");
        } catch (SQLException ex) {
            Logger.getLogger(CommandeeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public List<Commandee> afficherCommandees(Utilisateurs utilisateur) {
        List<Commandee> commandees = new ArrayList<>();
        String req = "SELECT * FROM Commandee where id_user = " + utilisateur.getId();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(req);
            
            while (resultSet.next()) {
                Commandee commandee = new Commandee();
                commandee.setId(resultSet.getInt("id"));
                
                commandee.setUtilisateur(new ServiceUtilisateurs().getUserById(resultSet.getInt("id_user")));
                
                commandee.setService(resultSet.getString("service"));
                commandee.setDate(resultSet.getDate("date").toLocalDate());
                commandees.add(commandee);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommandeeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return commandees;
    }
    
    
    public Commandee getCommandeeById(int commandeeId) {
    Commandee commandee = null;
    String req = "SELECT * FROM Commandee WHERE id = ?";
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(req);
        preparedStatement.setInt(1, commandeeId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            commandee = new Commandee();
            commandee.setId(resultSet.getInt("id"));
            
            // Retrieve the associated Utilisateurs from ServiceUtilisateurs
            Utilisateurs utilisateur = new ServiceUtilisateurs().getUserById(resultSet.getInt("id_user"));
            commandee.setUtilisateur(utilisateur);
            
            commandee.setService(resultSet.getString("service"));
            commandee.setDate(resultSet.getDate("date").toLocalDate());
        }
    } catch (SQLException ex) {
        Logger.getLogger(CommandeeService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return commandee;
}
    public List<Commandee> afficherCommandes() {
    List<Commandee> commandes = new ArrayList<>();
    String req = "SELECT * FROM Commandee"; // Remplacez par la table réelle des commandes

    try {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(req);

        while (resultSet.next()) {
            Commandee commande = new Commandee();
            commande.setId(resultSet.getInt("id"));
            // Définissez d'autres propriétés de la commande ici
            commandes.add(commande);
        }
    } catch (SQLException ex) {
        Logger.getLogger(CommandeeService.class.getName()).log(Level.SEVERE, null, ex);
    }

    return commandes;
} 
    public void supprimerLignesDepassees() {
    LocalDate now = LocalDate.now();
    
    String query = "DELETE FROM Commandee WHERE DATEDIFF(?, date) > 1";
    
    try {
        PreparedStatement deleteStatement = connection.prepareStatement(query);
        deleteStatement.setDate(1, java.sql.Date.valueOf(now));
        int rowsDeleted = deleteStatement.executeUpdate();
        System.out.println(rowsDeleted + " lignes de Commandee supprimées.");
    } catch (SQLException ex) {
        Logger.getLogger(CommandeeService.class.getName()).log(Level.SEVERE, null, ex);
    }
}


}

