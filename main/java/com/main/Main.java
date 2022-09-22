/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main;

import java.awt.Container;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LessaInformatica
 */
public class Main extends JFrame {

    public Main() {
        super("Styve Tele Pizza");
        JDesktopPane jdp = new JDesktopPane();
        add(jdp);
        jdp.add(new NovoPedidoJInternalFrame());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //<editor-fold defaultstate="collapsed" desc="private class NovoPedidoJInternalFrame">
    public class NovoPedidoJInternalFrameA extends JInternalFrame {

        public NovoPedidoJInternalFrameA() {
            super("Novo Pedido", true, true, true, true);
            setLayout(new NovoPedidoGroupLayout(this.getContentPane()));
            setSize(600, 400);
            setVisible(true);
        }

        //<editor-fold defaultstate="collapsed" desc="NovaPizzaGroupLayout">
        public class NovoPedidoGroupLayout extends GroupLayout {

            public NovoPedidoGroupLayout(Container host) {
                super(host);
                setAutoCreateGaps(true);
                setAutoCreateContainerGaps(true);
                setHorizontalGroup(setHorizontalGroup());
                setVerticalGroup(setVerticalGroup());
                //btnAddPizza.addActionListener((ActionEvent) -> new NovaPizza(this));
            }

            private Group setHorizontalGroup() {
                return createParallelGroup()
                        .addComponent(btnAddPizza, DEFAULT_SIZE, DEFAULT_SIZE, Integer.MAX_VALUE)
                        .addComponent(jsp)
                        .addComponent(btnFinalizar, DEFAULT_SIZE, DEFAULT_SIZE, Integer.MAX_VALUE);
            }

            private Group setVerticalGroup() {
                return createSequentialGroup()
                        .addGroup(
                                createParallelGroup(Alignment.BASELINE, false)
                                        .addComponent(btnAddPizza)
                        )
                        .addComponent(jsp)
                        .addGroup(
                                createParallelGroup(Alignment.BASELINE, false)
                                        .addComponent(btnFinalizar)
                        );
            }

            protected void addArrayListPizzaData(PizzaData pd) {
                /*arrayPizzaData.add(pd);
                String sabores = new String();
                for (String sabor : pd.sabores) {
                    sabores += sabor + ";";
                }
                dtm.addRow(new Object[]{pd.tamanho, pd.borda, sabores});
                for (PizzaData pdt : arrayPizzaData) {
                    System.out.println("Tamanho: " + pdt.tamanho);
                    System.out.println("Borda: " + pdt.borda);
                    for (String sabor : pdt.sabores) {
                        System.out.println("Sabor: " + sabor);
                    }
                }*/
            }

            private JButton btnAddPizza = new JButton("Adicionar Pizza");
            private String[] columnNames = new String[]{"Tamanho", "Borda", "Sabores"};
            private ArrayList<PizzaData> arrayPizzaData = new ArrayList<>();
            private DefaultTableModel dtm = new DefaultTableModel(columnNames, 0);
            private JTable table = new JTable(dtm);
            private JScrollPane jsp = new JScrollPane(table);
            private JButton btnFinalizar = new JButton("Finaliar");
            private final JLabel lbl = new JLabel("Hahaha");

        }
        //</editor-fold>

    }
    //</editor-fold>

    public static void main(String[] args) {
        new Main();
    }

}
