/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Facture;
import util.Mybd;

public class FactureService {
    
    private final Connection connection = Mybd.getInstance().getConnection();

    public void ajouterFacture(Facture facture) {
        String req = "INSERT INTO Facture ( idCommande, Montant, Date) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(req);
            preparedStatement.setDouble(1, facture.getCommandee().getId());
            preparedStatement.setDouble(2, facture.getMontant());
            preparedStatement.setDate(3, java.sql.Date.valueOf(facture.getDate()));
            preparedStatement.executeUpdate();
            System.out.println("Facture ajoutée avec succès!");
        } catch (SQLException ex) {
            Logger.getLogger(FactureService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    


    public void modifierFacture(Facture facture , int idFacture) {
        String req = "UPDATE Facture SET Montant=?, Date=? WHERE idFacture=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(req);
            preparedStatement.setDouble(1, facture.getMontant());
            preparedStatement.setDate(2, java.sql.Date.valueOf(facture.getDate()));
            preparedStatement.setInt(3, idFacture);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Facture mise à jour avec succès!");
            } else {
                System.out.println("Aucune Facture trouvée avec l'ID donné.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FactureService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void supprimerFacture(int idfacture) {
        String req = "DELETE FROM Facture WHERE idFacture=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, idfacture) ; 
            preparedStatement.executeUpdate();
            System.out.println("Facture supprimée avec succès!");
        } catch (SQLException ex) {
            Logger.getLogger(FactureService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    public List<Facture> afficherFactures() {
        List<Facture> factures = new ArrayList<>();
        String req = "SELECT * FROM Facture ";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(req);
            while (resultSet.next()) {
                Facture facture = new Facture();
                facture.setIdFacture(resultSet.getInt("idFacture"));
                facture.setCommandee(new CommandeeService().getCommandeeById(resultSet.getInt("idCommande")));
                facture.setMontant(resultSet.getDouble("Montant"));
                facture.setDate(resultSet.getDate("Date").toLocalDate());
                factures.add(facture);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FactureService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return factures;
    }
    
    public Facture getFactureById(int factureId) {
    Facture facture = null;
    String req = "SELECT * FROM Facture WHERE idFacture = ?";
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(req);
        preparedStatement.setInt(1, factureId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            facture = new Facture();
            facture.setIdFacture(resultSet.getInt("idFacture"));
            facture.setCommandee(new CommandeeService().getCommandeeById(resultSet.getInt("idCommande")));
            facture.setMontant(resultSet.getDouble("Montant"));
            facture.setDate(resultSet.getDate("Date").toLocalDate());
        }
    } catch (SQLException ex) {
        Logger.getLogger(FactureService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return facture;
}
public void supprimerLignesDepassees() {
    LocalDate now = LocalDate.now();
    
    String query = "DELETE FROM Facture WHERE DATEDIFF(?, Date) > 1";
    
    try {
        PreparedStatement deleteStatement = connection.prepareStatement(query);
        deleteStatement.setDate(1, java.sql.Date.valueOf(now));
        int rowsDeleted = deleteStatement.executeUpdate();
        System.out.println(rowsDeleted + " lignes de Facture supprimées.");
    } catch (SQLException ex) {
        Logger.getLogger(FactureService.class.getName()).log(Level.SEVERE, null, ex);
    }
}

}

