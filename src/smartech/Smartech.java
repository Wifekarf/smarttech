/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartech;
import java.time.LocalDate;
import java.util.List;
import models.Commandee;
import models.Facture;
import models.Utilisateurs;
import services.CommandeeService;
import services.FactureService;
import services.ServiceUtilisateurs;

/**
 *
 * @author MSI
 */
public class Smartech {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Ajout de l'utilisateur à la base de données
        ServiceUtilisateurs serviceUtilisateurs = new ServiceUtilisateurs();
        Utilisateurs utilisateur1 = new Utilisateurs(89,"John", "Doe", "john@example.com", "12345", "client");
         serviceUtilisateurs.ajouterUser(utilisateur1);  


//        // Création d'une commande liée à l'utilisateur 
        CommandeeService commandeeService = new CommandeeService();
        LocalDate dateCommande = LocalDate.now();
        Commandee commande1 = new Commandee(135, utilisateur1, "Plombier", dateCommande);
        commandeeService.ajouterCommandee(commande1);
        
//        // Création d'une facture liée à la commande
        FactureService factureService = new FactureService();
        Facture facture = new Facture(116,commande1,100.0, LocalDate.now()); 
        factureService.ajouterFacture(facture); 
//        
        
//
//        // Ajout de la commande à la base de données
         
//
//        // Ajout de la facture à la base de données
        
         
         //facture.setMontant(45); 
         
           
         //factureService.modifierFacture(facture) ;
         //factureService.supprimerFacture(facture) ;  
         
         serviceUtilisateurs.deleteUser(utilisateur1) ; 
//
        // Affichage de la liste des utilisateurs
        List<Utilisateurs> utilisateurs = serviceUtilisateurs.afficherUser();
        System.out.println("\nListe des utilisateurs :");
        utilisateurs.forEach((utilisateur) -> {
         System.out.println(utilisateur);
        });

        // Affichage de la liste des commandes
        List<Commandee> commandes = commandeeService.afficherCommandees(utilisateur1);
        System.out.println("\nListe des commandes :");
        commandes.forEach((commande) -> {
        System.out.println(commande);
        });

        // Affichage de la liste des factures
        List<Facture> factures = factureService.afficherFactures();
        System.out.println("\nListe des factures :");
        factures.forEach((fact) -> {
        System.out.println(fact);
        });

         
       
    }
    
}
