package br.com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Principal {
    private static JButton btSelecionarArquivoInsertTotal, btSelecionarArquivoUpdateTotal,btSelecionarArquivoUpdateFinal;
    private static JTextField pathFileInsert,pathFileUpdateTotal,pathFileUpdateFinal;

    public static void main(String args[]){
        JFrame jFrame = new JFrame();
        jFrame.setSize(new Dimension(800,400));
        JPanel jPanel = new JPanel();
        jPanel.setSize(new Dimension(800,400));

        btSelecionarArquivoInsertTotal = new JButton("Selecione");
        btSelecionarArquivoInsertTotal.setSize(new Dimension(100,20));
        btSelecionarArquivoInsertTotal.setLocation(1,1);
        btSelecionarArquivoInsertTotal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser file = new JFileChooser();
                file.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int i= file.showSaveDialog(null);
                if (i==1){
                    pathFileInsert.setText("");
                } else {
                    File arquivo = file.getSelectedFile();
                    pathFileInsert.setText(arquivo.getPath());
                }
            }
        } );


        pathFileInsert = new JTextField();
        pathFileInsert.setSize(new Dimension(400,20));
        pathFileInsert.setEditable(false);
        pathFileInsert.setLocation(110,1);

        pathFileUpdateFinal = new JTextField();
        pathFileUpdateFinal.setSize(new Dimension(400,20));
        pathFileUpdateFinal.setEditable(false);
        pathFileUpdateFinal.setLocation(110,50);

        btSelecionarArquivoUpdateFinal =new JButton("Selecione");
        btSelecionarArquivoUpdateFinal.setSize(new Dimension(100,20));
        btSelecionarArquivoUpdateFinal.setLocation(1,50);
        btSelecionarArquivoUpdateFinal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser file = new JFileChooser();
                file.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int i= file.showSaveDialog(null);
                if (i==1){
                    pathFileUpdateFinal.setText("");
                } else {
                    File arquivo = file.getSelectedFile();
                    pathFileUpdateFinal.setText(arquivo.getPath());
                }
            }
        } );

        jPanel.add(pathFileInsert);
        jPanel.add(pathFileUpdateFinal);

        jPanel.add(btSelecionarArquivoInsertTotal);
        jPanel.add(btSelecionarArquivoUpdateFinal);
        jPanel.setLayout(null);
        jFrame.add(jPanel);
        jFrame.show();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
