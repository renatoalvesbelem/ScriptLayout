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

    private static final String path = "C:\\Projetos\\WEB_PRODUTO\\fWEB\\Produto\\Documentos\\Roteiro de Teste\\Configuração ENETSERVICO\\SC\\Planilha\\TRE CORRIGIDO\\UPDATE ORIGINAL completo-TRE.txt";

    public static void main(String[] args) throws IOException, BiffException {
        String updateSQL = "update ENETSERVICO set ";

        WorkbookSettings ws = new WorkbookSettings();
        ws.setEncoding("Cp1252");

        Workbook workbook = Workbook.getWorkbook(new File("C:\\Projetos\\WEB_PRODUTO\\fWEB\\Produto\\Documentos\\Roteiro de Teste\\Configuração ENETSERVICO\\SC\\Planilha\\TRE CORRIGIDO\\UPDATE ORIGINAL completo-TRE.xls"), ws);

        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path)));

        Sheet sheet = workbook.getSheet(0);
        int linhas = sheet.getRows();


        for (int i = 0; i < linhas; i++) {
            String CDSERVICO = sheet.getCell(0, i).getContents();
            String FLFORAUSO = sheet.getCell(1, i).getContents();
            String CDSERVICOPAI = sheet.getCell(2, i).getContents();
            String DEITEMMENU = sheet.getCell(3, i).getContents();
            String NUORDEM = sheet.getCell(7, i).getContents();
            String FLVISIVELMENU = sheet.getCell(11, i).getContents();

            String sql = (updateSQL + "FLFORAUSO ='" + FLFORAUSO + "',CDSERVICOPAI =" + CDSERVICOPAI + ",DEITEMMENU='" + DEITEMMENU + "',NUORDEM=" + NUORDEM + ",FLVISIVELMENU='" + FLVISIVELMENU + "'" + " WHERE " + "CDSERVICO =" + CDSERVICO + ";");

            System.out.println(sql);
            writer.write(sql);
            writer.newLine();
        }
        workbook.close();
        writer.flush();
        writer.close();
    }
}
