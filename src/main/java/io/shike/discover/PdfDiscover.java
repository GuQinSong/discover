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
    PDDocument pdf = PDDocument.load(PdfDiscover.class.getClassLoader().getResourceAsStream("pdf.pdf"));

    PDFTextStripperByArea stripper = new PDFTextStripperByArea();
    PDPage page = pdf.getPage(25);
    System.out.println("page:" + page.getMediaBox().toString());
    stripper.addRegion("header", new Rectangle2D.Double(0, 0, 595.22, 60));
    stripper.addRegion("title", new Rectangle2D.Double(0, 60, 595.22, 70));
    stripper.addRegion("content", new Rectangle2D.Double(0, 150, 595.22, 760));
    stripper.addRegion("footer", new Rectangle2D.Double(0, 762, 595.22, 80));
    stripper.extractRegions(page);
    System.out.println(stripper.getTextForRegion("header"));
    System.out.println(stripper.getTextForRegion("title"));
    System.out.println(stripper.getTextForRegion("footer"));
    System.out.println(stripper.getTextForRegion("content"));

    Stream.of(stripper.getTextForRegion("content").split(System.lineSeparator())).forEach(s -> System.out.println(s + "~~~2b"));

  }

}
