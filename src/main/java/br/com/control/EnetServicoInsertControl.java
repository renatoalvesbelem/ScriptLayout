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


    private static final String path = "D:\\Teste\\TJSC HOMOLOGAÇÃO - ORIGINAL.txt";
    public static void main(String[] args) throws IOException, BiffException {
        String inicioSQL = "insert into ENETSERVICO(CDSERVICO,FLFORAUSO,CDSERVICOPAI,DETITULO,DEURLACESSO,DEURLAJUDA,FLNECESSITAPF,FLNECESSITAOAB,FLNECESSITACERT,NUORDEM,FLINTERMEDIARIO,FLINICIAL,FLVISIVELMENU,FLACESSORAPIDO) values (";
        WorkbookSettings ws = new WorkbookSettings();
        ws.setEncoding("Cp1252");
        Workbook workbook = Workbook.getWorkbook(new File("D:\\Teste\\TJSC HOMOLOGAÇÃO - ORIGINAL.xls"),ws);

        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path)));

        Sheet sheet = workbook.getSheet(0);
        int linhas = sheet.getRows();


        for (int i = 0; i < linhas; i++) {
            String CDSERVICO = sheet.getCell(0, i).getContents();
            String FLFORAUSO = sheet.getCell(1, i).getContents();
            String CDSERVICOPAI = sheet.getCell(2, i).getContents();
            String DETITULO = sheet.getCell(3, i).getContents();
            String DEURLACESSO = sheet.getCell(4, i).getContents();
            String DEURLAJUDA = sheet.getCell(5, i).getContents();
            String FLNECESSITAPF = sheet.getCell(6, i).getContents();
            String FLNECESSITAOAB = sheet.getCell(7, i).getContents();
            String FLNECESSITACERT = sheet.getCell(8, i).getContents();
            String NUORDEM = sheet.getCell(9, i).getContents();
            String FLINTERMEDIARIO = sheet.getCell(10, i).getContents();
            String FLINICIAL = sheet.getCell(11, i).getContents();
            String FLVISIVELMENU = sheet.getCell(12, i).getContents();

            String sql = (inicioSQL +""+ CDSERVICO + ",'" + FLFORAUSO + "'," + CDSERVICOPAI + ",'" + DETITULO + "','" + DEURLACESSO + "','" + DEURLAJUDA + "','" + "N" + "','" + "N" + "','" + "N" + "'," + NUORDEM + ",'" + "N"
                    + "','" + "N" + "','" + FLVISIVELMENU +"','N');");
            String teste = new String(sql.getBytes(),"utf-8");
            System.out.println(teste);
            writer.write(teste);
            writer.newLine();
        }
        workbook.close();
        writer.flush();
        writer.close();
    }



}
