/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

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
import DB.MyDB;
// ServiceUtilisateurs.java
import java.util.ArrayList;
import java.util.List;

public class ServiceUtilisateurs {
    private List<Utilisateurs> utilisateursList;

    public ServiceUtilisateurs() {
        utilisateursList = new ArrayList<>();
    }

    public void ajouterUser(Utilisateurs utilisateur) {
        utilisateursList.add(utilisateur);
    }

    public void afficherUser() {
        for (Utilisateurs utilisateur : utilisateursList) {
            System.out.println(utilisateur.getNom() + " " + utilisateur.getPrenom());
        }
    }

    public void modifierUser(int id, String nom, String prenom, String email, String mdp, String role) {
        for (Utilisateurs utilisateur : utilisateursList) {
            if (utilisateur.getId() == id) {
                utilisateur.setNom(nom);
                utilisateur.setPrenom(prenom);
                utilisateur.setEmail(email);
                utilisateur.setMdp(mdp);
                utilisateur.setRole(role);
                break;
            }
        }
    }

    public void deleteUser(int id) {
        Utilisateurs utilisateurToRemove = null;
        for (Utilisateurs utilisateur : utilisateursList) {
            if (utilisateur.getId() == id) {
                utilisateurToRemove = utilisateur;
                break;
            }
        }
        if (utilisateurToRemove != null) {
            utilisateursList.remove(utilisateurToRemove);
        }
    }

    public Utilisateurs getUserById(int id) {
        for (Utilisateurs utilisateur : utilisateursList) {
            if (utilisateur.getId() == id) {
                return utilisateur;
            }
        }
        return null; // User not found
    }
}