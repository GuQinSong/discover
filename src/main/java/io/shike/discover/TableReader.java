package io.shike.discover;

import java.io.File;
import java.util.List;

import io.shike.discover.entity.Table;

/**
 * @author Ranger Tsao(https://github.com/boliza)
 */
public class TableReader {

  public static void main(String[] args) {
    PDFTableExtractor extractor = new PDFTableExtractor();
    List<Table> tables = extractor.setSource(new File("src/main/resources/pdf.pdf"))
                                  .addPage(29)
                                  .exceptLine(new int[]{0, 1}) //the first line in each page
                                  .extract();
    tables.forEach(table -> System.out.println(table.toHtml()));
  }

}
