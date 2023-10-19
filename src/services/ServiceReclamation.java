
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.AfficheAdmin;
import models.Reclamation;
import models.Utilisateurs;
import util.MyDB;
import services.ServiceUtilisateurs;

/**
 * @author msi
 */
public class ServiceReclamation {

    private MyDB myConnection = MyDB.getInstance();
    private Connection connection = myConnection.getCnx();

    /**
     * Ajoute une réclamation à la base de données.
     * @param reclamation La réclamation à ajouter.
     */
    public boolean ajouterReclamation(Reclamation reclamation) {
        String req = "INSERT INTO `reclamation`( `description`, `id_user`, `date_reclamation`, `objet_reclamation`,`etat_reclamation`) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, reclamation.getDescription());
            preparedStatement.setInt(2, reclamation.getUser().getId());
            preparedStatement.setString(3, reclamation.getDate_reclamation());
            preparedStatement.setString(4, reclamation.getObjet_reclamation());
             preparedStatement.setString(5, reclamation.getEtat_reclamation());
           
            preparedStatement.executeUpdate();
            System.out.println("Réclamation ajoutée avec succès!");
            return true ;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
            return false ;
        }
    

    /**
     * Modifie une réclamation existante dans la base de données.
     * @param reclamation La réclamation à modifier.
     */

    /**
     * Modifie une réclamation existante dans la base de données.
     * @param reclamation La réclamation à modifier.
     * @return
     */
    public boolean modifierReclamation(Reclamation reclamation) {
        String req = "UPDATE `reclamation` SET `description`=?,   WHERE `Id_rec`=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, reclamation.getDescription());
            
            
           
             preparedStatement.setInt(2, reclamation.getId_rec());

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Réclamation mise à jour avec succès!");
                return true;
            }
            else {
                System.out.println("Aucune réclamation trouvée avec l'ID donné.");
                return false ;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    

    /**
     * Supprime une réclamation de la base de données.
     * @param reclamation La réclamation à supprimer.
     */

    /**
     * Supprime une réclamation de la base de données.
     * @param reclamation La réclamation à supprimer.
     * @return
     */
    public boolean deleteReclamation(Reclamation reclamation) {
        String req = "DELETE FROM `reclamation` WHERE `id_user` = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(2, reclamation.getUser().getId());

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Réclamation supprimée avec succès!");
                return true ;
            } else {
                System.out.println("Aucune réclamation trouvée avec l'ID donné.");
                return false ;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false ;
    }

    /**
     * Récupère toutes les réclamations depuis la base de données.
     * @return Une liste de réclamations.
     */
public ObservableList<Reclamation> readAllAd() throws SQLException {
        ObservableList<Reclamation> arr = FXCollections.observableArrayList();
        Statement ste = null;
        ste = connection.createStatement();
        
        ResultSet re = ste.executeQuery("SELECT * FROM Reclamation");

        while (re.next()) {
            Reclamation r = new Reclamation();
            r.setId_rec(re.getInt("id_rec"));
            r.setDescription(re.getString("description"));
            r.setDate_reclamation(re.getString("date_reclamation"));
            r.setObjet_reclamation(re.getString("objet_reclamation"));
            r.setEtat_reclamation(re.getString("etat_reclamation"));

            // Récupérez l'ID de l'utilisateur associé à la réclamation
            int userId = re.getInt("id_user");

            // Utilisez le service ServiceUtilisateurs pour récupérer l'utilisateur
            ServiceUtilisateurs userService = new ServiceUtilisateurs();
            Utilisateurs user = userService.getUserById(userId);

            // Associez l'utilisateur à la réclamation
            r.setUser(user);

            arr.add(r);
        }

        return arr;
    }

    
    public ObservableList<AfficheAdmin> readAll() throws SQLException {
    ObservableList<AfficheAdmin> arr = FXCollections.observableArrayList();
    Statement ste = null; // Assurez-vous d'avoir une déclaration correcte de Statement ici

    ResultSet re = ste.executeQuery("SELECT r.id_rec, r.description, r.date_reclamation, r.objet_reclamation,r.role; u.id_user,   r.etat_reclamation, u.nom, u.email "
        
        
        + "JOIN utilisateur u ON u.id = r.id_user");

    while (re.next()) {
        AfficheAdmin a = new AfficheAdmin(
                re.getInt("id_rec"),
            re.getString("description"),
            re.getString("date_reclamation"),
            re.getString("objet_reclamation"),
            re.getInt("id_user"),
            re.getString("role"),
             re.getString("nom"),
            re.getString("email"),
            
            re.getString("etat_reclamation")
        );
            
        arr.add(a);
}
    return arr;
} 

    public ServiceReclamation() {
    }

public void traitéReclamation(Reclamation r) {
    String req = "UPDATE reclamation SET etat_reclamation = 'traité' WHERE id_rec = ?";
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(req);
        preparedStatement.setInt(1, r.getId_rec());

        int rowsUpdated = preparedStatement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Réclamation traitée avec succès!");
        } else {
            System.out.println("Aucune réclamation trouvée avec l'ID donné.");
        }
    } catch (SQLException ex) {
        Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
    }
}
public Reclamation getReclamationById(int reclamationId) {
    Reclamation reclamation = null;
    String req = "SELECT * FROM `reclamation` WHERE id_rec = ?";
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(req);
        preparedStatement.setInt(1, reclamationId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            reclamation = new Reclamation();
            reclamation.setId_rec(resultSet.getInt("id_rec"));
            reclamation.setDescription(resultSet.getString("description"));
            reclamation.setDate_reclamation(resultSet.getString("date_reclamation"));
            reclamation.setObjet_reclamation(resultSet.getString("objet_reclamation"));
            reclamation.setEtat_reclamation(resultSet.getString("etat_reclamation"));
            
            // Vous devrez également récupérer l'utilisateur associé à la réclamation ici
            int userId = resultSet.getInt("id_user");
           ServiceUtilisateurs userService = new ServiceUtilisateurs();
           Utilisateurs user = userService.getUserById(userId);
            reclamation.setUser(user);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
    }
    return reclamation;
}
}
 
   

   
    


