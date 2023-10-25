/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

 


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.net.URL;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import models.Produits;
import models.Type_produit;
import java.awt.Desktop;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileOutputStream;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.Serviceproduit;




import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;


/**
 * FXML Controller class
 *
 * @author DELL
 */
public class FXMLajoutpController implements Initializable {

    @FXML
    private TextField tfnom_produit;
    @FXML
    private TextField tfprix;
    @FXML
    private TextField tfdescription;
    @FXML
    private ImageView tfimage;
    @FXML
    private Button btn1ajout;
    @FXML
    private TextField tfnbP;
    @FXML
    private TextField tftype;
   
    @FXML
    private Button telechargerPDF;
    @FXML
    private Button btn1ajout2;
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btn1ajout.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent event) {
                
            Serviceproduit sp = new Serviceproduit();
            try {
                sp.ajouterProduit(new Produits(tfnbP.getLength(), tfnom_produit.getText(),tfprix.getText(),tfdescription.getText(),tfimage.getAccessibleText(), new Type_produit( Integer.parseInt(tftype.getText()),"", "")));
                
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

@FXML
    private void retourAccueil(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("accueil.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
           
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 

    
    
public class InvoiceGenerator {
    public void genererPDFProduit(Produits produits) throws DocumentException {;
            // Create a PDF document with iText
            Document document = new Document();
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Fichiers PDF", "*.pdf"));
            File fichierPDF = fileChooser.showSaveDialog(null);

            if (fichierPDF != null) {
                try {
                    PdfWriter.getInstance(document, new FileOutputStream(fichierPDF));
                    document.open();

                    // Title of the document
                    Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
                    Paragraph titre = new Paragraph("Votre Facture", titleFont);
                    titre.setAlignment(Element.ALIGN_CENTER);
                    document.add(titre);

                    // Create a table for invoice details
                    PdfPTable table = new PdfPTable(2); // 2 columns
                    table.setWidthPercentage(80); // Table width is 80% of the page width
                    table.setSpacingBefore(20f);
                    table.setSpacingAfter(20f);

                    // Add invoice details to the table
                    Font cellFont = new Font(Font.FontFamily.HELVETICA, 12);
                    cellFont.setColor(BaseColor.BLACK);

                    table.addCell(createCell("ID produit", cellFont));
                    table.addCell(createCell(String.valueOf(produits.getIdP()), cellFont));
                    table.addCell(createCell("Nom produit", cellFont));
                    table.addCell(createCell(produits.getNom_produit(), cellFont));
                    table.addCell(createCell("type produit", cellFont));
                    table.addCell(createCell(produits.getTp().getNom_type(), cellFont));
                    table.addCell(createCell("descri", cellFont));
                    table.addCell(createCell(String.valueOf(produits.getDescription()), cellFont));

                    document.add(table);

                    document.close();

                    // Open the PDF file with the default PDF viewer
                    try {
                        Desktop.getDesktop().open(fichierPDF);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // Helper method to create PdfPCell with specified font
        private PdfPCell createCell(String content, Font font) {
            PdfPCell cell = new PdfPCell(new Phrase(content, font));
            cell.setBorder(Rectangle.OUT_RIGHT);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            return cell;
        }
    

    }
    @FXML
    private void telechargerPDF(ActionEvent event) throws DocumentException {
        String prixText = tfprix.getText();
        String nomText = tfnom_produit.getText();
        String selectedType_produit = tftype.getText();

        if (selectedType_produit == null) {
            System.out.println("Veuillez sélectionner une commande.");
            return;
        }

        double montant = Double.parseDouble(prixText);

        // Create an instance of the InvoiceGenerator class
        InvoiceGenerator generator = new InvoiceGenerator();
        
        // Create a Facture object with the selected data
        Produits produits = new Produits();
        
        // Generate the PDF invoice
        generator.genererPDFProduit( produits);
    }
    
}


    
   
  
    
    
    
//public class InvoiceGenerator {
//    private void genererPDFProduit( Produits produits) {
// Document document = new Document();
//String fileName= null;
//    try {
//        PdfWriter.getInstance(document, new FileOutputStream(fileName));
//        document.open();
//
//        // Création de la police pour le titre
//        Font titreFont = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD, BaseColor.BLUE);
//
//        // Création de la police pour les informations du client
//        Font produitInfoFont = new Font(Font.FontFamily.HELVETICA, 12);
//
//        // Création de la police pour le contenu de la facture
//        Font contenuFont = new Font(Font.FontFamily.HELVETICA, 12);
//
//        // Titre de la facture
//        Paragraph titre = new Paragraph("Produit", titreFont);
//        titre.setAlignment(Element.ALIGN_CENTER);
//        document.add(titre);
//
//        // Espacement après le titre
//        document.add(new Paragraph("\n"));
//
//        // Informations du client
//        Paragraph infoClient = new Paragraph("nom produit : " + produits.getNom_produit() + " (descri : " + produits.getDescription() + ")", produitInfoFont);
//        infoClient.setAlignment(Element.ALIGN_LEFT);
//        document.add(infoClient);
//
//        // Ligne horizontale pour la séparation
//        LineSeparator line = new LineSeparator();
//        document.add(new Chunk(line));
//
//        // Informations de réservation
//        Type_produit type_produit = produits.getTp();
//
//        if (type_produit != null) {
//            // Numéro de réservation
////            Paragraph numtypeProduit = new Paragraph("Numéro de réservation : " + type_produit.getIdT(), contenuFont);
////            document.add(numtypeProduit);
//
//            // Type d'hébergement
//            Paragraph typeHebergement = new Paragraph("Type d'hébergement : " + type_produit.getNom_type(), contenuFont);
//            document.add(typeHebergement);
//
//            // Type d'activité
//            Paragraph typeActivite = new Paragraph("Type d'activité : " + type_produit.getDescription(), contenuFont);
//            document.add(typeActivite);
//
//            // Ligne horizontale pour la séparation
//            document.add(new Chunk(line));
//
//            // Informations de facture
//            Paragraph numFacture = new Paragraph("prix produit : " + produits.getPrix(), contenuFont);
//            document.add(numFacture);
//
//            Paragraph nbP = new Paragraph("nombre produit : " + produits.getNbP(), contenuFont);
//            document.add(nbP);
//
//            Paragraph image = new Paragraph("image : " + produits.getImage(), contenuFont);
//            document.add(image);
//        } else {
//            document.add(new Paragraph("Aucune réservation associée à cette facture.", contenuFont));
//        }
//        document.add(new Paragraph("\n"));
//         document.add(new Paragraph("\n"));
//         document.add(new Paragraph("\n"));
//        // Pied de page
//        Font footerFont = new Font(Font.FontFamily.HELVETICA, 10, Font.ITALIC);
//        Paragraph footer = new Paragraph("Merci de votre confiance.", footerFont);
//        footer.setAlignment(Element.ALIGN_CENTER);
//        document.add(footer);
//        // Fermeture du document
//        document.close();
//
//        //showAlert("Facture générée avec succès.", "Succès", AlertType.INFORMATION);
//    } catch (Exception e) {
//        //showAlert("Erreur lors de la génération de la facture.", "Erreur", AlertType.ERROR);
//        e.printStackTrace();
//    }
//}
// }