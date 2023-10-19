/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author msi
 */





public class AfficheAdmin {
    private int id_rec;
    private String description;
    private String date_reclamation;
    private String objet_reclamation;
    private int id_user;
    private String role;
    private String nom ;
    private String email;
    private String etat_reclamation;

    public AfficheAdmin(int id_rec, String description, String date_reclamation, String objet_reclamation, int id_user, String role, String nom, String email, String etat_reclamation) {
        this.id_rec = id_rec;
        this.description = description;
        this.date_reclamation = date_reclamation;
        this.objet_reclamation = objet_reclamation;
        this.id_user = id_user;
        this.role = role;
        this.nom = nom;
        this.email = email;
        this.etat_reclamation = etat_reclamation;
    }

    public AfficheAdmin(int id_rec, String description, String date_reclamation, String objet_reclamation, int id_user, String role, String nom, String email) {
        this.id_rec = id_rec;
        this.description = description;
        this.date_reclamation = date_reclamation;
        this.objet_reclamation = objet_reclamation;
        this.id_user = id_user;
        this.role = role;
        this.nom = nom;
        this.email = email;
    }

    
    
    

}
