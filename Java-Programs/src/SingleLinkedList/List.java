/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SingleLinkedList;

import static java.lang.System.exit;
import java.util.Scanner;

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
	head=newnode;
	}
	else
	{
	 newnode.next=head;  
	 head=newnode;
	}
	System.out.println("\n\nElement has been inserted\n\n\n");
    }
    public void insertmiddle(int x)
    {
	Node newnode=new Node(x);
	if(head==null)
	{
	    head=newnode;
	    System.out.println("Since No list is present i inserted and created a linked list");
	}
	else
	{
	    int pos=0;
	    Scanner in=new Scanner(System.in);
	    System.out.println("\n\nenter the position wer u want to insert");
	    pos=in.nextInt();
	    if(pos==0)
	    {
		insertbegin(x);
	    }
	    else
	    {
		Node temp;
		temp=head;
		int counter=0;
		while(temp!=null)
		{
		    if(pos!=counter)
		    {
			counter++;
		    }
		    if(pos==counter)
		    {
			
			newnode.next=temp.next;
			temp.next=newnode;
			break;
		    }
		    temp=temp.next;
		}
	    }
	}
    }
    public void insertend(int x)
    {
	Node newnode=new Node(x);
	if(head==null)
	{
	    head=newnode;
	    System.out.println("Since No list is present i inserted and created a linked list");
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
		    System.out.println("An element has been inserted at the end");
		    break;
		}
	    }
	}
    }
    public void deletebegin()
    {
	if(head==null)
	{
	    System.out.println("\n\n go create a linked list first");
	}
	else
	{
	    Node temp;
	    temp=head.next;
	    head.next=null;
	    head=temp;
	    System.out.println("An element is deleted in the begining");
	    
	}
    }
    public void deletemiddle(int pos)
    {
	if(pos==0)
	{
	    deletebegin();
	}
	else
	{
	    int counter=0;
	    Node temp;
	    temp=head;
	    while(temp!=null)
	    {
		if(pos!=counter)
		{
		    counter++;
		    temp=temp.next;
		}
		if(pos==counter)
		{
		    temp.next=temp.next.next;
		    System.out.println("element is deleted");
		    break;
		}
	    }
	   
	}
    }
    public void deleteend()
    {
	 Node temp;
	    temp=head;
	    while(temp!=null)
	    {
		if(temp.next==null){
		    deletebegin();
		    break;
		}
		else if(temp.next.next==null)
		{
		    temp.next=null;
		    System.out.println("element at the end is deleted");
		    break;
		}
		
		else
		{
		     temp=temp.next;
		   
		}
	    }
    }
    void display()
    {
	Node temp;
	temp=head;
	System.out.println("Elements of Linked List are");
	while(temp!=null)
	{
	    System.out.print(temp.getX()+"->");
	    temp=temp.next;
	}
	System.out.println("\n\n");
    }
    public void sort()
    {
	head=MergeSortListBreakdown(head);
	//head=sorted;
    }
    public Node MergeSortListBreakdown(Node startnode)
    {
	//Break the list until list is null or only 1 element is present in List.
	if(startnode==null || startnode.next==null)
	{
	    return startnode;
	}
	  //Break the linklist into 2 list.
  //Finding Middle node and then breaking the Linled list in 2 parts.
  //Now 2 list are, 1st list from start to middle and 2nd list from middle+1 to last.
   
	Node middle=MergeSortGetMiddle(startnode);
	Node nextofmiddle=middle.next;
	middle.next=null;
	
	 //Again breaking the List until there is only 1 element in each list.
	Node left=MergeSortListBreakdown(startnode);
	Node right=MergeSortListBreakdown(nextofmiddle);
	 //Once complete list is divided and contains only single element, 
  //Start merging left and right half by sorting them and passing Sorted list further. 
	Node sortedlist=MergeSortSorting(left,right);
	
	
	return sortedlist;
    }
    public Node MergeSortSorting(Node leftstart,Node rightstart)
    {
	if(leftstart==null)
	{
	    return rightstart;
	}
	if(rightstart==null)
	{
	    return leftstart;
	}
	Node temp=null;
	if(leftstart.x<rightstart.x)
	{
	    temp=leftstart;
	    temp.next=MergeSortSorting(leftstart.next,rightstart);
	}
	else
	{
	   temp=rightstart;
	    temp.next=MergeSortSorting(rightstart.next,leftstart); 
	}
	return temp;
    }
    public Node MergeSortGetMiddle(Node startnode)
    {
	if(startnode==null)
	{
	    return startnode;
	}
	Node pointer1=startnode;
	Node pointer2=startnode;
	while(pointer2!=null && pointer2.next!=null && pointer2.next.next!=null)
	{
	    pointer1=pointer1.next;
	    pointer2=pointer2.next.next;
	}
	
	return pointer1;
    }
    public static void main(String[] arul)
    {
	List l=new List();
	Scanner in=new Scanner(System.in);
	int ch;
	int k;
	while(1==1)
	{
	    System.out.println("1.InsertBegin\n2.InsertMiddle\n3.InsertEnd\n4.DeleteBegin\n5.DeleteMiddle\n6.DeleteEnd\n7.Display\n8.MergeSort\nChoose your choice:....");
	    ch=in.nextInt();
	   
	    switch(ch)
	    {
		case 1:
		    System.out.println("\n\nEnter an element to be inserted");
		    k=in.nextInt();
		    l.insertbegin(k);
		    break;
		case 2:
		     System.out.println("\n\nEnter an element to be inserted");
		    k=in.nextInt();
		    l.insertmiddle(k);
		    break;
		case 3:
		      System.out.println("\n\nEnter an element to be inserted");
		    k=in.nextInt();
		    l.insertend(k);
		    break;
		case 4:
		    l.deletebegin();
		    break;
		case 5:
		         System.out.println("\n\nEnter an position to be deleted");
		    k=in.nextInt();
		    l.deletemiddle(k);
		    break; 
		case 6:
		    l.deleteend();
		    break; 
		case 7:
		    l.display();
		    break;
		case 8:
		  l.sort();
		    break;
		default:
		    exit(0);
	    }
	    
	   
	}
	
    }
    
}
