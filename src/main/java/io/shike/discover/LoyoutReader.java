package io.shike.discover;

import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

/**
 * @author Ranger Tsao(https://github.com/boliza)
 */
public class LoyoutReader {

  public static void main(String[] args) throws IOException {
    PDFParser pdfParser = new PDFParser(new RandomAccessFile(new File("src/main/resources/pdf.pdf"), "r"));
    pdfParser.parse();
    PDDocument pdDocument = new PDDocument(pdfParser.getDocument());
    PDFTextStripper pdfTextStripper = new PDFLayoutTextStripper();
    pdfTextStripper.setStartPage(26);
    pdfTextStripper.setEndPage(26);
    System.out.println(pdfTextStripper.getText(pdDocument));
  }

}
