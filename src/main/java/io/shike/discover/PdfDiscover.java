package io.shike.discover;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.awt.geom.Rectangle2D;
import java.io.IOException;

/**
 * @author Ranger Tsao(https://github.com/boliza)
 */
public class PdfDiscover {

  public static void main(String[] args) throws IOException {
    PDDocument pdf = PDDocument.load(PdfDiscover.class.getClassLoader().getResourceAsStream("pdf.pdf"));

    PDFTextStripperByArea stripper = new PDFTextStripperByArea();
    PDPage page = pdf.getPage(25);
    stripper.addRegion("header", new Rectangle2D.Double(0, 0, 595.22, 60));
    stripper.addRegion("title", new Rectangle2D.Double(0, 60, 595.22, 70));
    stripper.extractRegions(page);
    System.out.println(stripper.getTextForRegion("header").trim());
    System.out.println(stripper.getTextForRegion("title").trim());
  }

}
