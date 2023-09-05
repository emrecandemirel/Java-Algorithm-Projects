/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.emrecan_demirel_hw2;

/**
 *
 * @author Emre Can
 */
public class Person extends Friends {
    private String Name; 
    private Integer HitCount; 
    public Friends FriendList; 
    public Person nextPerson;
    
    public Person(String n){ 
     Name = n; 
     HitCount = 1; 
     FriendList = null; 
 } 
    public void ContentOut(){ 
        System.out.print( Name); 
        System.out.println("  Hitcount :" + HitCount); 
 } 
    public void SetName(String nName){ 
        Name = nName; 
 } 
    public void IncreaseHit(){ 
        HitCount++; 
 } 
    public String GetName(){ 
        return Name; 
 } 
    public Integer GetHitCount(){ 
        return HitCount; 
 }
}