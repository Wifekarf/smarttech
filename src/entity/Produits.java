/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
//import smartech.Servicetype

import java.net.URL;

/**
 *
 * @author DELL
 */
public class Produits {
    private int idP;
    private String prix;
    private String description;
    private String nom_produit;
    private String image;
    private Type_produit tp;
    private int nbP;

    public Produits() {
    }

    public Produits(int nbP, String prix, String description, String nom_produit, String image, Type_produit tp) {
        this.nbP = nbP;
        this.prix = prix;
        this.description = description;
        this.nom_produit = nom_produit;
        this.image = image;
        this.tp = tp;
    }
    
    public Produits(int idP, int nbP, String prix, String description, String nom_produit, String image, Type_produit tp) {
        this.idP = idP;
        this.nbP = nbP;
        this.prix = prix;
        this.description = description;
        this.nom_produit = nom_produit;
        this.image = image;
        this.tp = tp;
    }

    public Produits(int length, String text, String text0, String text1, String text2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Type_produit getTp() {
        return tp;
    }

    public void setTp(Type_produit tp) {
        this.tp = tp;
    }

    public int getNbP() {
        return nbP;
    }

    public void setNbP(int nbP) {
        this.nbP = nbP;
    }

    @Override
    public String toString() {
        return "Produits{" + "prix=" + prix + ", description=" + description + ", nom_produit=" + nom_produit + ", image=" + image + ", tp=" + tp + ", nbP=" + nbP + '}';
    }
   
}