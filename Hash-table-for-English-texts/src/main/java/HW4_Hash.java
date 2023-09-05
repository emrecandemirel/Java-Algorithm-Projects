
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Emre Can
 */
public class HW4_Hash implements HW4_Interface{
    
    static String M[];
    DoublyLinkedListNode[] hashTable;
    DoublyLinkedListNode[] orderedhashTable;
    static int size;
    static int collusion;
    static int Totalword;
    static int TotalRepated;
       
        static boolean isPrime(int n)
	{
		if (n <= 1) return false;
		if (n <= 3) return true;
		if (n % 2 == 0 || n % 3 == 0) return false;
		for (int i = 5; i * i <= n; i = i + 6)
			if (n % i == 0 || n % (i + 2) == 0)
			return false;
		return true;
	}
	static int nextPrime(int N)
	{
		if (N <= 1)
			return 2;
		int prime = N;
		boolean found = false;
		while (!found)
		{
			prime++;
	
			if (isPrime(prime))
				found = true;
		}
	
		return prime;
	}
        static int prePrime(int N)
	{
		if (N <= 1)
			return 2;
		int prime = N;
		boolean found = false;
	
		while (!found)
		{
			prime--;
	
			if (isPrime(prime))
				found = true;
		}
	
		return prime;
	}
    
    
    @Override
    public Integer GetHash(String mystring) {
     //int prime1 =prePrime(size);
     int prime2 =nextPrime(size);
     //System.out.println(prime1+" "+prime2);
     char ch[];
     ch = mystring.toCharArray();
     int xlength = mystring.length();

     int i, sum;
     for (sum=0, i=0; i < mystring.length(); i++) {
       sum += ch[i];
     }
     return sum*prime2 % size;
        
        
        
    }
   
    @Override
    public void ReadFileandGenerateHash(String filename, int size) {
        
        try {
  Scanner s = new Scanner(new File(filename));
  M= new String [10000];
  collusion=0;
  Totalword=0;
  TotalRepated=0;
  int position;
  this.size=prePrime(size);
  int location=0;
  hashTable = new DoublyLinkedListNode[prePrime(size)];
  
  while (s.hasNext()) {
    M[location]=s.next();
    M[location] = M[location].replaceAll("\\p{Punct}","");
    M[location]=M[location].toLowerCase();
    position = GetHash(M[location]);
    DoublyLinkedListNode node = new DoublyLinkedListNode(M[location],location);
    DoublyLinkedListNode start = hashTable[position];
    DoublyLinkedListNode control = hashTable[position];
    
    if (hashTable[position]==null){
        hashTable[position] = node;
        Totalword++;
    }
    else {
      boolean cw =control.data.equals(M[location]);
      while (control != null && !cw ) {
                                //System.out.println(control.data+M[location]);
				control = control.next;}
      if(control!=null){
      if(control.data!=M[location]){
                                hashTable[position].repeated++;
                                TotalRepated++;
                                }
      
      }
      else{
        node.next = start;
        start.prev =node;
        hashTable[position]=node;
        collusion++;
        Totalword++;
    }
        
    }
    
    //System.out.println(position);
    location++;
  }
  
  
} catch (IOException e) {
  System.out.println("Error accessing input file!");
}
        

          }

