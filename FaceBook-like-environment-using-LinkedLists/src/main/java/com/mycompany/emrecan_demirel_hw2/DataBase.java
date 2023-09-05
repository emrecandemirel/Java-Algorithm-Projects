/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.emrecan_demirel_hw2;

/**
 *
 * @author Emre Can
 */
public class DataBase implements DataBaseInterface {
    
    public Person peopleList; 
    
	//Constructor:
	public DataBase() {
	peopleList = null;
	}
    
    @Override
    public Person SearchName(String tName) {
        Person SPerson = new Person(tName);
        Person last = null;
	Person point = peopleList;
        if (point == null) {
		return null;
		}
	while (point != null && point.GetName() != tName) {
                
		last = point;
		point = point.nextPerson;
                
	}
	if (point != null) {
		if (point == peopleList) {
                return peopleList;   
		
		}
		else {
                return point;
		
		}
	}
        
        
		return null;
        
    }

    @Override
    public void OutputList() {
        Person cool = peopleList;
	
	if (peopleList == null) {
		System.out.println("Database is empty, add people and try again");
	}   
	else {
		while (cool != null) {
		cool.ContentOut();
		cool = cool.nextPerson;		   
		}
	}
	
        }
    

    @Override
    public boolean AddPerson(Person tNewPerson) {
        
        
	
        if (peopleList == null) {
		peopleList = tNewPerson;
                
	}
        else if(SearchName(tNewPerson.GetName())!= null){
            SearchName(tNewPerson.GetName()).IncreaseHit();
        }
	
	else {
		tNewPerson.nextPerson = peopleList;
		peopleList = tNewPerson;	
	}
	
        
            return true; 
    }

    @Override
    public boolean DeletePerson(String pName) {
        if (peopleList == null) {
		System.out.println("Database is empty, add people and try again");
                return false;
                } 
        if (SearchName(pName)==null){
            System.out.println(pName + " is not in DataBase so can’t be deleted");
            return false;
        }
        //to delete
        Person deletePerson = new Person(pName);
        Person last = null;
	Person kill = peopleList;
        //to check
        Friends dPerson= new Person(pName);
        Friends exist =isFriendd(dPerson);
        if (exist!= null ) {
            System.out.println(pName+" can’t be deleted "+pName+ " is Friend of "+exist.GetName());
                return false;	
        }
        else{
	while (kill != null && kill.GetName() != pName) {
		last = kill;
		kill = kill.nextPerson;
	}
	if (kill != null) {
		if (kill == peopleList) {
		peopleList = peopleList.nextPerson;
                System.out.println(kill.GetName()+" is deleted");
		}
		else {
                System.out.println(kill.GetName()+" is deleted");    
		last.nextPerson = kill.nextPerson;
		}
	}
        }
        
         return true;
    }

    @Override
    public String toString(){
        String ListFriend=null;
        Person Listfr= SearchName(ListFriend);
        if (Listfr==null){
            System.out.println(ListFriend+" is not in Database");
            return ListFriend+" is not in Database";
        }
        else{
            if(Listfr.FriendList==null){
                return ListFriend+" has no friend";
            }
            else{
                while(Listfr.FriendList!=null){
                    System.out.println(Listfr.FriendList.GetName());
                    Listfr.FriendList=Listfr.FriendList.getNext();
                }
            }
        return null;
        
    }
    }
    
    @Override
    public boolean AddFriend(String Name1, String Name2) {
        Person self = SearchName(Name1);
        if(self == null){
            System.out.println(Name1+" is not in database they can’t be friend ");
            return false;
        }
        
	Friends other = SearchName(Name2);
         if(other == null){
            System.out.println(Name2+" is not in database they can’t be friend ");
            return false;
        }
         
        //Chekcking friendlist  
        Friends exist = null;
        exist=isFriend(self,other);
            
		
		if (self.FriendList == null) {
		self.FriendList = (Friends) other; 
                self.IncreaseHit();
                System.out.println(Name2+" is friend of "+ Name1);
		}
                else if (exist != null) {
		System.out.println("No need to add");   
                return false;
                }
		else {
                    other.next = self.FriendList;
                    self.FriendList = other;
                    self.IncreaseHit();
                System.out.println(Name2+" is friend of "+ Name1);
		}
    return true; 
    }

    public void MostPopular (){
        Integer Most=0;
        Person Mozt= peopleList;
        Person pp = peopleList;
        //Most HitCount finder
        while (pp!=null){
            if(pp.GetHitCount()>Most){
                Most = pp.GetHitCount();
                Mozt = pp;
            }
            pp=pp.nextPerson;
        }
        //Most Friend Finder
        /*int i=0;
        int maxi=0;
        Person ff = peopleList;
        Person MostFriend =peopleList;
        while (ff!=null){
            while(ff.FriendList!= null){
                i+=1;
                ff.FriendList=ff.FriendList.getNext();
            }
            
        
            if(maxi<i){
                maxi = i;
                MostFriend = ff;
            }
            ff=ff.nextPerson;
        }
        if(Most>maxi){*/
        System.out.println("Most popular person is "+Mozt.GetName());
        /*}
        else{
            System.out.println("Most popular person is "+MostFriend.GetName());
            
            
        }*/
    }
    
    public boolean OutputFriend(String ListFriend) {
        Person Listfr= SearchName(ListFriend);
        
        if (Listfr==null){
            System.out.println(ListFriend+" is not in Database");
            return false;
        }
        else{
            if(Listfr.FriendList==null){
                System.out.println(ListFriend+" has no friend");
                return true;
            }
            else{System.out.println();  
                System.out.print(ListFriend+ " friends are");
                while(Listfr.FriendList!=null){
                    System.out.print(" "+Listfr.FriendList.GetName());
                    Listfr.FriendList=Listfr.FriendList.next;
                }
                System.out.println();
            }
        }
	return true;
        }
    
    
    public Friends isFriend(Person control,Friends target){
        Friends sonuc =null;
        Friends List=control.FriendList;
        while(List!=null){
            if(List==target){
                sonuc=List;
            }
            List=List.getNext();
        }
        return sonuc;
    }
    public Person isFriendd(Friends target){
        Person sonuc=null;
        Friends t = target;
        Person ListP=peopleList;
        Friends ListF=ListP.FriendList;
        while(ListP!=null){
            while(ListF!=null){
            if(ListF==t){
                sonuc=ListP;
                System.out.println(ListP.GetName());
            }
            //System.out.println("iç "+ListF.GetName());
            ListF=ListF.getNext();
        }
            //System.out.println("dış "+ListP.GetName());
            ListP=ListP.nextPerson;
        }
            return sonuc;
    }
}
