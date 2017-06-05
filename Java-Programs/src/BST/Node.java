/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BST;

/**
 *
 * @author Arul
 */
public class Node {
    int key;
    Node leftchild;
    Node rightchild;
    String name;
    Node(int k,String n)
    {
	this.key=k;
	this.name=n;
    }
    public String toString()
    {
	return this.key+" Its corresponding name is\t"+this.name;
    }
    
}
