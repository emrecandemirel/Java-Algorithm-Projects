/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.emrecan_demirel_hw1;

/**
 *
 * @author Emre Can
 */
public class cMatrix {
private long [][] elements; // Keeps the elements of matrix in two dimensional array
private int row; // row size
private int col; // column size
public cMatrix(){ // Constructor generate matrix of size 10x10
    this.row=10;
    this.col=10;
    elements = new long[row][col];
 }

public cMatrix(int row, int col){ //Constructor
    this.row=row;
    this.col=col;
    elements = new long[row][col];
 }
public void AssignRandom(){ //Assigning random variables in range 1 - 10000
    
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                elements[i][j] = (long) (Math.random()*10000+1);
       
 }
public void printMatrix(){ // Printing matrix in matrix form
    
    for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                System.out.print(elements[i][j]);
                System.out.print(" ");}
            System.out.println();}
 }
public void printMatrixWithPrime(){ //Prints the matrix with “*” sign near the prime elements
    
    for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                System.out.print(elements[i][j]);
                boolean flag = false;
                    for (int h = 2; h <= (elements[i][j]) / 2; ++h) {
                            // condition for nonprime number
                                if ((elements[i][j]) % h == 0) {
                                    flag = true;
                    break;
                                                               }
                                                                    }
                     if (!flag)
                        System.out.print("*");
                    
                    System.out.print(" ");
                    }    
                System.out.println();
                }
            }
public cMatrix multiplyMatrices(cMatrix Multiplicand){ // Multiply two matrices and informs the user about time lapse
        long start = System.currentTimeMillis();
        cMatrix A = this;
        if (A.row != Multiplicand.col) throw new RuntimeException("Illegal matrix dimensions.");
        cMatrix C = new cMatrix(A.row, Multiplicand.col);
        for (int i = 0; i < C.row; i++)
            for (int j = 0; j < C.col; j++)
                for (int k = 0; k < A.col; k++)
                    C.elements[i][j] += (A.elements[i][k] * Multiplicand.elements[k][j]);
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("The duration of multiplication of matrices "+(A.row)+"X"+(A.col)+"*"+(Multiplicand.row)+"X"+(Multiplicand.col)+" "+ timeElapsed+" miliseconds");
        
        return C;
     
 } 

 }




    