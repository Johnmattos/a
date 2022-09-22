/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;

/**
 *
 * @author LessaInformatica
 */
public class NovoPedidoJInternalFrame extends JInternalFrame {

    public NovoPedidoJInternalFrame() {
        super("Menu Novo Pedido", true, true, true, true);
        JTabbedPane jtp = new JTabbedPane();
        //jtp.add("Pizzas", new NovaPizzaJPanel());
        jtp.add("Pizzas Info", new PizzasInfoJPanel());
        add(jtp);
        setSize(600, 400);
        setVisible(true);
    }

}
