package br.com.control;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EnetServicoUpdaterRecoveyControl {
    private String path;
    public EnetServicoUpdaterRecoveyControl(String path) {
        this.path = path;
    }
    public void geraScript() throws IOException, BiffException {
        String updateSQL = "UPDATE SAJ.ENETSERVICO SET ";

        WorkbookSettings ws = new WorkbookSettings();
        ws.setEncoding("Cp1252");

        Workbook workbook = Workbook.getWorkbook(new File(path), ws);

        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path.substring(0, path.length() - 4) + " - BKP.DH4")));

        Sheet sheet = workbook.getSheet(0);
        int linhas = sheet.getRows();


        for (int i = 0; i < linhas; i++) {
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

            String sql = (updateSQL + "FLFORAUSO ='" + FLFORAUSO
                    + "',CDSERVICOPAI ='" + CDSERVICOPAI
                    + "',DETITULO='" + DETITULO
//                    + "',FLNECESSITAPF='" + FLNECESSITAPF
//                    + "',FLNECESSITAOAB='" + FLNECESSITAOAB
//                    + "',FLNECESSITACERT='" + FLNECESSITACERT
                    + "',NUORDEM='" + NUORDEM
                    + "',FLINTERMEDIARIO='" + FLINTERMEDIARIO
                    + "',FLINICIAL='" + FLINICIAL
                    + "',FLVISIVELMENU='" + FLVISIVELMENU
//                    + "',FLACESSORAPIDO='" + FLACESSORAPIDO
                    + "'" + " WHERE " + "CDSERVICO ='" + CDSERVICO + "';");

            System.out.println(sql);
            writer.write(sql);
            writer.newLine();
        }
        writer.write("UPDATE SAJ.ENETSERVICO SET DEITEMMENU = DETITULO;");
        workbook.close();
        writer.flush();
        writer.close();
    }
}
