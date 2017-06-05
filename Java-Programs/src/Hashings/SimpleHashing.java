/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hashings;
import java.util.Arrays;
/**
 *
 * @author Arul
 */
public class SimpleHashing {
    String[] tohash;
    String[] a={"500","29","1","370","256","59","9","89"};
    public void hashSize(int size)
    {
	tohash=new String[size];
	Arrays.fill(tohash, "-1");
	insertelement();	
    }
    public void insertelement()
    {
	int hashindex;
	for(int i=0;i<a.length;i++)
	{
	    String element_to_be_inserted=a[i];
	    hashindex=Integer.parseInt(element_to_be_inserted)%29;
	    while(tohash[hashindex]!="-1")
	    {
		++hashindex;
		hashindex=hashindex%29;
		
	    }
	    tohash[hashindex]=element_to_be_inserted;
	}
	display();
    }
    public void display()
    {
	for(int i=0;i<tohash.length;i++)
	{
	    System.out.println("Index is "+i+" and the key stored is "+tohash[i] );
	}
    }
    public void find(String key)
    {
      int hashindex=Integer.parseInt(key)%29;
      while(tohash[hashindex]!="-1")
      {
	  if(tohash[hashindex].equals(key))
	  {
	      System.out.println("ELelment found at index +"+hashindex);
	  }
	  ++hashindex;
	  hashindex=hashindex%29;
      }
    }
    public static void main(String[] arul)
    {
	SimpleHashing obj=new SimpleHashing();
	int size=30;
	obj.hashSize(size);
	obj.find("89");
	
    }
    
    
}
