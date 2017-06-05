/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacksandqueues;

import java.util.Scanner;

/**
 *
 * @author Arul
 */

public class SimpleStack {
    int[][] stack=new int[5][2];
    int top=-1;
    int min;
    public void push(int x)
    {
        if( top>=4)
        {
            System.out.println("Overflow");
        }
        else
        {
            if(top==-1)
            {
            min=x;    
            }
             top++;
             if(x<min)
             {
               min=x;  
             }
             stack[top][0]=x;
             stack[top][1]=min;
        }
    }
    public void display()
    {
        System.out.println("Content of stack is");
        for(int i=0;i<=top;i++)
        {
            System.out.println(""+stack[i][0]);
        }
    }
    public void pop()
    {
        if(top==-1)
        {
            System.out.println("Underflow");
        }
        else
        {
            top--;
        }
    }
    public void getmin()
    {
        System.out.println("Minimum Value is"+stack[top][1]);
    }
    public static void main(String[] arul)
    {
        Scanner in=new Scanner(System.in);
        SimpleStack obj=new SimpleStack();
        while(true)
        {
            System.out.println("1.Push\n2.Pop\n3.Getmin\n4.Display");
           int ch=in.nextInt();
            
            switch (ch){
                case 1: 
                    int c;
                    c=in.nextInt();
                    obj.push(c);
                    break;
                case 2:
                    obj.pop();
                    break;
                case 3:
                    obj.getmin();
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
