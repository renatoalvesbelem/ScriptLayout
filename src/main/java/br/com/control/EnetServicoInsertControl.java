package br.com.control;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EnetServicoInsertControl {
    private String path;

    public EnetServicoInsertControl(String path) {
        this.path = path;
    }

    public void geraScript() throws IOException, BiffException {
        String inicioSQL = "INSERT INTO SAJ.ENETSERVICO(CDSERVICO,FLFORAUSO,CDSERVICOPAI,DETITULO,FLNECESSITAPF,FLNECESSITAOAB,FLNECESSITACERT,NUORDEM,FLINTERMEDIARIO,FLINICIAL,FLVISIVELMENU,FLACESSORAPIDO) VALUES (";
        WorkbookSettings ws = new WorkbookSettings();
        ws.setEncoding("Cp1252");
        Workbook workbook = Workbook.getWorkbook(new File(path), ws);

        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path.substring(0, path.length() - 3) + "DH4")));

        Sheet sheet = workbook.getSheet(0);

        for (int i = 0; i < sheet.getRows(); i++) {
            String CDSERVICO = sheet.getCell(0, i).getContents();
            String FLFORAUSO = sheet.getCell(1, i).getContents();
            String CDSERVICOPAI = sheet.getCell(2, i).getContents();
            String DETITULO = sheet.getCell(3, i).getContents();
            String FLNECESSITAPF = sheet.getCell(4, i).getContents();
            String FLNECESSITAOAB = sheet.getCell(5, i).getContents();
            String FLNECESSITACERT = sheet.getCell(6, i).getContents();
            String NUORDEM = sheet.getCell(7, i).getContents();
            String FLINTERMEDIARIO = sheet.getCell(8, i).getContents();
            String FLINICIAL = sheet.getCell(9, i).getContents();
            String FLVISIVELMENU = sheet.getCell(10, i).getContents();
            String FLACESSORAPIDO = sheet.getCell(11, i).getContents();
            String sql = (inicioSQL + "'" + CDSERVICO + "','" + FLFORAUSO + "'," + CDSERVICOPAI + ",'" + DETITULO + "'"
                    + ",'" + FLNECESSITAPF + "','" + FLNECESSITAOAB + "','" + FLNECESSITACERT + "','" + NUORDEM + "','" + FLINTERMEDIARIO
                    + "','" + FLINICIAL + "','" + FLVISIVELMENU + "','" + FLACESSORAPIDO + "');");
            String teste = new String(sql.getBytes(), "utf-8");
            System.out.println(teste);
            writer.write(teste);
            writer.newLine();
        }
        writer.write("UPDATE SAJ.ENETSERVICO SET DEITEMMENU = DETITULO;");
        workbook.close();
        writer.flush();
        writer.close();
    }


}
