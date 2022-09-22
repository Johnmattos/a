/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main;

import java.awt.Container;
import java.awt.PrintJob;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LessaInformatica
 */
public class PizzasInfoGroupLayout extends GroupLayout {

    //<editor-fold defaultstate="collapsed" desc="PizzasInfoGroupLayout(Container host)">
    public PizzasInfoGroupLayout(Container host) {
        super(host);
        setAutoCreateGaps(true);
        setAutoCreateContainerGaps(true);
        setHorizontalGroup(setHorizontalGroup());
        setVerticalGroup(setVerticalGroup());
        btnAddPizza.addActionListener((ActionEvent) -> new NovaPizzaJFrame(this));
        btnFinalizar.addActionListener((ActionEvent) -> imprimir());
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="setHorizontalGroup()">
    private Group setHorizontalGroup() {
        return createParallelGroup()
                .addComponent(btnAddPizza)
                .addComponent(jsp)
                .addComponent(btnFinalizar);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="setVerticalGroup()">
    private Group setVerticalGroup() {
        return createSequentialGroup()
                .addComponent(btnAddPizza)
                .addComponent(jsp)
                .addComponent(btnFinalizar);
    }
    //</editor-fold>

    protected void addSabor(PizzaData pd) {
        String tamanho = pd.getTamanho();
        String borda = pd.getBorda();
        String sabores = new String();
        for (String sabor : pd.getSabores()) {
            sabores += sabor + ";";
        }
        dtm.addRow(new Object[]{tamanho, borda, sabores});
        arrayPizzaData.add(pd);
        /*for(PizzaData pdt : arrayPizzaData){
            System.out.println("Tamanho: " + pdt.tamanho);
            System.out.println("Borda: " + pdt.borda);
            for(String sabor : pdt.sabores){
                System.out.println("Sabor: " + sabor);
            }
        }*/
    }

    private void imprimir() {
        for (PizzaData pdt : arrayPizzaData) {
            System.out.println("Tamanho: " + pdt.getTamanho());
            System.out.println("Borda: " + pdt.getBorda());
            System.out.println("Sabores: " + pdt.getSabores());
            for (String sabor : pdt.getSabores()) {
                System.out.println("Sabor: " + sabor);
            }
        }
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        PageFormat pageFormat = printerJob.defaultPage();
        Paper paper = new Paper();
        paper.setSize(pageFormat.getWidth(), pageFormat.getHeight());
        paper.setImageableArea(10, 10, (pageFormat.getImageableWidth() - pageFormat.getImageableX()),
                (pageFormat.getImageableHeight() - pageFormat.getImageableY()));
        pageFormat.setPaper(paper);
        printerJob.setPrintable((g, pf, pageIndex) -> {
            if (pageIndex > 0) {
                return Printable.NO_SUCH_PAGE;
            }
            int x = (int) pf.getImageableX();
            int y = (int) pf.getImageableY();
            int interline = 15;
            y += interline;
            g.drawString("Ruan Pereira Mattos", x, y);
            y += interline;
            g.drawString("Fone: (51) 98315-9580", x, y);
            y += interline;
            g.drawString("Rua: Pernambuco", x, y);
            y += interline;
            g.drawString("Numero: 1436", x, y);
            y += interline;
            g.drawString("Complemento: Casa", x, y);
            y += interline;
            g.drawString("Bairro: Sao Jose", x, y);
            y += interline;
            g.drawString("Cidade: Tramandai", x, y);
            for (PizzaData pdt : arrayPizzaData) {
                y += interline;
                g.drawString("Tamanho: " + pdt.getTamanho(), x + 5, y);
                y += interline;
                g.drawString("Borda: " + pdt.getTamanho(), x + 10, y);
                System.out.println("Tamanho: " + pdt.getTamanho());
                System.out.println("Borda: " + pdt.getBorda());
                System.out.println("Sabores: " + pdt.getSabores());
                for (String sabor : pdt.getSabores()) {
                    y += interline;
                    g.drawString("Borda: " + sabor, x + 15, y);
                    System.out.println("Sabor: " + sabor);
                }
            }
            return Printable.PAGE_EXISTS;
        }, pageFormat);
    }

    //<editor-fold defaultstate="collapsed" desc="Variables">
    private JButton btnAddPizza = new JButton("Adicionar Pizza");
    private String[] columnNames = new String[]{"Tamanhos", "Bordas", "Sabores"};
    private ArrayList<PizzaData> arrayPizzaData = new ArrayList<>();
    private DefaultTableModel dtm = new DefaultTableModel(columnNames, 0);
    private JTable table = new JTable(dtm);
    private JScrollPane jsp = new JScrollPane(table);
    private JButton btnFinalizar = new JButton("Finalizar");
    //</editor-fold>

}
