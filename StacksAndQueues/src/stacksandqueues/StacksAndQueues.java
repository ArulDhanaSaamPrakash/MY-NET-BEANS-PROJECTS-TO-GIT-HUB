/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacksandqueues;

/**
 *
 * @author Arul
 */
 class Node<T>
{
   T data;
   Node next;
   Node(T data)
   {
       this.data=data;
       this.next=null;
   }
}
public class StacksAndQueues<T> {

    /**
     * @param args the command line arguments
     */
    
     Node top;
    public void push(T data)
    {
        Node newnode=new Node(data);
        if(top==null)
        {
            top=newnode;
        }else
        {
            newnode.next=top;
            top=newnode;
            
        }
    }public void display()
    {
        while(top!=null)
        {
            System.out.print("\t"+top.data);
            top=top.next;
        }
    }
    public void pop()
    {
        if(top!=null)
        {
            top=top.next;
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        StacksAndQueues obj=new StacksAndQueues();
        obj.push("ar");
        obj.push(1);
        obj.push("assholes");
        obj.pop();
        obj.display();
    }
    
}
