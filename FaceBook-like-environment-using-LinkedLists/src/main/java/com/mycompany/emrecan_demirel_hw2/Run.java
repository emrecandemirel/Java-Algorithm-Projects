/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.emrecan_demirel_hw2;

/**
 *
 * @author Emre Can
 */
public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DataBase MyPersonList = new DataBase();
       
     
        MyPersonList.AddPerson(new Person("Ali"));
        MyPersonList.AddPerson(new Person("Veli"));
        MyPersonList.AddPerson(new Person("Lutfullah"));
        MyPersonList.AddPerson(new Person("Cevziye"));
        MyPersonList.AddPerson(new Person("Ali"));
        MyPersonList.OutputList();
        MyPersonList.DeletePerson("Ali");
        MyPersonList.AddPerson(new Person("Hulki"));
        MyPersonList.AddPerson(new Person("Hulki"));
        MyPersonList.AddPerson(new Person("Hulki"));
        MyPersonList.OutputList();
        MyPersonList.AddFriend("Ali", "Hulki");
        MyPersonList.AddFriend("Cevziye", "Lutfullah");
        MyPersonList.AddFriend("Cevziye", "Lutfullah");
        MyPersonList.AddFriend("Veli", "Lutfullah");
        MyPersonList.AddFriend("Veli", "Cevziye");
        MyPersonList.DeletePerson("Cevziye");
        MyPersonList.DeletePerson("Lütfullah");
        MyPersonList.AddFriend("Hulki", "Cevziye");
        MyPersonList.OutputFriend("Ali");
        MyPersonList.OutputFriend("Lutfullah");
        MyPersonList.OutputFriend("Veli");
        MyPersonList.OutputFriend("Cevziye");
        MyPersonList.OutputFriend("Hulki");
        MyPersonList.MostPopular();
        MyPersonList.OutputList();
        //exit 
        MyPersonList.SearchName("Hulki").toString();
    }
    
}


