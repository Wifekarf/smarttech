package models;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Panier {
    private List<Produits> cartItems;
    private double prixTotale;
    private Utilisateurs utilisateur;
    private int panierId;

    public Panier() {
        cartItems = new ArrayList<>();
        prixTotale = 0.0;
    }

    public Panier(List<Produits> cartItems, Utilisateurs utilisateur, int panierId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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

    public void addProductToCart(Produits product) {
        cartItems.add(product);
        prixTotale += product.getPrix();
    }

    // Implement this method to return an ObservableList of products in the cart
    public ObservableList<Produits> getProducts() {
        ObservableList<Produits> productsList = FXCollections.observableArrayList(cartItems);
        return productsList;
    }

    public void removeProductFromCart(Produits selectedProduct) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void clearCart() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
