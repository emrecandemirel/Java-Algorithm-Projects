/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.emrecan_demirel_hw2;

/**
 *
 * @author Emre Can
 */
public class CommandLineRun {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int i =0;
        DataBase MyPersonList = new DataBase();
        while(args[i]=="x"  && args[i]=="X"){
            if (args[i]=="I"){
                MyPersonList.AddPerson(new Person(args[i]));
            }
            else if (args[i]==("F")){
                MyPersonList.AddFriend(args[i], args[i]);
            }
            else if (args[i]=="D"){
                 MyPersonList.DeletePerson(args[i]);
            }
            else if (args[i]=="P"){
                MyPersonList.OutputFriend(args[i]);
            }
            else if (args[i]=="W"){
                MyPersonList.MostPopular();
            }
            else if (args[i]=="O"){
                MyPersonList.OutputList();
            }
            else if (args[i]=="R"){
                
            }
            else{
                System.out.println("Wrong command!");
            }
            i++;
        }
        
    }
    
}
