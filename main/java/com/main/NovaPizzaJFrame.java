/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main;

import javax.swing.JFrame;

/**
 *
 * @author LessaInformatica
 */
public class NovaPizzaJFrame extends JFrame {

    public NovaPizzaJFrame(PizzasInfoGroupLayout pigl) {
        NovaPizzaGroupLayout npgl = new NovaPizzaGroupLayout(this.getContentPane(), pigl, this);
        setLayout(npgl);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
}
