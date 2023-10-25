/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDate;

public class Facture {
    private int idFacture;
    private Commandee Commandee;
    private double Montant;
    private LocalDate Date = LocalDate.now();

    public Facture(int idFacture, Commandee Commandee, double Montant, LocalDate Date) {
        this.Commandee = Commandee;
        this.idFacture = idFacture;
        this.Montant = Montant;
        this.Date = Date;
    }

    public Facture(Commandee Commandee,double Montant, LocalDate Date) {
        this.Commandee = Commandee;
        this.Montant = Montant;
        this.Date = Date;
    }

    public Facture() {
        this.idFacture = idFacture;
    } 
    
    public Facture(int idFacture) {
    } 

    public Facture(int idFacture, double Montant, LocalDate Date) {
       this.idFacture = idFacture;
       this.Montant = Montant;
       this.Date = Date;
    }

    


    public models.Commandee getCommandee() {
        return Commandee;
    }

    public void setCommandee(Commandee Commandee) {
        this.Commandee = Commandee;
    }

    public int getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }

    public double getMontant() {
        return Montant;
    }

    public void setMontant(double Montant) {
        this.Montant = Montant;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate Date) {
        this.Date = Date;
    }

    @Override
    public String toString() {
        return "Facture{" +
                "idFacture=" + idFacture +
                ", idCommande=" + Commandee +
                ", Montant=" + Montant +
                ", Date=" + Date +
                '}';
    }
}

