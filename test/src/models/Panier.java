/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models; 

import java.util.List;

public class Panier {
    private List<Produits> cartItems; 
    private double prixTotale;
    private Utilisateurs utilisateur; 
    private int panierId;
    private int quantity;

    public Panier(List<Produits> cartItems, Utilisateurs utilisateur, int panierId) {
        this.cartItems = cartItems;
        this.utilisateur = utilisateur;
        this.panierId = panierId;
        this.prixTotale = calculateTotalPrice();
    }

    public Panier(List<Produits> cartItems, Utilisateurs utilisateur) {
        this.cartItems = cartItems;
        this.utilisateur = utilisateur;
        this.prixTotale = calculateTotalPrice();
    }

    // Default constructor with empty implementation
    public Panier() {
        // This constructor is required for JavaFX FXML loading.
    }

    // Getters and setters for the remaining attributes

    public List<Produits> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<Produits> cartItems) {
        this.cartItems = cartItems;
    }

    public double getPrixTotale() {
        return prixTotale;
    }

    public void setPrixTotale(double prixTotale) {
        this.prixTotale = prixTotale;
    }

    public Utilisateurs getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateurs utilisateur) {
        this.utilisateur = utilisateur;
    }

    public int getPanierId() {
        return panierId;
    }

    public void setPanierId(int panierId) {
        this.panierId = panierId;
    }

    public int getQuantity() {
        return quantity;
    }

    // Calculate the total price of items in the cart
    public double calculateTotalPrice() {
        return cartItems.stream()
            .mapToDouble(item -> item.getPrix())
            .sum();
    }

    public Object getUtilisateurs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}}
