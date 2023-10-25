package models;

import java.util.List;

/**
 *
 * @author ASUS
 */
public class Categorie {

    
        
    private int idCategorie;
    private String nomCategorie;
    private String descriptionCategorie;

    public Categorie() {
    }

    public Categorie(String nomCategorie, String descriptionCategorie) {
        this.nomCategorie = nomCategorie;
        this.descriptionCategorie = descriptionCategorie;
    }

    public Categorie(int idCategorie, String nomCategorie, String descriptionCategorie) {
        this.idCategorie = idCategorie;
        this.nomCategorie = nomCategorie;
        this.descriptionCategorie = descriptionCategorie;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public String getDescriptionCategorie() {
        return descriptionCategorie;
    }

    public void setDescriptionCategorie(String descriptionCategorie) {
        this.descriptionCategorie = descriptionCategorie;
    }

    @Override
    public String toString() {
        return "Categorie{" + "idCategorie=" + idCategorie + ", nomCategorie=" + nomCategorie + ", descriptionCategorie=" + descriptionCategorie + '}';
    }

    
}