/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hashings;
import java.util.*;
/**
 *
 * @author Arul
 */
class Node{
    public String word;
    public String definition;
   public Node next;
  
    public Node(String word, String definition)
    {
	this.word=word;
	this.definition=definition;
	this.next=null;
    }
}
public class SeperateChaining {
      int arraysize=27;
      Node head;
    public void insert(String word,String definition)
    {
	
    }
    public int findhashvalue(String word)
    {
	int hashval=0;
	for(int i=0;i<word.length();i++)
	{
	int charcode=word.charAt(i)-96;
	int temp=hashval;
	hashval=(temp*27+charcode)%arraysize;
	}
	return hashval;
    }
    public static void main(String[] arul)
    {
	SeperateChaining obj=new SeperateChaining();
	Node[] wordlist=new Node[27];
	for(int i=0;i<27;i++)
	{
	//    wordlist[i]=new Node();
	}
	System.out.println(obj.findhashvalue("arl"));
	System.out.println(obj.findhashvalue("arl"));
	System.out.println(obj.findhashvalue("arla"));
	System.out.println(obj.findhashvalue("arlb"));
	System.out.println(obj.findhashvalue("arlc"));
	
    }
}
