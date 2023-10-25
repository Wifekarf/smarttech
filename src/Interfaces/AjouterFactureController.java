/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Desktop;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.awt.Desktop;






import models.Commandee;
import models.Facture;
import services.FactureService;
import services.CommandeeService;

public class AjouterFactureController implements Initializable {

    @FXML
    private TextField MontantField;
    @FXML
    private DatePicker DateField;
    @FXML
    private ComboBox<Commandee> CommandeIdField;
    @FXML
    private Button AjoutFacture;
    @FXML
    private Button AnnulerFacture;
    @FXML
    private Button AfficherFactures;
    @FXML
    private Button TelechargerPDF;

    private FactureService factureService;
    private CommandeeService commandeeService;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        factureService = new FactureService();
        commandeeService = new CommandeeService();

        // Remplir le ComboBox avec les IDs des commandes
        CommandeIdField.getItems().setAll(commandeeService.afficherCommandes());



        AjoutFacture.setOnAction((ActionEvent event) -> {
            try {
                double montant = Double.parseDouble(MontantField.getText());
                LocalDate date = DateField.getValue();
                Commandee selectedCommande = CommandeIdField.getValue();

                if (selectedCommande == null) {
                    System.out.println("Veuillez sélectionner une commande.");
                    return;
                }

                Facture nouvelleFacture = new Facture();
                nouvelleFacture.setMontant(montant);
                nouvelleFacture.setDate(date);
                nouvelleFacture.setCommandee(selectedCommande);

                factureService.ajouterFacture(nouvelleFacture);

                AnnulerFacture.getScene().setRoot(FXMLLoader.load(getClass().getResource("AjouterFacture.fxml")));
            } catch (NumberFormatException ex) {
                Logger.getLogger(AjouterFactureController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AjouterFactureController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        AnnulerFacture.setOnAction((ActionEvent event) -> {
            try {
                AnnulerFacture.getScene().setRoot(FXMLLoader.load(getClass().getResource("AjouterFacture.fxml")));
            } catch (IOException ex) {
                Logger.getLogger(AjouterFactureController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    public void supprimerFacturesDepassees() {
        factureService.supprimerLignesDepassees();
    }
   
    @FXML
    private void retourPage2(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Page2.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) AnnulerFacture.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void AffichFactures(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherFactures.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) AnnulerFacture.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Define the method for generating PDF invoices


public class InvoiceGenerator {

        public void generatePDFInvoice(Facture facture) {
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

                    table.addCell(createCell("ID Facture", cellFont));
                    table.addCell(createCell(String.valueOf(facture.getIdFacture()), cellFont));
                    table.addCell(createCell("Date", cellFont));
                    table.addCell(createCell(facture.getDate().toString(), cellFont));
                    table.addCell(createCell("Commande", cellFont));
                    table.addCell(createCell(facture.getCommandee().getCommandeDetails(), cellFont));
                    table.addCell(createCell("Montant", cellFont));
                    table.addCell(createCell(String.valueOf(facture.getMontant()), cellFont));

                    document.add(table);

                    document.close();

                    // Open the PDF file with the default PDF viewer
                    try {
                        Desktop.getDesktop().open(fichierPDF);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (DocumentException | IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // Helper method to create PdfPCell with specified font
        private PdfPCell createCell(String content, Font font) {
            PdfPCell cell = new PdfPCell(new Phrase(content, font));
            cell.setBorder(Rectangle.NO_BORDER);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            return cell;
        }
    }

    @FXML
    private void telechargerPDF(ActionEvent event) {
        String montantText = MontantField.getText();
        String dateText = DateField.getValue().toString();
        Commandee selectedCommande = CommandeIdField.getValue();

        if (selectedCommande == null) {
            System.out.println("Veuillez sélectionner une commande.");
            return;
        }

        double montant = Double.parseDouble(montantText);

        // Create an instance of the InvoiceGenerator class
        InvoiceGenerator generator = new InvoiceGenerator();
        
        // Create a Facture object with the selected data
        Facture facture = new Facture(selectedCommande, montant, LocalDate.parse(dateText));
        
        // Generate the PDF invoice
        generator.generatePDFInvoice(facture);
    }

    // Other methods and code for your JavaFX controller
}




    



