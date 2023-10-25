///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package pidev;
//
//import Entities.Categorie;
//import Entities.Service;
//import Service.CategorieService;
//import Service.ServiceService;
//import java.sql.SQLException;
//import java.util.List;
//import java.sql.Date;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
//// *
// * @author ASUS
// */
//
//
//
//
//
//
//
//
//
//
//public class Pidev {
//
//    /**
//     * @param args the command line arguments
//     */ 
//    public static void main(String[] args) throws SQLException {
//        
//        //ModifierCategorie//
//        try {
//            CategorieService categorieService = new CategorieService();
//            String ancienNomCategorie = "barcelona";
//            Categorie categorie = new Categorie("Real Madrid", "champions league");
//            categorieService.modifierCategorie(categorie, ancienNomCategorie);
//            System.out.println("Categorie Modified successfully.");
//            
//        } catch (SQLException sQLException) {
//            System.out.println("Error.");
//        }
//        
//
//        
//        
//     
//     
//        
//       // ***********************************/
//    // ajouter une categorie //
//    
//    
//    /*
//    CategorieService categorieService = new CategorieService(); 
//    Categorie newCategorie = new Categorie( "Ménage", "nétoyage du maison");
//
//    try {
//        categorieService.ajouterCategorie(newCategorie); // 
//        System.out.println("Categorie added successfully.");
//
//    } catch (SQLException ex) {
//        System.out.println("Error adding Categorie.");
//
//        Logger.getLogger(Pidev.class.getName()).log(Level.SEVERE, null, ex);
//    }*/
//     // **************************************************************************************************************************************************/
//    // Supprimer une categorie //
//    
////    String nomCategorieSupp =   "Mécanisien";
////     CategorieService categorieService = new CategorieService();
////      try {
////        categorieService.supprimerCategorie(nomCategorieSupp);
////        System.out.println("Categorie deleted successfully.");
////    } catch (SQLException ex) {
////        System.out.println("Error deleting Categorie.");
////        Logger.getLogger(Pidev.class.getName()).log(Level.SEVERE, null, ex);
////    }
////}
//   // ***********************************************************************************************************************************************************************************
//     
//    String nomServiceSupp =   "jode";
//     ServiceService serviceService = new ServiceService();
//      try {
//        serviceService.supprimerService(nomServiceSupp);
//        System.out.println("Service deleted successfully.");
//    } catch (SQLException ex) {
//        System.out.println("Error deleting Service.");
//        Logger.getLogger(Pidev.class.getName()).log(Level.SEVERE, null, ex);
//    }
//      
//      
//      
//      
//    }}
//
//
//    
//    
//    
//    
//
//    /*
//        try {
//    // Afficher tous les Categorie
//    List<Categorie> AllCategories = CategorieService.getAllCategories();
//    System.out.println("Voici tous les Categories");
//    AllCategories.forEach((Categorie categorie) -> {
//        System.out.println(categorie);
//    });
//} catch (SQLException ex) {
//    Logger.getLogger(Pidev.class.getName()).log(Level.SEVERE, null, ex);
//    System.out.println("Error Affichier Les Categories"); */
//
//    /* ServiceService serviceService = new ServiceService(); // Notez le changement de nom ici, vous aviez une faute de frappe
//
//    Service newService = new Service( "Clignton", new Date(2012,07,07), "Pais", 200, new Date(2013, 5, 17), 1);
//
//    try {
//        serviceService.ajouterService(newService); // Utilisez la variable que vous avez créée
//        System.out.println("Service added successfully.");
//
//    } catch (SQLException ex) {
//        ex.printStackTrace(); */
//    
//    /*
//    try {
//    // Afficher tous les Services
//    List<Service> AllServices = ServiceService.getAllServices();
//    System.out.println("Voici tous les Services");
//    AllServices.forEach((Service service) -> {
//        System.out.println(service);
//    });
//} catch (SQLException ex) {
//    Logger.getLogger(Pidev.class.getName()).log(Level.SEVERE, null, ex);
//    System.out.println("Error Affichier Les Categories");
//}
//   
//    /*
//    
//    ServiceService serviceService = new ServiceService(); // Instanciez un objet ServiceService
//
//    List<Service> rechercherParNomService = serviceService.rechercherParNomService("Clignton");
//}
//*/ /*ServiceService serviceService = new ServiceService();
//        List<Service> servicesTrouves = serviceService.rechercherParNomService("Clignton");
//
//        // Afficher les services trouvés
//        System.out.println("Services trouvés :");
//        for (Service service : servicesTrouves) {
//            System.out.println(service);
//    
//*/ 
//
//       /* } }*/
//
//    
//
