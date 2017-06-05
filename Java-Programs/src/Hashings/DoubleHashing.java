/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hashings;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author Arul
 */
public class DoubleHashing {
    String[] tohash;
    String[] a={"500","29","1","370","256","59","9","89","11","68"};
    public void hashSize(int size)
    {
	tohash=new String[size];
	Arrays.fill(tohash, "-1");
	insertelement(a,tohash);	
    }
    public boolean isprime(int n)
    {
	if(n%2==0)
	{
	    return false;
	}
	for(int i=3;i*i<=n;i+=2)
	{
	    if(n%i==0)
	    {
		return false;
	    }
	}
	return true;
    }
    public int nextprime(int minimum)
    {
	for(int i=minimum;true;i++)
	{
	    if(isprime(i))
		    {
			return i;
		    }
	}
    }
    public void increaseArraysize(int oldsize)
    {
	int newsize=nextprime(oldsize);
	String[] cleanarray=this.clearemptyarray(tohash);
	this.tohash=new String[newsize];
	Arrays.fill(tohash,"-1");
	insertelement1(cleanarray,tohash);
	System.out.print("asss");
	
    }
    public String[] clearemptyarray(String[] tohash)
    {
	ArrayList<String> StringList=new ArrayList<String>();
	for(String element: tohash)
	{
	    if(!element.equals("-1") && !element.equals(" "))
	    {
		StringList.add(element);
	    }
	}
	return StringList.toArray(new String[StringList.size()]);
    }
    public void insertelement(String[] a,String[] tohash)
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
	//this.display();
    }
     public void insertelement1(String[] a,String[] tohash)
    {
	int hashindex;
	for(int i=0;i<a.length;i++)
	{
	    String element_to_be_inserted=a[i];
	    hashindex=Integer.parseInt(element_to_be_inserted)%67;
	    int steps=7-(Integer.parseInt(element_to_be_inserted)% 7);
	    while(tohash[hashindex]!="-1")
	    {
		hashindex+=steps;
		hashindex=hashindex%67;
		
	    }
	    tohash[hashindex]=element_to_be_inserted;
	}
	//this.display();
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
    public void find2(String key)
    {
      int hashindex=Integer.parseInt(key)%67;
      int steps=7-(Integer.parseInt(key)% 7);
      while(tohash[hashindex]!="-1")
      {
	  if(tohash[hashindex].equals(key))
	  {
	      System.out.println("ELelment found at index +"+hashindex);
	  }
	  hashindex+=steps;
	  hashindex=hashindex%67;
      }
    }
    public static void main(String[] arul)
    {
	DoubleHashing obj=new DoubleHashing();
	int size=30;
	obj.hashSize(size);
	obj.display();
	obj.find("89");
	System.out.println("\n\n");
	obj.increaseArraysize(65);
	obj.display();
	obj.find2("68");
	
    } 
}
