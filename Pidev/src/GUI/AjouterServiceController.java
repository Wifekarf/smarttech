/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Entities.Service;
import Service.ServiceService;
import java.sql.Date;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
  import javafx.event.ActionEvent;


public class AjouterServiceController {

    @FXML
    private TextField txtfieldLocation;

    @FXML
    private TextField txtfieldPrix;

    @FXML
    private DatePicker txtfieldDateAvaliable;

    @FXML
    private TextField txtfieldNomService;

    @FXML
    private TextField txtfieldCategorie;

    @FXML
    private Button btnAddService;

    @FXML
    private DatePicker txtfieldDateCreation;
    
    private ServiceService serviceService = new ServiceService();

    @FXML
    void AddService(ActionEvent event) throws SQLException {
        String nomService=txtfieldNomService.getText();
        Date dateCreation = Date.valueOf(txtfieldDateCreation.getValue());
        String location=txtfieldLocation.getText();
        int prix = Integer.parseInt(txtfieldPrix.getText());      
        Date timeAvailable = Date.valueOf(txtfieldDateAvaliable.getValue());
      //  int fk_idCategorie = Integer.parseInt(txtfieldCategorie.getText());
        String nomCategorie = txtfieldCategorie.getText();
   /*     System.out.println(nomService);
        System.out.println(fk_idCategorie);
        System.out.println(location);
        System.out.println(prix);
        System.out.println(dateCreation);
        System.out.println(timeAvailable);
        
     */ 
   serviceService.ajouterService(nomService,dateCreation,location,prix,timeAvailable,nomCategorie);
   System.out.println("DONE");
    }

}

    
    

   

    
    

    
  


/*

  
}
*//*
    @FXML
    private void AddService(ActionEvent event) throws SQLException {
         String nomService=txtfieldNomService.getText();
        Date dateCreation = Date.valueOf(txtfieldDateCreation.getValue());
        String location=txtfieldLocation.getText();
        int prix = Integer.parseInt(txtfieldPrix.getText());      
        Date timeAvailable = Date.valueOf(txtfieldDateAvaliable.getValue());
        int fk_idCategorie = Integer.parseInt(txtfieldCategorie.getText());
        Se.ajouterService(new Service(nomService,dateCreation,location,prix,timeAvailable));
    }
}
    /*
    public void AddService (Service s) {
        String req="INSERT INTO `service`(`nomService`, `dateCreation`, `location`, `prix`, `timeAvailable`, `fk_idCategorie`) VALUES ('[value-1]','[value-2]','[value-3]','[value-4]','[value-5]','[value-6])";
        try {
            PreparedStatement ps = connextion.prepareStatement(req);
            ps.setString(1, s.getNomService());
            ps.setDate(2, s.getDateCreation());
            ps.setString(3, s.getLocation());
            ps.setInt(4, s.getPrix());
            ps.setDate(5, s.getTimeAvailable());
            ps.setInt(6, s.getFk_idCategorie());
          
        } catch (SQLException ex) {
            Logger.getLogger(AjouterCategorieController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    */
      /*
    void AddService(ActionEvent event) {
        
        
        String nomService,location;
        Date dateCreation,timeAvailable;
        int prix,fk_idCategorie ;
        location = txtfieldLocation.getText();
        int prix = txtfieldPrix.getText();
        dateCreation = txtfieldDateAvaliable.getdate();
        nomService = txtfieldNomService.getText();
        fk_idCategorie = txtfieldCategorie.getText();
        dateCreation = txtfieldDateCreation..now();
            */
    
       
        