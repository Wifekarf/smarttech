/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.Service;
import util.Mybd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import models.Categorie;

public class ServiceService {
    Connection connection;
    CategorieService categorieService;

    public ServiceService() {
        this.connection = Mybd.getInstance().getConnection();
        this.categorieService = new CategorieService();
    }

    public void ajouterService(String nomService, Date dateCreation, String location, int prix, Date timeAvailable, String nomCategorie) throws SQLException {
        List<Categorie> allCategories = categorieService.getAllCategories();
        List<Categorie> collect = allCategories.stream().filter(categorie -> categorie.getNomCategorie().equals(nomCategorie))
                .collect(Collectors.toList());

        String req = "INSERT INTO service (nomService, dateCreation, location, prix, timeAvailable, fk_idCategorie) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(req);

        ps.setString(1, nomService);
        ps.setDate(2, new java.sql.Date(dateCreation.getTime()));
        ps.setString(3, location);
        ps.setInt(4, prix);
        ps.setDate(5, new java.sql.Date(timeAvailable.getTime()));
        ps.setInt(6, collect.get(0).getIdCategorie());

        ps.executeUpdate();
    }

    public void modifierService(Service service, String ancienNomService) throws SQLException {
        List<Categorie> allCategories = categorieService.getAllCategories();
        List<Categorie> collect = allCategories.stream().filter(categorie -> categorie.getIdCategorie() == service.getFk_idCategorie())
                .collect(Collectors.toList());

        String req = "UPDATE service SET nomService = ?, dateCreation = ?, location = ?, prix = ?, timeAvailable = ?, fk_idCategorie = ? WHERE nomService = ?";
        PreparedStatement ps = connection.prepareStatement(req);

        ps.setString(1, service.getNomService());
        ps.setDate(2, new java.sql.Date(service.getDateCreation().getTime()));
        ps.setString(3, service.getLocation());
        ps.setInt(4, service.getPrix());
        ps.setDate(5, new java.sql.Date(service.getTimeAvailable().getTime()));
        ps.setInt(6, collect.get(0).getIdCategorie());
        ps.setString(7, ancienNomService);

        ps.executeUpdate();
    }

    public void supprimerService(String nomService) throws SQLException {
        String req = "DELETE FROM service WHERE nomService = ?";
        PreparedStatement ps = connection.prepareStatement(req);
        ps.setString(1, nomService);
        ps.executeUpdate();
    }

    public List<Service> getAllServices() throws SQLException {
        List<Service> Services = new ArrayList<>();
        String req = "SELECT * FROM service";
        Statement stm = connection.createStatement();
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
}
