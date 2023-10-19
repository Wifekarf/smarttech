/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author msi
 */

    


public class Reclamation {
    private int id_rec;
    private String description;
    private Utilisateurs user;
     private String date_reclamation;
    private String objet_reclamation;
   private String etat_reclamation;

    public Reclamation(int id_rec, String description, Utilisateurs user, String date_reclamation, String objet_reclamation, String etat_reclamation) {
        this.id_rec = id_rec;
        this.description = description;
        this.user = user;
        this.date_reclamation = date_reclamation;
        this.objet_reclamation = objet_reclamation;
        this.etat_reclamation = etat_reclamation;
    }

    

    public Reclamation(String description, Utilisateurs user, String date_reclamation, String objet_reclamation, String etat_reclamation) {
        this.description = description;
        this.user = user;
        this.date_reclamation = date_reclamation;
        this.objet_reclamation = objet_reclamation;
        this.etat_reclamation = etat_reclamation;
    }

    public Reclamation() {
    } 

   
    
   
   

    public int getId_rec() {
        return id_rec;
    }

    public void setId_rec(int id_rec) {
        this.id_rec = id_rec;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Utilisateurs getUser() {
        return user;
    }

    public void setUser(Utilisateurs user) {
        this.user = user;
    }

    public String getDate_reclamation() {
        return date_reclamation;
    }

    public void setDate_reclamation(String date_reclamation) {
        this.date_reclamation = date_reclamation;
    }

    public String getObjet_reclamation() {
        return objet_reclamation;
    }

    public void setObjet_reclamation(String objet_reclamation) {
        this.objet_reclamation = objet_reclamation;
    }



    public String getEtat_reclamation() {
        return etat_reclamation;
    }

    public void setEtat_reclamation(String etat_reclamation) {
        this.etat_reclamation = etat_reclamation;
    }

    
}