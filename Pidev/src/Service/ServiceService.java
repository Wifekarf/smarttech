/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Categorie;
import Entities.Service;
import MyDB.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author ASUS
 */
public class ServiceService {
    Connection connextion;
    CategorieService categorieService;
    
    public ServiceService() {
        this.connextion = MyConnection.getInstance().getConnection();
        this.categorieService = new CategorieService();
    }
     public void ajouterService(String nomService,Date dateCreation,String location,int prix,Date timeAvailable,String nomCategorie) throws SQLException {
        List<Categorie> allCategories = categorieService.getAllCategories();
        List<Categorie> collect = allCategories.stream().filter(categorie -> categorie.getNomCategorie().equals( nomCategorie))
                .collect(Collectors.toList());
      
        String req = "INSERT INTO `service`(`nomService`, `dateCreation`, `location`, `prix`, `timeAvailable`, `fk_idCategorie`) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connextion.prepareStatement(req);
        
        ps.setString(1, nomService);
        ps.setDate(2, new java.sql.Date(dateCreation.getTime()));
        ps.setString(3, location);
        ps.setInt(4, prix);
        ps.setDate(5, new java.sql.Date(timeAvailable.getTime()));
        ps.setInt(6, collect.get(0).getIdCategorie());

        ps.executeUpdate();
    }
     public static List<Service> getAllServices() throws SQLException {
    List<Service> Services = new ArrayList<>();
    String req = "SELECT * FROM Service"; // 
    Connection connextion = MyConnection.getInstance().getConnection();
    Statement stm = connextion.createStatement();
    ResultSet rst = stm.executeQuery(req);

    while (rst.next()) {
        Service service = new Service(                
                rst.getString("nomService"),
                rst.getDate("dateCreation"),
                rst.getString("location"),
                rst.getInt("prix"),
                rst.getDate("timeAvailable"),
                rst.getInt("fk_idCategorie")
                
        );
        Services.add(service);
    }
    return Services;
}
     public List<Service> rechercherParNomService(String nomService) {
    List<Service> result = new ArrayList<>();
    String req = "SELECT * FROM service WHERE nomService = ?";

    try (PreparedStatement ps = connextion.prepareStatement(req)) {
        ps.setString(1, nomService);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            String NomService = rs.getString("nomService");
            Date DateCreation = rs.getDate("dateCreation");
            String Location = rs.getString("location");
            int Prix = rs.getInt("prix");
            Date TimeAvailable = rs.getDate("timeAvailable");
            int Fk_idCategorie = rs.getInt("fk_idCategorie");
            
            // Utilisation du constructeur pour créer une instance de Service
            Service service = new Service(NomService, DateCreation, Location, Prix, TimeAvailable, Fk_idCategorie);

            result.add(service);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return result;
}

     //Recherche Par NomService
     /*
     public  List<Service> rechercherParNomService(String nomService) {
        List<Service> result = new ArrayList<>();
        String req = "SELECT * FROM service WHERE nomService = ?";

        try (PreparedStatement ps = connextion.prepareStatement(req)) {
            ps.setString(1, nomService);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                String NomService = rs.getString("nomService");
                Date DateCreation = rs.getDate("dateCreation");
                String Location = rs.getString("location");
                int Prix = rs.getInt("prix");
                Date TimeAvailable  = rs.getDate("timeAvailable");
                int Fk_idCategorie = rs.getInt("fk_idCategorie");
                Service service = new Service(NomService, DateCreation, Location, Prix, TimeAvailable, Fk_idCategorie);
      
                result.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }*/
     
     
    
    
}
