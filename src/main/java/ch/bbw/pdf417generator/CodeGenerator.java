package ch.bbw.pdf417generator;

import com.keepdynamic.barcode.generator.PDF417;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/* TODO:
    - PDF417 Code mehrzeilig (breiter)
    - Bild Manipulator (Code wird auf Vorlage generiert)
 */

public class CodeGenerator{
    public void generateCode(String ticketValues) {
        PDF417 barcode = new PDF417();
        TicketModel ticket = new TicketModel();

        // alle Daten eingeben
        barcode.setCodeText(ticketValues.toString());
        barcode.setRowCount(20);

        // draw and generate barcode to buffered image object
        try {
            ticket.setPdf417Code(barcode.drawBarCode2Image()); // Speichert das generierte Bild in die PDF417Code BufferedImage Variable
            File outputfile = new File("src/main/resources/static/pdf417code.png");
            ImageIO.write(ticket.getPdf417Code(), "png", outputfile);
            System.out.println("Barcode ("+ barcode.getCodeText() +") wurde erfolgreich generiert!");
            System.out.println(ticket.getPdf417Code());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}