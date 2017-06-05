/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacksandqueues;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Arul
 */
public class SetOfStacksFinal {
    
    LinkedList<Stack<Integer>> stacks=new LinkedList<Stack<Integer>>();
    int counter=0,capacity=4;
    public void push(int x)
    {
        if(counter==0 || counter==capacity)
        {
            counter=0;
            Stack<Integer> stack=new Stack<Integer>();
            stacks.add(stack);
            stack.push(x);
            counter++;
        }
        else
        {
            stacks.getLast().push(x);
            counter++;
        } 
    }
    public int pop()
    {
        if(counter==1)
        {
            counter=capacity;
        }
        if(stacks.getLast().isEmpty())
        {
             stacks.removeLast();
        }
        counter --;
        if(stacks.isEmpty())
        {
            System.out.println("UnderFlow");
            counter=0;
            return 0;
        }
        return stacks.getLast().pop();
    }
    public void display()
    {
        for(int i=0;i<stacks.size();i++)
        {
            System.out.println("\t"+stacks.get(i));
        }
    }
     public static void main(String[] arul)
    {
       Scanner in=new Scanner(System.in);
        SetOfStacksFinal obj=new SetOfStacksFinal();
        while(true)
        {
            System.out.println("\n\n1.Push\n2.Pop\n3.Getmin\n4.Display");
           int ch=in.nextInt();
            
            switch (ch){
                case 1: 
                    int c;
                    c=in.nextInt();
                    obj.push(c);
                    break;
                case 2:
                    System.out.println(obj.pop());
                    obj.display();
                    break;
                case 3:
                   // obj.getmin();
                    break;
                case 4:
                    obj.display();
                    break;
                default:
                    System.exit(0);
                    
                    
            }
        } 
    }
}
