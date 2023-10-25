/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author DELL
 */
public class Type_produit {
    private int idT;
    private String nom_type;
    private String description;

    public Type_produit() {
    }

    public Type_produit(String nom_type, String description) {
        this.nom_type = nom_type;
        this.description = description;
    }

    public Type_produit(int idT, String nom_type, String description) {
        this.idT = idT;
        this.nom_type = nom_type;
        this.description = description;
    }

    public int getIdT() {
        return idT;
    }

    public void setIdT(int idT) {
        this.idT = idT;
    }

    public String getNom_type() {
        return nom_type;
    }

    public void setNom_type(String nom_type) {
        this.nom_type = nom_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "type_produit{" + "nom_type=" + nom_type + ", description=" + description + '}';
    }
    
    
}
