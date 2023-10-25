/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Produits;
import models.Type_produit;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import services.Serviceproduit;
import services.Servicetype;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
/**
 * FXML Controller class
 *
 * @author DELL
 */


public class FXMLajoutpController {
    @FXML
    private Button btn1ajout;

    @FXML
    private TextField tfnom_produit;

    @FXML
    private TextField tfprix;

    @FXML
    private TextField tfdescription;

    @FXML
    private TextField tfnbP;

    
    @FXML
    private ImageView tfimage;
    @FXML
    private Button btn1annuler1;

    // Autres champs et méthodes de votre contrôleur...

    

// ...
    @FXML
    private TextField tfType;
    
    


public void initialize(URL url, ResourceBundle rb) {
        btn1ajout.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("6666666666666666666666666666666");
            Serviceproduit sp = new Serviceproduit();
            try {
                sp.ajouterProduit(new Produits(tfnbP.getLength(),tfprix.getLength(), tfnom_produit.getText(),tfdescription.getText(),tfimage.getAccessibleText(), new Type_produit( Integer.parseInt(tfType.getText()),"", "")));
                
            } catch (Exception ex) {
                Logger.getLogger(FXMLajoutpController.class.getName()).log(Level.SEVERE, null, ex);
            }
            FXMLLoader loader =new FXMLLoader(getClass().getResource("./FXMLaffichep.fxml"));
           Parent root;
            try {
                root=loader.load();
                btn1ajout.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(FXMLajoutpController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        });
    }
}









//public class FXMLajoutpController implements Initializable {
//
//    @FXML
//    private TextField tfnom_produit;
//    @FXML
//    private TextField tfprix;
//    @FXML
//    private TextField tfdescription;
//    @FXML
//    private ImageView tfimage;
//    @FXML
//    private Button btn1ajout;
//    @FXML
//    private TextField tfnbP;
//    private TextField tftype;
//    @FXML
//    private ComboBox<?> combotftype;
//    @FXML
//    private Button btn1annuler1;
//    
//    
//
//    /**
//     * Initializes the controller class.
//     * @param url
//     * @param rb
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        Serviceproduit sp = new Serviceproduit();
//        Servicetype st = new Servicetype();
//        ArrayList<Type_produit> arrayList = (ArrayList<Type_produit>) st.afficheType();
//        ObservableList obs = FXCollections.observableArrayList(arrayList);
//        combotftype.setItems(obs);
//        
//        
//        btn1ajout.setOnAction(new EventHandler<ActionEvent>() { 
//            @Override
//            public void handle(ActionEvent event) {
//          
//            Serviceproduit sp = new Serviceproduit();
//            try {ArrayList<Type_produit> arrayList = (ArrayList<Type_produit>) st.afficheType();
//        ObservableList obs = FXCollections.observableArrayList(arrayList);
//        combotftype.setItems(obs);
//                sp.ajouterProduit(new Produits(tfnbP.getLength(),tfprix.getLength(), tfnom_produit.getText(),tfdescription.getText(),tfimage.getAccessibleText(), new Type_produit( Integer.parseInt(tftype.getText()),"", "")));
//                
//            } catch (Exception ex) {
//                Logger.getLogger(FXMLajoutpController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            FXMLLoader loader =new FXMLLoader(getClass().getResource("./FXMLaffichep.fxml"));
//           Parent root;
//            try {
//                root=loader.load();
//                btn1ajout.getScene().setRoot(root);
//            } catch (IOException ex) {
//                Logger.getLogger(FXMLajoutpController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            }
//        });
//
//    }
//}





//         try {
//                sp.ajouterProduit(new Produits(tfnbP.getLength(), tfprix.getBaselineOffset(),tfnom_produit.getText(),tfdescription.getText(),tfimage.getAccessibleText(), new Type_produit( Integer.parseInt(tftype.getText()),"", "")));
//                
//            } catch (Exception ex) {
//                Logger.getLogger(FXMLajoutpController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            FXMLLoader loader =new FXMLLoader(getClass().getResource("./FXMLaffichep.fxml"));
//           Parent root;
//            try {
//                root=loader.load();
//                btn1ajout.getScene().setRoot(root);
//            } catch (IOException ex) {
//                Logger.getLogger(FXMLajoutpController.class.getName()).log(Level.SEVERE, null, ex);
//            }




//    public void initialize(URL url, ResourceBundle rb) {
//        Serviceproduit sp = new Serviceproduit();
//        Servicetype st = new Servicetype();
//
//        combotftype.getItems().setAll(st.afficheType());
//
//        btn1ajout.setOnAction((ActionEvent event) -> {
//            try {
//                String nomProduit = tfnom_produit.getText();
//    String prixText = tfprix.getText();
//    String description = tfdescription.getText();
//    String nbPText = tfnbP.getText();
//    Type_produit selectedType = combotftype.getValue();
//
//                if (selectedType == null) {
//                    System.out.println("Veuillez sélectionner un produit.");
//                    return;
//                }
//
//                Produits nouvelProduits = new Produits();
//                nouvelProduits.setNom_produit(nomProduit);
//                nouvelProduits.setPrix(0);
//                nouvelProduits.setDescription(description);
//                nouvelProduits.setNbP(0);
//                nouvelProduits.setTp(selectedType);
//                nouvelProduits.setImage(nbPText);
//
//                sp.ajouterProduit(nouvelProduits);
//
//                btn1ajout.getScene().setRoot(FXMLLoader.load(getClass().getResource("FXMLaffichep.fxml")));
//            } catch (NumberFormatException | IOException ex) {
//                Logger.getLogger(FXMLajoutpController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
//
//        btn1ajout.setOnAction((ActionEvent event) -> {
//            try {
//                btn1ajout.getScene().setRoot(FXMLLoader.load(getClass().getResource("AjouterFacture.fxml")));
//            } catch (IOException ex) {
//                Logger.getLogger(FXMLajoutpController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
//    }