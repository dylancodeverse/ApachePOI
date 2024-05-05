package scaffold.framework.demo.entity;

import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;

import jakarta.persistence.*;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Entity
@Table(name = "promotion")

public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "year", nullable = false)
    private Integer year;

    public static byte[] generateExcelProm(List<Promotion> list) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        try {
            HSSFSheet sheet = workbook.createSheet("Prom Info");
            HSSFRow row = sheet.createRow(0);

            row.createCell(0).setCellValue("ID");
            row.createCell(1).setCellValue("NAME");
            row.createCell(2).setCellValue("YEAR");
            int i = 1;
            for (Promotion pr : list) {
                HSSFRow row1 = sheet.createRow(i);
                row1.createCell(0).setCellValue(pr.getId());
                row1.createCell(1).setCellValue(pr.getName());
                HSSFCell celll = row1.createCell(2);
                celll.setCellValue(pr.getYear());
                if (pr.getYear() == 2002) {
                    CellStyle highlightStyle = workbook.createCellStyle();
                    highlightStyle.setFillForegroundColor(IndexedColors.CORAL.index);
                    highlightStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                    celll.setCellStyle(highlightStyle);
                }
                i++;
            }
            return workbook.getBytes();
        } finally {
            workbook.close();
        }

    }

    public void setId(Integer value) {
        this.id = value;
    }

    public void setName(String value) {
        this.name = value;
    }

    public void setYear(Integer value) {
        this.year = value;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getYear() {
        return this.year;
    }

    @Override
    public String toString() {
        return name;
    }

}
