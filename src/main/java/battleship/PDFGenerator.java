package battleship;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.util.List;

public class PDFGenerator {
    // Dentro da classe PDFGenerator.java
    public void gerarRelatorio(List<IMove> movimentos) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("target/Relatorio_Jogadas.pdf"));
            document.open();
            document.add(new Paragraph("DIÁRIO DE BORDO - BATALHA NAVAL"));
            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(3);
            table.addCell("Movimento #");
            table.addCell("Coordenadas");
            table.addCell("Resultados");

            for (IMove move : movimentos) {
                table.addCell(String.valueOf(move.getNumber()));
                // Transforma a lista de tiros numa string (ex: [A1, A2, A3])
                table.addCell(move.getShots().toString());

                table.addCell("Processado");
            }

            document.add(table);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}
