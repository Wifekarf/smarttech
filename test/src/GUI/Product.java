/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

public class Product {

    static void createPanier(Product selectedProductsToAdd) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    private String nom;
    private String description;
    private double prix;

    public Product(String nom, String description, double prix) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
    }

    public String getName() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return prix;
    }

    @Override
    public String toString() {
        return "Nom: " + nom + "\nDescription: " + description + "\nPrix: " + prix;
    }
  
}
