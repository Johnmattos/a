/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main;

import java.util.ArrayList;

/**
 *
 * @author LessaInformatica
 */ 
class PizzaData {

    private final String tamanho;
    private final String borda;
    private final ArrayList<String> sabores = new ArrayList<>();

    public PizzaData(String tamanho, String borda) {
        this.tamanho = tamanho;
        this.borda = borda;
    }
    
    public void addSabor(String sabor){
        sabores.add(sabor);
    }

    public String getTamanho() {
        return tamanho;
    }

    public String getBorda() {
        return borda;
    }

    public ArrayList<String> getSabores() {
        return sabores;
    }

}