    @Override
    public void DisplayResult(String Outputfile) {
        
        
        try {
        File myObj = new File(Outputfile);
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
      FileWriter myWriter = new FileWriter(Outputfile);
      
      
      for (int i = 0; i < hashTable.length; i++) {
			myWriter.write("At " + i + ": ");

			DoublyLinkedListNode start = hashTable[i];

			while (start != null) {
				myWriter.write(start.data + " Repeated:" +start.repeated+" Location:"+start.location);
				start = start.next;
			}

			myWriter.write("\n");
		}
      
      
      
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
        
        
        
         }

    @Override
    public void DisplayResult() {
        System.out.println();
		for (int i = 0; i < hashTable.length; i++) {
			System.out.print("At " + i + ": ");

			DoublyLinkedListNode start = hashTable[i];

			while (start != null) {
				System.out.print(start.data + " Repeated:" +start.repeated+" Location:"+start.location);
				start = start.next;
			}

			System.out.println();
		}
        
        
           }

    @Override
    public void DisplayResultOrdered(String Outputfile) {
        try {
        File myObj = new File(Outputfile);
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
      FileWriter myWriter = new FileWriter(Outputfile);
      
      orderedhashTable = new DoublyLinkedListNode[Totalword];
      int j=0;
      for (int i = 0; i < hashTable.length; i++) {
			DoublyLinkedListNode start = hashTable[i];
                        //orderedhashTable[j]=start;
			while (start != null) {
                                orderedhashTable[j]=start;
                                
				start = start.next; 
                                
                                j++;
			}	
		}
     
     DoublyLinkedListNode temp;  
          
         
     /*int current=0,index=0;     
            while(k<=orderedhashTable.length&&orderedhashTable[k]!=null) {  
                 
                orderedhashTable[index] = orderedhashTable[current].next;  
                  
                while(m<=orderedhashTable.length&&orderedhashTable[index]!=null ) {  
                    
                    if(orderedhashTable[current]!=null&&orderedhashTable[index]!=null){
                    if(orderedhashTable[current].repeated > orderedhashTable[index].repeated) {  
                        temp = orderedhashTable[current];  
                        orderedhashTable[current] = orderedhashTable[index];  
                        orderedhashTable[index] = temp;  
                    } } 
                    index++;
                    //index = index.next;  
                } 
                current++;
                //current = current.next;  
            }   */   
        
    for (int i = 0; i < orderedhashTable.length; i++) {
			myWriter.write("At " + i + ": ");
                        
			DoublyLinkedListNode writ = orderedhashTable[i];
                        
			while (writ != null) {
				System.out.println(writ.data + " Repeated:" +writ.repeated+" Location:"+writ.location);
                                myWriter.write(writ.data + " Repeated:" +writ.repeated+" Location:"+writ.location);
				writ = writ.next;
			}

			myWriter.write("\n");
		}  
      
      
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } }

    @Override
    public int showFrequency(String myword) {
       int hashkey = GetHash(myword);
        DoublyLinkedListNode checks = new DoublyLinkedListNode(myword,0);
        DoublyLinkedListNode start = hashTable[hashkey];
       	
        {while (start != null) {
            //System.out.println("1"+start.data);
            //System.out.println(checks.data);
                                if(start.data.equals(myword)){
				System.out.println("'"+start.data + "' is found " +/*start.location+*/" and number of occurrences is "+start.repeated);
                                return 1;
                                }
                                
				start = start.next;
			}
        System.out.println("There is no "+myword+" in hashtable");
            return 0;
        }}
    
    @Override
    public String showMaxRepeatedWord() {
        int max=0;
        //int count=0;
        DoublyLinkedListNode MAXnode=null;
        
        for (int i = 0; i < hashTable.length; i++) {
			DoublyLinkedListNode start = hashTable[i];

			while (start != null) {
                                //System.out.println(start.repeated+" - "+max);
				if(start.repeated>=max){
                                    MAXnode=start;
                                    max=start.repeated;
                                    //System.out.println(MAXnode.repeated+" "+count);
                                    //count++;
                                }
                                
				start = start.next;
			}
         }
        System.out.println(MAXnode.data + " is most frequent word " +MAXnode.repeated+" times repeated");
        return MAXnode.data;
    }

    @Override
    public int checkWord(String myword) {
        int hashkey = GetHash(myword);
        DoublyLinkedListNode checks = new DoublyLinkedListNode(myword,0);
        DoublyLinkedListNode start = hashTable[hashkey];
       	
        {while (start != null) {
            //System.out.println("1"+start.data);
            //System.out.println(checks.data);
                                if(start.data.equals(myword)){
				System.out.println("'"+start.data + "' is found in location " +start.location/*+" and number of occurrences is "+start.repeated*/);
                                return 1;
                                }
                                
				start = start.next;
			}
        System.out.println("There is no "+myword+" in hashtable");
            return 0;
        }
        
        }
   
    @Override
    public float TestEfficiency() {
        
        float eff=0 ;
        float eff2=0;
        int counter=0;
        for (int i = 0; i < hashTable.length; i++) {
			if(hashTable[i]!=null){
                            counter++;
                        }
        }
        int nullcounter=0;
            for (int i = 0; i < hashTable.length; i++) {
			if(hashTable[i]==null){
                            nullcounter++;
                        }
                        
                        
        if (Totalword<counter+nullcounter){
        eff=counter;
        int mosteff=Totalword;
        eff/=mosteff;
        
        eff = eff*100;
        
        }
        else{
            
              eff=counter;
              eff/=nullcounter+counter;
              eff = eff*100;
        }
            
            
        }
        
        System.out.println("The Efficency:"+ eff+"%");
        return eff;
    }
    
    @Override
    public int NumberOfCollusion() {
        System.out.println("There are "+collusion+" collusions occurred. "+Totalword);
        return collusion;
        
    }
  

    
}
class DoublyLinkedListNode {
	
	DoublyLinkedListNode next, prev;
	String data;
        int repeated;
	int location;
        int ExtraLocations[];
	DoublyLinkedListNode(String data, int location)
	{
		this.data = data;
		next = null;
		prev = null;
                repeated=1;
                this.location=location;
	}

   
    }

class Locations{
    int loc;
}