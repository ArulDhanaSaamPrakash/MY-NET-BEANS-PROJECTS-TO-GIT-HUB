/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codings;
import java.util.*;

/**
 *
 * @author Arul
 */
public class Palindrome {
    public static void main(String[] arul)
    {
	Scanner in=new Scanner(System.in);
	System.out.println("Enter the string");
	String a=in.next();
	int j=1;
	int f=0;
	int mid=(a.length()-1)/2;
	
	for(int i=0;i<=mid;i++)
	{
	    if(a.charAt(i)!=a.charAt(a.length()-j))
	    {
		f=1;
		break;
	    }
	    j++;
	    
	}
	if(f!=1)
	{
	    System.out.println("It is a palindrome");
	}
	else
	{
	    System.out.println("It is not a palindrome");
	}
    }
    
}
