/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.emrecan_demirel_hw3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;



/**
 *
 * @author Emre Can
 */
public class HW3 implements HW3_Interface {
        static int dye;
        static int ROW;
        static int COL;
        
        /*static int Mm[][]={ {1,1,1,1,0,0,0,0,0,0,0,0,1,0},
                    {0,1,1,0,0,0,0,0,0,0,0,0,0,0},
                    {0,1,1,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,1,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,1,1,0,0,0,0},
                    {0,0,0,0,0,0,1,1,1,1,0,0,0,0},
                    {0,0,0,0,0,0,1,0,1,1,0,0,0,0},
                    {0,1,1,0,0,0,1,1,1,1,0,0,0,0},
                    {1,1,1,1,0,0,0,0,0,0,1,0,0,0},
                    {1,0,0,1,0,0,0,0,0,0,0,0,0,0},
                    {1,0,0,1,0,0,0,0,0,0,0,0,0,0},};*/
        
        static int M[][];
        
    @Override
    public void readshapefile(String path)throws Exception{
       
        Scanner sc = new Scanner(new BufferedReader(new FileReader(path)));
        int rows = 11;
        int columns = 14;
        M = new int[rows][columns];
        while(sc.hasNextLine()) {
         for (int i=0; i<M.length; i++) {
            String[] line = sc.nextLine().trim().split(" ");
            for (int j=0; j<line.length; j++) {
               M[i][j] = Integer.parseInt(line[j]);
            }
         }
      }
      
      
        ROW = M.length;
        COL = M[0].length;
        dye=2;
        for (int i = 0; i < ROW; i++)
        {
            for (int j = 0; j < COL; j++)
            {
                if (M[i][j] == 1)
                {
                    M[i][j] = dye;
                    Mover(M, i + 1, j, ROW, COL,dye);     //right
                    Mover(M, i - 1, j, ROW, COL,dye);     //left 
                    Mover(M, i, j + 1, ROW, COL,dye);     //upward
                    Mover(M, i, j - 1, ROW, COL,dye);     //downward
                    Mover(M, i + 1, j + 1, ROW, COL,dye); //right up corner
                    Mover(M, i - 1, j - 1, ROW, COL,dye); //left down corner
                    Mover(M, i + 1, j - 1, ROW, COL,dye); //rigt down corner
                    Mover(M, i - 1, j + 1, ROW, COL,dye); //left up corner
                    dye++;
                }
            }
        }
        
        
    }
    static void Mover(int[][] M, int i, int j, int ROW, int COL, int dye)
    {
         
       
        if (i < 0 || j < 0 || i > (ROW - 1) || j > (COL - 1) || M[i][j] != 1)
        {
            return;
        }
    
        if (M[i][j] == 1)
        {
            M[i][j] = dye;
            Mover(M, i + 1, j, ROW, COL,dye);     //right 
            Mover(M, i - 1, j, ROW, COL,dye);     //left 
            Mover(M, i, j + 1, ROW, COL,dye);     //up
            Mover(M, i, j - 1, ROW, COL,dye);     //down
            Mover(M, i + 1, j + 1, ROW, COL,dye); //right up corner
            Mover(M, i - 1, j - 1, ROW, COL,dye); //left down corner
            Mover(M, i + 1, j - 1, ROW, COL,dye); //right down corner
            Mover(M, i - 1, j + 1, ROW, COL,dye); //left up corner
        }
    }

    @Override
    public void outputshapes() {
        
        System.out.println("Total Shapes are :" + (dye-2));
        for (int k =2 ; k<dye;k++){
            System.out.println("Shape "+ (k-1));
        for (int i = 0; i < ROW; i++){
            for (int j = 0; j < COL; j++){
                if(M[i][j]==k){
                System.out.print("*");}
                else 
                    System.out.print(" ");
            }
                
        
        System.out.println("");}}
    }

    @Override
    public void outputshapestofile(String path) {
        //outputshapes();
        //Create File
        try {
        File myObj = new File(path);
         if (myObj.createNewFile()) {
         System.out.println("File created: " + myObj.getName());
          } else {
        System.out.println("File already exists.");
         }
        } catch (IOException e) {
          System.out.println("An error occurred.");
            e.printStackTrace();
    }
        // Write File
        try {
      FileWriter myWriter = new FileWriter(path);
      
      myWriter.write("Total Shapes are :" + (dye-2));
      myWriter.write("\n");
        for (int k =2 ; k<dye;k++){
            myWriter.write("Shape "+ (k-1)+"\n");
        for (int i = 0; i < ROW; i++){
            for (int j = 0; j < COL; j++){
                if(M[i][j]==k){
                myWriter.write("*");}
                else 
                    myWriter.write(" ");
            }
                
        
        myWriter.write("\n");}}
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
        
    }
public static void main(String[] args) throws Exception {
        
        
        
        HW3 runmatrix = new HW3();
        
        runmatrix.readshapefile("C:\\HW3\\HW3_Input.txt");
        runmatrix.outputshapes();
        runmatrix.outputshapestofile("C:\\HW3\\HW3_Output.txt");
    }

    
  
    
    
}
