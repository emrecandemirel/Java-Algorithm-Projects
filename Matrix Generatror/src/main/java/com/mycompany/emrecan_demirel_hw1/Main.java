/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.emrecan_demirel_hw1;

/**
 *
 * @author Emre Can
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 // TODO code application logic here
 int c=20;
 cMatrix m2 = new cMatrix(c,c);
 m2.AssignRandom();
 cMatrix m3 = new cMatrix(c,c);
 m3.AssignRandom();
 cMatrix m4 = new cMatrix();
 m4 = m2.multiplyMatrices(m3);
} 
    
}
