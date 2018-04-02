package io.shike.discover;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.stream.Stream;

/**
 * @author Ranger Tsao(https://github.com/boliza)z
 */
public class PdfDiscover {

  public static void main(String[] args) throws IOException {
    PDDocument pdf = PDDocument.load(PdfDiscover.class.getClassLoader().getResourceAsStream("pdf2.pdf"));

    PDFTextStripperByArea stripperByArea = new PDFTextStripperByArea();
    PDPage page = pdf.getPage(20);
    System.out.println("page:" + page.getMediaBox().toString());
    stripperByArea.addRegion("header", new Rectangle2D.Double(0, 0, 595.22, 55));
    stripperByArea.addRegion("title", new Rectangle2D.Double(0, 55, 595.22, 60));
    stripperByArea.addRegion("content", new Rectangle2D.Double(0, 70, 595.22, 760));
    stripperByArea.addRegion("footer", new Rectangle2D.Double(0, 762, 595.22, 80));
    stripperByArea.addRegion("whole", new Rectangle2D.Double(0, 0, 595.22, 842));


    stripperByArea.extractRegions(page);
    System.out.println(stripperByArea.getTextForRegion("header"));
    System.out.println(stripperByArea.getTextForRegion("title"));
    System.out.println(stripperByArea.getTextForRegion("footer"));
    System.out.println(stripperByArea.getTextForRegion("content"));
    System.out.println(stripperByArea.getTextForRegion("whole"));
    Stream.of(stripperByArea.getTextForRegion("whole").split(System.lineSeparator())).forEach(s -> System.out.println(s + "~~~2b"));


  }
}
