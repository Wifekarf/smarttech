/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author DELL
 */
import java.util.HashMap;
import java.util.Map;
import models.Produits;

public class StatistiquePromotion {

    public static String trouverProduitMoinsVendu(Map<String, Integer> ventes) {
        String produitMoinsVendu = null;
        int minVentes = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> entry : ventes.entrySet()) {
            String produit = entry.getKey();
            int ventesProduit = entry.getValue();

            if (ventesProduit < minVentes) {
                minVentes = ventesProduit;
                produitMoinsVendu = produit;
            }
        }

        return produitMoinsVendu;
    }
}
