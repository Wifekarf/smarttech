/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartech;
import java.sql.SQLException;
import models.Reclamation;
import models.Utilisateurs;
import services.ServiceReclamation;
import services.ServiceUtilisateurs;



/**
 *
 * @author msi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Smartech {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
                ServiceUtilisateurs us = new ServiceUtilisateurs(); 

        
       // Utilisateurs u = new Utilisateurs("Said", "Brahmi","said.brahmi@esprit.tn","1234","client");
        //2
      //  Utilisateurs userToUpdate = new Utilisateurs();
        
        /* userToUpdate.setId(2); 
        userToUpdate.setNom("wifek");
        userToUpdate.setPrenom("arfaoui");
        userToUpdate.setmdp("wifek123");
        userToUpdate.setemail("wifek.arfaoui@esprit.tn");
         */
        
       
         Utilisateurs userToDelete = new Utilisateurs();
       // userToDelete.setId(4);
               
        //3
       // us.modifierUser(userToUpdate);
        //us.modifierUser(userup);
        //us.ajouterUser(u);
        //us.deleteUser(userToDelete);
        
        
      // us.ajouterUser(u);
        //System.out.println(us.afficherUser());
       
        Utilisateurs u1 = new Utilisateurs();
        u1.setId(2);
         Utilisateurs u3 = new Utilisateurs();
        u3.setId(6);
       
     // Reclamation r1 = new Reclamation("description", u3, "25/6/2023", "produit", "traité");
       ServiceReclamation serv= new ServiceReclamation();
        //Reclamation reclamationToDelete = new Reclamation();
//       reclamationToDelete.setUser().setId(6);
//Reclamation reclamationToUpdate = new Reclamation();
       // Utilisateurs userToUpdate = new Utilisateurs();
        
          
       /* reclamationToUpdate.setDescription("wifek");
        reclamationToUpdate.setObjet_reclamation("service");
        reclamationToUpdate.setDate_reclamation("25mai2023");
        
         
        
         */
       Reclamation r2=new Reclamation ("description", u1, "25/6/2023", "produit","");
        //serv.modifierReclamation(r2); 
       // serv.deleteReclamation(reclamationToDelete);
       //serv.ajouterReclamation(r1);
       
       //serv.ajouterReclamation(r1);
       //ReclamatodifierReclamation(reclamationToUpdate);
     // Reclamation.deleteReclamation(reclamationToDelete);
      
      // System.out.println(serv.afficherReclamations());*/
       // Modifier une réclamation (assurez-vous d'implémenter cette méthode dans ServiceReclamation)
        Reclamation reclamationToUpdate = new Reclamation();
        reclamationToUpdate.setId_rec(10); // ID de la réclamation à mettre à jour
        reclamationToUpdate.setDescription("Nouvelle description");
         reclamationToUpdate.setDate_reclamation("Nouvelle date");
          reclamationToUpdate.setObjet_reclamation("service");
        serv.modifierReclamation(reclamationToUpdate);

        // Afficher les réclamations
        System.out.println(serv.readAllAd());
       
    }
}
    

    
      
       
         
    

    
