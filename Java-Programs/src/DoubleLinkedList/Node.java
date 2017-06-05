/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoubleLinkedList;

/**
 *
 * @author Arul
 */
public class Node {
    int x;
    Node next;
    Node prev;
    Node(int x)
    {
	this.x=x;
	this.next=null;
	this.prev=null;
    }
    
}
