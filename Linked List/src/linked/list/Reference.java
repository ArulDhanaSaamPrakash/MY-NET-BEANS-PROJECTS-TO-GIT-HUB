/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked.list;

/**
 *
 * @author Arul
 */
import java.io.*;
import java.util.Hashtable;
class Node1
{
    String data;
    Node1 next;
    Node1 (String x)
    {
        this.data=x;
        this.next=null;
    }
}
public class Reference {
     Node1 head;
    Node1 head1;
    public void insert1(String x)
    {
       Node1 newnode=new Node1(x);
        if(head1==null)
        {
            head1=newnode;
        }
        else
        {
            Node1 temp=head1;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
           temp.next=newnode;
        }  
    }
    public void insert(String x)
    {
        Node1 newnode=new Node1(x);
        if(head==null)
        {
            head=newnode;
        }
        else
        {
            Node1 temp=head;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
           temp.next=newnode;
        }
    }
    public void starter()
    {
        System.out.println(""+getIntersectionNode1(head,head1));
                
        
    }
    public Node1 getIntersectionNode1(Node1 A, Node1 B)
 {
	    Node1 lastA, lastB;
	    int countA, countB;
	    if (A == null || B == null)
	        return null;
	    countA = countB = 1;
	    lastA = A;
	    lastB = B;
	    
	    while (lastA.next != null)
           {
	        lastA = lastA.next;
	        countA++;
	    }
	    
	    while (lastB.next != null) 
            {
	        lastB = lastB.next;
	        countB++;
	    }
	    
	
	    
	    int diff = Math.abs(countA - countB);
	    
	    lastA = A;
	    lastB = B;
	    
	    if (countA > countB)
            {
	        while (diff-- > 0)
                {
	            lastA = lastA.next;
	        }
	    }
            else 
            {
	        while (diff-- > 0)
	            lastB = lastB.next;
	    }
	    
	    while (lastA!=null && lastB!=null)
            {
                if(lastA==lastB)
                    System.out.println("Hai gus");
                else
                {
                 System.out.println("Last A"+lastA);
                System.out.println("Last B"+lastB);
	        lastA = lastA.next;
	        lastB = lastB.next;   
                }
                    
	    }
	    
	    return lastA;
	    
	}
    public static void main(String[] arul)
    {
       Reference obj=new Reference();
       obj.insert("arul");
       obj.insert("dhana");
       obj.insert("saam");
       
       obj.insert1("sd");
       obj.insert1("dhana");
       obj.insert1("saam");
       obj.starter();
    }
    
}
