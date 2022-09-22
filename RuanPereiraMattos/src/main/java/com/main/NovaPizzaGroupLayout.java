/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main;

import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author LessaInformatica
 */
class NovaPizzaGroupLayout extends GroupLayout {

    //<editor-fold defaultstate="collapsed" desc="NovaPizzaGroupLayout(Container host)">
    public NovaPizzaGroupLayout(Container host, PizzasInfoGroupLayout pigl, NovaPizzaJFrame npjf) {
        super(host);
        this.pigl = pigl;
        this.npjf = npjf;
        setAutoCreateGaps(true);
        setAutoCreateContainerGaps(true);
        setHorizontalGroup(setHorizontalGroup());
        setVerticalGroup(setVerticalGroup());
        jcbSabores.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    addSabor();
                }
            }
        });
        btnAddSabor.addActionListener((ActionEvent) -> addSabor());
        btnFinalizar.addActionListener((ActionEvent) -> finalizar());
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="addSabor()">
    private void addSabor() {
        arraySabores.add(jcbSabores.getSelectedItem().toString());
        dlm.addElement(jcbSabores.getSelectedItem().toString());
        npjf.pack();
        System.out.println("Sabor: " + jcbSabores.getSelectedItem().toString() + "\tadicionado");
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="finalizar()">
    private void finalizar() {
        if (!arraySabores.isEmpty()) {
            PizzaData pd = new PizzaData(
                    jcbTamanhos.getSelectedItem().toString(),
                    jcbBordas.getSelectedItem().toString());
            /*PizzaData pd = new PizzaData();
            pd.tamanho = jcbTamanhos.getSelectedItem().toString();
            pd.borda = jcbBordas.getSelectedItem().toString();*/
            for (String a : arraySabores) {
                pd.addSabor(a);
            }
            //pd.sabores = arraySabores;
            System.out.println("Tamanho: " + pd.getTamanho());
            System.out.println("Borda: " + pd.getBorda());
            System.out.println("Sabores...");
            for (String sabor : pd.getSabores()) {
                System.out.println("Sabor: " + sabor);
            }
            pigl.addSabor(pd);
            dlm.removeAllElements();
            arraySabores.clear();
            npjf.pack();
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="setHorizontalGroup()">
    private Group setHorizontalGroup() {
        return createParallelGroup()
                .addComponent(jcbTamanhos)
                .addComponent(jcbBordas)
                .addComponent(jcbSabores)
                .addComponent(btnAddSabor)
                .addComponent(jlSabores)
                .addComponent(btnFinalizar);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="setVerticalGroup()">
    private Group setVerticalGroup() {
        return createSequentialGroup()
                .addComponent(jcbTamanhos)
                .addComponent(jcbBordas)
                .addComponent(jcbSabores)
                .addComponent(btnAddSabor)
                .addComponent(jlSabores)
                .addComponent(btnFinalizar);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Variables">
    private PizzasInfoGroupLayout pigl = null;
    private NovaPizzaJFrame npjf = null;
    private JLabel lbl = new JLabel("Haha");
    private String[] tamanhos = new String[]{"Pequena", "Grande", "Familia"};
    private String[] bordas = new String[]{
        "Sem Borda", 
        "Catupiry", 
        "Cheddar",
        "Meio Meio Salgada",
        "Mista Salgada",
        "Choco Preto",
        "Choco Branco",
        "Meio Meio Doce",
        "Mista Doce"
    };
    private String[] sabores = new String[]{
        "Calabresa",
        "4 Queijos",
        "Fricasse",
        "Marguerita"
    };
    private JComboBox jcbTamanhos = new JComboBox(tamanhos);
    private JComboBox jcbBordas = new JComboBox(bordas);
    private JComboBox jcbSabores = new JComboBox(sabores);
    private JButton btnAddSabor = new JButton("Adicionar Sabor");
    private ArrayList<String> arraySabores = new ArrayList<>();
    private DefaultListModel dlm = new DefaultListModel();
    private JList jlSabores = new JList(dlm);
    private JButton btnFinalizar = new JButton("Finalizar");
    //</editor-fold>

}
