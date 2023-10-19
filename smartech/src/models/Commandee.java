/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDate;

public class Commandee {
    private int id;
    private Utilisateurs utilisateur;
    private String service;
    private LocalDate date = LocalDate.now();

    public Commandee(int id, Utilisateurs utilisateur, String service, LocalDate date) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.service = service;
        this.date = date;
    }

    public Commandee() {
    }

     public Commandee( Utilisateurs utilisateur, String service, LocalDate date) {
        this.utilisateur = utilisateur;
        this.service = service;
        this.date = date;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Utilisateurs getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateurs utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Commandee{" +
                "id=" + id +
                ", utilisateur=" + utilisateur +
                ", service='" + service + '\'' +
                ", date=" + date +
                '}';
    }

   

   
}