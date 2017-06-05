/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoubleLinkedList;
import static java.lang.System.exit;
import java.util.*;
import java.io.*;
/**
 *
 * @author Arul
 */
public class DoubleLinkedList {
    Node head;
    public void insertbegin(int x)
    {
	Node newnode=new Node(x);
	if(head==null)
	{
	    head=newnode;
	}
	else
	{
	    head.prev=newnode;
	    newnode.next=head;
	    head=newnode;
	}
    }
    public void display()
    {
	if(head==null)
	{
	    System.out.println("No linked list to sisplay");
	}
	else
	{
	   Node temp;
	   temp=head;
	   System.out.println("Linked List is: ");
	   while(temp!=null)
	   {
	       System.out.print(temp.x+"->");
	       temp=temp.next;
	   }
	}
	System.out.println("\nLength is"+length());
    }
    public void insertend(int x)
    {
	Node newnode=new Node(x);
	if(head==null)
	{
	    System.out.println("Since no element is present a element is inserted in the begining");
	    insertbegin(x);
	}
	else
	{
	    Node temp;
	    temp=head;
	    while(temp!=null)
	    {
		if(temp.next!=null)
		{
		    temp=temp.next;
		}
		else
		{
		    temp.next=newnode;
		    newnode.prev=temp;
		    System.out.println("An element is inserted at the end");
		    break;
		}
	    }
	}
	
	
    }
    public int length()
    {
	int len=0;
	if(head==null)
	{
	    return 0;
	}
	else
	{
	    Node temp=head;
	    while(temp!=null)
	    {
		len++;
		temp=temp.next;
	    }
	}
	return len;
    }
    public void insertmiddle(int x)
    {
	System.out.println("Enter the position after which u want to insert");
	Scanner in=new Scanner(System.in);
	int pos=in.nextInt();
	
	Node newnode=new Node(x);
	int c=1;
	System.out.println(length());
	if(pos<length() && pos!=0)
	{
	    Node temp=head;
	    while(temp!=null)
	    {
		if(pos==c)
		{
		    temp.next.prev=newnode;
		    newnode.next=temp.next;
		    temp.next=newnode;
		    newnode.prev=temp;
		    break;
		}
		else
		{
		    c++;
		    temp=temp.next;
		}
	    }
	    
	}
	else
	{
	    System.out.println("No linked list elemnet is present in that position");
	}
    }
    public void deletebegin()
    {
	if(head==null)
	{
	    System.out.println("cant b deleted");
	}
	else
	{
	    if(head.next==null)
	    {
		head=null;
	    }
	    else
	    {
	    head=head.next;
	    head.prev=null;
	    }
	}
    }
    public void deleteend()
    {
	if(head==null || head.next==null)
	{
	    deletebegin();
	}
	else
	{
	    Node temp=head;
	    while(temp!=null)
	    {
		if(temp.next.next==null)
		{
		   temp.next=null;
		   break;
		}
		else
		{
		    temp=temp.next;
		}
		
	    }
	}
    }
    public void deletemid()
    {
	Scanner in=new Scanner(System.in);
	System.out.println("Enter the position after which u want to delete");
	int pos=in.nextInt();
	int counter=1;
	if(pos<length())
	{
	    if(pos==1)
	    {
		deletebegin();
	    }
	    else
	    {
		Node temp=head;
		while(temp!=null)
		{
		    if(pos==counter)
		    {
			temp.next.next.prev=temp;
			temp.next=temp.next.next;
			break;
		    }
		    else
		    {
			counter++;
			temp=temp.next;
		    }
		}
	    }
	}
	else if(pos==length())
	{
	    deleteend();
	    
	}
	else
	{
	    System.out.println("That position has no element in linked list");
	}
    }
    public void sort()
    {
	head=MergesortListBreakdown(head);
	System.out.println("The sorted List is");
	display();
    }
    public Node MergesortListBreakdown(Node startnode)
    {
	if(startnode==null || startnode.next==null)
	{
	    return startnode;
	}
	Node middle=getmiddle(startnode);
	Node nextofmiddle=middle.next;
	nextofmiddle.prev=null;
	middle.next=null;
	
	Node left=MergesortListBreakdown(startnode);
	Node right=MergesortListBreakdown(nextofmiddle);
	
	Node sortedlist=merge(left,right);
	
	return sortedlist;
    }
    public Node merge(Node left,Node right)
    {
	if(left==null)
	{
	    return right;
	}
	if(right==null)
	{
	    return left;
	}
	Node temp;
	if(left.x<right.x)
	{
	    temp=left;
	    temp.next=merge(left.next,right);
	}
	else
	{
	    temp=right;
	    temp.next=merge(right.next,left);
	}
	
	return temp;
    }
    
    public Node getmiddle(Node startnode)
    {
	if(startnode==null)
	{
	    return startnode;
	}
	Node pointer1=startnode;
	Node pointer2=startnode;
	
	if(pointer2!=null && pointer2.next!=null && pointer2.next.next!=null)
	{
	    pointer1=pointer1.next;
	    pointer2=pointer2.next.next;
	}
	return pointer1;
    }
    public static void main(String[] arul)
    {
	Scanner in=new Scanner(System.in);
	int ch;
		int num;
	DoubleLinkedList dl=new DoubleLinkedList();
	while(1==1)
	{
	System.out.println("\n 1.Insert Begin\n 2.Insert middle\n 3.Insert end\n 4.Delete begin\n 5.Delete mid\n 6.Delete end\n 7.Display\n 8.Sort");
	ch=in.nextInt();
	switch(ch)
	{
	    case 1:
	
		System.out.println("Enter the number to be inserted");
		num=in.nextInt();
		dl.insertbegin(num);
		break;
	    case 2:
		System.out.println("Enter the number to be inserted");
		num=in.nextInt();
		dl.insertmiddle(num);
		break;
		
	    case 3:
		//int num;
		System.out.println("Enter the number to be inserted");
		num=in.nextInt();
		dl.insertend(num);
		break;
	    case 4:
		dl.deletebegin();;
		break;
	    case 5:
		dl.deletemid();;
		break;
	    case 6:
		dl.deleteend();;
		break;
	    case 7:
		dl.display();
		break;
	    case 8:
		dl.sort();
		break;
		
	    default:
		exit(0);
		
	}
	}
    }
    
}
