/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartech;

import services.Servicetype;
import services.Serviceproduit;
import models.Produits;
import models.Type_produit;

import tool.DataSource;

public class Smartech {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataSource.getInstance().getConnection();
        // ajouter produit
        Serviceproduit sp = new Serviceproduit();
        Servicetype st = new Servicetype();
       
        Type_produit t1 = new Type_produit(1,"math","calcul et analyse");
        Produits p = new Produits(1,25,"10.215f","description","IOS","image",t1);
        sp.ajouterProduit(p);
        
//modifier produit        
        Produits produitToUpdate = new Produits();
        produitToUpdate.setPrix("50");
        produitToUpdate.setDescription("description12234");
        produitToUpdate.setNom_produit("tomate");
        sp.modifierProduit(produitToUpdate);
        
        int produitToDelete = 5;
        
        
        sp.supprimerProduit(produitToDelete);
        //sp.ajouterProduit(p);
        //affiche produit
        System.out.println(sp.afficheProduit());
        
        
        Type_produit t = new Type_produit("info","pc et equipement");
        st.ajouterType(t);
        // modifier type
        Type_produit typeToUpdate = new Type_produit();
        typeToUpdate.setIdT(1);
        typeToUpdate.setDescription("description");
        typeToUpdate.setNom_type("nom_type");
        st.modifierType(typeToUpdate);
        //supprimer type
        Type_produit typeToDelete = new Type_produit();
        typeToDelete.setNom_type("nom_type");
        
        
        st.supprimerType(typeToDelete);
        //afficher type
        System.out.println(st.afficheType());
      
    }
}