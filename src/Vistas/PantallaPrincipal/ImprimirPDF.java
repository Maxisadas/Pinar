/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.PantallaPrincipal;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JOptionPane;


/**
 *
 * @author Maxi
 */
public class ImprimirPDF {


    
    public void imprimir(String contenido){
        Date fechaHoy = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        final String r="Generarpdf.pdf";
        //Initialize PDF writer
        PdfWriter writer=null;
        try {
            writer = new PdfWriter(r);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RutaPdf.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);
        // Initialize document
        Document document = new Document(pdf);
        Paragraph titulo = new Paragraph("Pinar Plaza").setFontSize(18);
        titulo.setTextAlignment(TextAlignment.CENTER);
        Paragraph subtitulo1 = new Paragraph();
        Paragraph subtitulo2 = new Paragraph("Informe del paciente: "+ "                                                                                           "+" Fecha de elaboracion: " +formateador.format(fechaHoy) ).setFontSize(10);
        //Add paragraph to the document
        document.add(titulo);
        document.add(subtitulo1);
        document.add(subtitulo2);
        document.add(new Paragraph(" "));
        document.add(new Paragraph(contenido).setFontSize(7));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Firma del medico:").setFontSize(10).setTextAlignment(TextAlignment.RIGHT).setMarginRight(40));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("--------------------------------------").setFontSize(10).setTextAlignment(TextAlignment.RIGHT).setMarginRight(20));
 
        //Close document
        document.close();
        PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();

        DocFlavor flavor =  DocFlavor.INPUT_STREAM.AUTOSENSE; 
        PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
        if (printService != null) {
        DocAttributeSet das = new HashDocAttributeSet();
        DocPrintJob job = printService.createPrintJob();
        FileInputStream fis = null;
        try { 
            fis = new FileInputStream("Generarpdf.pdf");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImprimirPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        Doc doc = new SimpleDoc(fis,flavor,das); 
        
        try {
            job.print(doc,attributeSet);
        } catch (PrintException ex) {
            Logger.getLogger(ImprimirPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        }else{
            JOptionPane.showMessageDialog(null, "No se ah detectado ninguna impresora.");
            
        }

        
        ///////////JASPER////////////
        
        
    }
    

     
     
    
}
