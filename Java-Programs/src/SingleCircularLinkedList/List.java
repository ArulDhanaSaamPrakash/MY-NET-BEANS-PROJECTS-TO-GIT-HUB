/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SingleCircularLinkedList;
import java.util.*;
import static java.lang.System.exit;
/**
 *
 * @author Arul
 */
public class List {
    Node head;
    public void insertbegin(int x)
    {
	Node newnode=new Node(x);
	if(head==null)
	{
	    System.out.println("i am here");
	    newnode.next=newnode;
	    head=newnode;  
	}
	else
	{   
	   Node temp=head;
	   newnode.next=head;
	   while(temp!=null && temp.next!=head)
	   {
	       temp=temp.next;
	   }
	   temp.next=newnode;
	   head=newnode;
	   
	}
    }
    public void display()
    {
	System.out.println("\nElements of linked list are:");
	Node temp=head;
	while(temp!=null &&  temp.next!=head)
	{
	    System.out.print(temp.x+"->");
	    temp=temp.next;
	}
	if(head!=null)
	{
	System.out.print(temp.x);
	}
    }
    public void insertend(int x)
    {
	Node newnode=new Node(x);
	Node temp=head;
	if(head==null)
	{
	    insertbegin(x);
	}
	else
	{
	    returnlast().next=newnode;
	    newnode.next=head;
	}
	
    }
    public Node returnlast()
    {
	Node temp=head;
	while(temp!=null && temp.next!=head)
	{
	    temp=temp.next;
	}
	return temp;
    }
    public void insertmiddle(int x)
    {
	Node newnode=new Node(x);
	int pos;
	Scanner in=new Scanner(System.in);
	
	Node temp=head;
	if(head==null)
	{
	    insertbegin(x);
	}
	System.out.println("Enter the position after which u want to insert");
	pos=in.nextInt();
	int counter=1;
	while(temp!=null)
	{
	   if(pos==counter)
	   {
	       newnode.next=temp.next;
	       temp.next=newnode;
	       break;
	   }
	    else
	   {
	       counter++;
	   }
	   temp=temp.next;
	}
    }
    public void deletebegin()
    {
	if(head==null)
	{
	    System.out.println("no element in linked list");
	}
	else if(head.next==head)
	{
	    head=null;
	}
	else
	{
	Node temp=returnlast();
	head=head.next;
	temp.next=temp.next.next;
	}
    }
    public void deleteend()
    {
	Node temp=returnlast();
	Node temp1=head;
	int flag=0;
	if(head==null)
	{flag=1;
	    System.out.println("no linkded list to delete");
	}
	 if(flag!=1)
	     if(temp1.next==temp1)
	    {
		System.out.println("e");
		head=null;
		//break;
	    }
	while(temp1!=null)
	{
	    if(temp1.next==temp)
	    {
		temp1.next=temp1.next.next;
		break;
	    }
	   
	    temp1=temp1.next;
	}
    }
    public int length()
    {
	Node temp=head;
	int len=1;
	while(temp!=null && temp.next!=head)
	{
	    len++;
	    temp=temp.next;
	}
	return len;
    }
    public void deletemiddle()
    {
	Scanner in=new Scanner(System.in);
	System.out.println("Enter a position after which u want to delete");
	int pos=in.nextInt();
	int counter=1;
	Node temp=head;
	if(pos==1)
	{
	    deletebegin();
	}
	else if(pos==length())
	{
	    deleteend();
	}
	else if(pos%length()==0 && pos>length())
	{
	    deletebegin();
	}
	else
	{
	while(temp!=null)
	{
	    if(pos==counter)
	    {
		temp.next=temp.next.next;
		break;
	    }
	    counter++;
	    temp=temp.next;
	}
	}
    }
    public static void main(String[] arul)
    {
	Scanner in=new Scanner(System.in);
	List l=new List();
	int ch;
	int x;
	while(1==1)
	{
	    System.out.println("\n1. Insert Begin \n2. Insert Middle\n3. Insert End\n4. Delete begin \n5. Delete middle \n6. Delete end\n7. Display");
	    ch=in.nextInt();
	    switch(ch)
	    {
		case 1:
		    System.out.println("Type an element to be inserted");
		    x=in.nextInt();
		    l.insertbegin(x);
		   break;
		case 2:
		    System.out.println("Type an element to be inserted");
		    x=in.nextInt();
		    l.insertmiddle(x);
		   break;    
		case 3:
		    System.out.println("Type an element to be inserted");
		    x=in.nextInt();
		    l.insertend(x);
		    break;
		case 4:
		    l.deletebegin();
		    break;
		case 5:
		    l.deletemiddle();
		    break;    
		case 6:
		    l.deleteend();
		    break;
		case 7:
		    l.display();
		    break;
		default:
		    exit(0);
		   break;
		    
	    }
	}
	
    }
}
