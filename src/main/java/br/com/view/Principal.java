package br.com.view;

import br.com.control.EnetServicoInsertControl;
import br.com.control.EnetServicoUpdateControl;
import br.com.control.EnetServicoUpdaterRecoveyControl;
import jxl.read.biff.BiffException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Principal {
    private static JButton btSelecionarArquivoInsertTotal, btCriarScriptInsert, btCriarScriptUpdateBKP, btCriarScriptUpdateFinal;
    private static JTextField pathFileInsert;

    public static void main(String args[]) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(new Dimension(600, 400));
        JPanel jPanel = new JPanel();
        jPanel.setSize(new Dimension(600, 400));

        btSelecionarArquivoInsertTotal = new JButton("Selecione");
        btSelecionarArquivoInsertTotal.setSize(new Dimension(100, 30));
        btSelecionarArquivoInsertTotal.setLocation(1, 1);
        btSelecionarArquivoInsertTotal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizaTextField(pathFileInsert);
            }
        });


        pathFileInsert = new JTextField();
        pathFileInsert.setSize(new Dimension(400, 20));
        pathFileInsert.setEditable(false);
        pathFileInsert.setLocation(110, 1);

        btCriarScriptInsert = new JButton("Criar Script Insert");
        btCriarScriptInsert.setSize(new Dimension(150, 30));
        btCriarScriptInsert.setLocation(1, 50);
        btCriarScriptInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new EnetServicoInsertControl(pathFileInsert.getText()).geraScript();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (BiffException e1) {
                    e1.printStackTrace();
                }
            }
        });

        btCriarScriptUpdateBKP = new JButton("Criar Script Update BKP");
        btCriarScriptUpdateBKP.setSize(new Dimension(180, 30));
        btCriarScriptUpdateBKP.setLocation(160, 50);
        btCriarScriptUpdateBKP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new EnetServicoUpdaterRecoveyControl(pathFileInsert.getText()).geraScript();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (BiffException e1) {
                    e1.printStackTrace();
                }
            }
        });


        btCriarScriptUpdateFinal = new JButton("Criar Script Update Cliente");
        btCriarScriptUpdateFinal.setSize(new Dimension(190, 30));
        btCriarScriptUpdateFinal.setLocation(350, 50);
        btCriarScriptUpdateFinal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new EnetServicoUpdateControl(pathFileInsert.getText()).geraScript();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (BiffException e1) {
                    e1.printStackTrace();
                }
            }
        });

        jPanel.add(pathFileInsert);
        jPanel.add(btCriarScriptInsert);
        jPanel.add(btCriarScriptUpdateBKP);
        jPanel.add(btCriarScriptUpdateFinal);
        jPanel.add(btSelecionarArquivoInsertTotal);
        jPanel.setLayout(null);
        jFrame.add(jPanel);
        jFrame.show();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private static void atualizaTextField(JTextField jTextField) {
        JFileChooser file = new JFileChooser(jTextField.getText());
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        file.setFileFilter(new FileNameExtensionFilter("*.xls", "xls"));
        int i = file.showOpenDialog(null);
        if (i == 1) {
            jTextField.setText("");
        } else {
            File arquivo = file.getSelectedFile();
            jTextField.setText(arquivo.getPath());
        }
    }
}
