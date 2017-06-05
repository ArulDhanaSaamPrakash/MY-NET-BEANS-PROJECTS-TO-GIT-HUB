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
class Node
{
    int data;
    Node next;
    Node (int x)
    {
        this.data=x;
        this.next=null;
    }
}
public class LinkedList {
    /**
     * @param args the command line arguments
     */
    Node head;
    Node head1;
    public void insert1(int x)
    {
       Node newnode=new Node(x);
        if(head1==null)
        {
            head1=newnode;
        }
        else
        {
            Node temp=head1;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
           temp.next=newnode;
        }  
    }
    public void insert(int x)
    {
        Node newnode=new Node(x);
        if(head==null)
        {
            head=newnode;
        }
        else
        {
            Node temp=head;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
           temp.next=newnode;
        }
    }
    public void display()
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(""+temp.data+"\t");
            temp=temp.next;
        }
    }
    public void reverse()
    {
        Node currentNode=head;
        Node previousNode=null;
        Node nextNode=null;
        while(currentNode!=null)
        {
            nextNode=currentNode.next;
            currentNode.next=previousNode;
            previousNode=currentNode;
            currentNode=nextNode;
        }
        head=previousNode;
        System.out.println("Length is"+findlen(head)+"Hello world");
    }
    public int findlen(Node head)
    {
        int c=0;
        while(head!=null)
        {
            c++;
            head=head.next;
        }
        return c;
    }
    public void mergesortstarter()
    {
        Node temp=divideParts(head);
        head=temp;
    }
    public Node divideParts(Node head)
    {
        Node leftbranch;
        Node rightbranch;
        Node r;
        Node result;
        if(head.next==null)
        {
            return head;
        }
        Node tepHead=head;
        int mid=(findlen(head)/2);
        while(mid-1>0)
        {
            head=head.next;
            mid--;
        }
        rightbranch=head.next;
        head.next=null;
        head=tepHead;
        leftbranch=divideParts(head);
        r=divideParts(rightbranch);
        result=merge(leftbranch,r);
        
      return result;  
    }
    public Node merge(Node leftbranch, Node rightbranch)
    {
        Node result;
        if(leftbranch==null)
            return rightbranch;
        if(rightbranch==null)
        {
            return leftbranch;
        }
        if(leftbranch.data<rightbranch.data)
        {
            result=leftbranch;
            result.next=merge(leftbranch.next,rightbranch);
        }
        else
        {
            result=rightbranch;
            result.next=merge(rightbranch.next,leftbranch);
        }
        return result;
    }
    public void  removeduplicates()
    {
       Hashtable<Integer,Boolean> table=new Hashtable<Integer,Boolean>();
       Node previousNode=null;
       Node temp=head;
       while(temp!=null)
       {
           if(table.containsKey(temp.data))
           {
               previousNode.next=temp.next;
           }
           else
           {
               table.put(temp.data, true);
               previousNode=temp;
           }
           temp=temp.next;
       }
       //head=previousNode;
       display();
    }
    public void checkPalindrome()
    {
        Node temp=head;
       String str = "";
        while(temp!=null)
        {
            str=str.concat(""+temp.data);
          
            temp=temp.next;
        }
        System.out.println(""+str);
        System.out.println(""+isPalindrome(str));
    }
    public boolean isPalindrome(String str)
    {
        int j=str.length()-1;
        for(int i=0;i<str.length()/2;i++)
        {
            if(str.charAt(i)!=str.charAt(j))
            {
                return false;
            }
            j--;
        }
        return true;
    }
    public void partition()
    {
        Node dummy1=new Node(90); // some random dummy value
        Node dummy2=new Node(90);
        Node queue1=dummy1;
        Node queue2=dummy2;
        while(head!=null)
        {
            if(head.data<3)
            {
               queue1.next=head;
               queue1=queue1.next;
            }
            else
            {
                queue2.next=head;
                queue2=queue2.next;
            }
           head=head.next;
         }
            queue2.next=null;  // marks the ned of queue to be null.
            queue1.next=dummy2.next;
            head=dummy1.next;
            display();
    }
    public void digitrepresentation()
    {
        Node dummy=new Node(90);
        Node linkedList1=head;
        Node linkedList2=head1;
        Node result=dummy;
        int carry=0;
        while(linkedList1!=null || linkedList2!=null)
        {
            if(linkedList1!=null)  // doing the addition from left to right
            {
                carry=carry+linkedList1.data;
                linkedList1=linkedList1.next;
            }
            if(linkedList2!=null)
            {
                carry=carry+linkedList2.data;
                linkedList2=linkedList2.next;
            }
            Node newnode=new Node(carry%10);
            result.next=newnode;
            result=result.next;
            carry=carry/10;
        }
        head=dummy.next;
        display();
    }
    public void starter()
    {
        System.out.println(""+getIntersectionNode(head,head1));
                
        
    }
    public Node getIntersectionNode(Node A,Node B)
 {
	    Node lastA, lastB;
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
	    
	    if (!lastA.equals(lastB))
	        return null;
	    
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
	    
	    while (lastA!=lastB)
            {
	        lastA = lastA.next;
	        lastB = lastB.next;
	    }
	    
	    return lastA;
	    
	}

    public void checkrference(Node head1,Node head2)
    {
        if(head1==null)
            return;
        int head1length=findlen(head1);
        int head2length=findlen(head2);
        int diff=head1length-head2length;
        Node temp1=head1;
        Node temp2=head2;
        if(head1length>head2length)
        {
            while ( diff-->0)
            {
                temp1=temp1.next;
            }
        }
        else
        {
            temp2=temp2.next;
        }
        while(temp1!=temp2 && temp1!=null && temp2!=null)
        {
            System.out.println("Temp1"+temp1);
            System.out.println("Temp2"+temp2);
            temp1=temp1.next;
            temp2=temp2.next;
        }
        System.out.println("Found a match "+temp1.data);
    }
    public static void main(String[] args) {
        // TODO code application logic here
    LinkedList obj=new LinkedList();
       /* obj.insert(2);
        obj.insert(4);
        obj.insert(3);
    */
       Node head;
       Node newnode=new Node(1);
       Node newnode1=new Node(2);
       Node newnode2=new Node(3);
       Node newnode3=new Node(4);  
       Node newnode4=new Node(5);
       Node newnode5=new Node(6);
               
             
       head=newnode;
      newnode.next=newnode1;
      newnode1.next=newnode2;
      newnode2.next=newnode3;
      newnode3.next=newnode4;
      newnode4.next=newnode5;
      newnode5.next=newnode2; // Created a loop
       
        // Floy'ds cycle finding algorithm
        Node te=head;
        Node incrementerByOne=head;
        Node incrementerByTwo=head.next.next;
        Node incrementByTwoPrevious=head.next;
        
        while(incrementerByOne!=null && incrementerByTwo!=null && incrementerByTwo.next!=null)
        {
           if(incrementerByOne==incrementerByTwo)
           {
               System.out.println("Loop Exists");
              System.out.println("Incrementer 1"+incrementerByOne.data);
              System.out.println("Incrementer 2"+incrementerByTwo.data);
                incrementByTwoPrevious.next=null;
               break;
           }
           else
           {
              incrementerByOne=incrementerByOne.next;
            incrementerByTwo=incrementerByTwo.next.next;
            incrementByTwoPrevious=incrementByTwoPrevious.next.next;
           }
            
           
            
        }
        Node temp=te;
       while(temp!=null)
       {
           System.out.print(""+temp.data);
           temp=temp.next;
       }
        
        
      /*  obj.insert1(2);
        obj.insert1(4);
        obj.insert1(3);
        
       
       obj.starter();*/
      
      
    /*    System.out.println("");
        obj.display();  
       // obj.mergesortstarter();
        System.out.println("After Merging");
        obj.display();
        System.out.println("dup");
       // obj.removeduplicates();
        obj.checkPalindrome();
        obj.partition();
        
        */
        System.out.println("Hai");
    obj.digitrepresentation();
    }
}
