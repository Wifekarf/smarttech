/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class Service {
    
    private int idService;
    private String nomService;
    private Date dateCreation;
    private String location;
    private int prix;
    private Date timeAvailable;
    private int fk_idCategorie;

    public Service() {
    }
    

    public Service(String nomService, Date dateCreation, String location, int prix, Date timeAvailable, int fk_idCategorie) {
        this.nomService = nomService;
        this.dateCreation = dateCreation;
        this.location = location;
        this.prix = prix;
        this.timeAvailable = timeAvailable;
        this.fk_idCategorie = fk_idCategorie;
    }

    public Service(int idService, String nomService, Date dateCreation, String location, int prix, Date timeAvailable, int fk_idCategorie) {
        this.idService = idService;
        this.nomService = nomService;
        this.dateCreation = dateCreation;
        this.location = location;
        this.prix = prix;
        this.timeAvailable = timeAvailable;
        this.fk_idCategorie = fk_idCategorie;
    }

    public Service(String NomService, java.util.Date DateCreation, String Location, int Prix, java.util.Date TimeAvailable, int Fk_idCategorie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Service(String nomService, Date dateCreation, String location, int prix, Date timeAvailable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getNomService() {
        return nomService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    public Date getDateCreation() {
        return dateCreation;
    }
    

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Date getTimeAvailable() {
        return timeAvailable;
    }

    public void setTimeAvailable(Date timeAvailable) {
        this.timeAvailable = timeAvailable;
    }

    public int getFk_idCategorie() {
        return fk_idCategorie;
    }

    public void setFk_idCategorie(int fk_idCategorie) {
        this.fk_idCategorie = fk_idCategorie;
    }

    @Override
    public String toString() {
        return "Service{" + "idService=" + idService + ", nomService=" + nomService + ", dateCreation=" + dateCreation + ", location=" + location + ", prix=" + prix + ", timeAvailable=" + timeAvailable + ", fk_idCategorie=" + fk_idCategorie + '}';
    }

}
