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
public class BST_MAIN {
   static Node root;
   public Node insert2(Node root,int key, String name)
   {
       Node newnode=new Node(key,name);
       if(root==null)
       {
	   root=newnode;
       }
       else
       {
	   if(key<=root.key)
	   {
	       root.leftchild=insert2(root.leftchild,key,name);
	   }
	   else
	   {
	       root.rightchild=insert2(root.rightchild,key,name);
	   }
       }
       return root;
   }
    public void insert(int key,String name)
    {
	Node newnode=new Node(key,name);
	if(root==null)
	{
	    root=newnode;
	}
	else
	{
	    Node focusnode=root;
	    Node parent;
	    while(true)
	    {
		parent=focusnode;
		if(key<focusnode.key)
		{
		    focusnode=focusnode.leftchild;
		    if(focusnode==null)
		    {
			parent.leftchild=newnode;
			return;
		    }
		}
		else
		{
		    focusnode=focusnode.rightchild;
		    if(focusnode==null)
		    {
			parent.rightchild=newnode;
			return;
		    }
		}
	    }
	}
    }
    public void inorder(Node root)
    {
	if(root!=null)
	{
	inorder(root.leftchild);
	System.out.println(root);
	inorder(root.rightchild);
	}
	
    }
       public void preorder(Node root)
    {
	if(root!=null)
	{
	System.out.println(root);
	preorder(root.leftchild);
	preorder(root.rightchild);
	}
	
    }
    public void postorder(Node root)
    {
	if(root!=null)
	{
	postorder(root.leftchild);
	postorder(root.rightchild);
	System.out.println(root);
	}
	
    }
    public boolean delete(int key)
    {
	boolean isAleftNode=true;
	Node focusnode=root;
	Node parent=root;
	while(focusnode.key!=key)
	{
	    parent=focusnode;
	    if(key<focusnode.key)
	    {
		focusnode=focusnode.leftchild;
		isAleftNode=true;
	    }
	    else
	    {
		focusnode=focusnode.rightchild;
		isAleftNode=false;
	    }
	    if(focusnode==null)
	    {
		return false;
	    }
	}
	if(focusnode.leftchild==null && focusnode.rightchild==null)
	{
	    if(focusnode==root)
	    {
		root=null;
	    }
	    else if(isAleftNode)
	    {
		parent.leftchild=null;
	    }
	    else
	    {
		parent.rightchild=null;
	    }
	}
	else if(focusnode.leftchild==null)
	{
	    if(focusnode==root)
	    {
		root=focusnode.rightchild;
	    }
	    else if(isAleftNode)
	    {
		parent.leftchild=focusnode.rightchild;
	    }
	    else
	    {
		parent.rightchild=focusnode.rightchild;
	    }
	}
	else if(focusnode.rightchild==null)
	{
	    if(focusnode==root)
	    {
		root=focusnode.leftchild;
	    }
	    else if(isAleftNode)
	    {
		parent.leftchild=focusnode.leftchild;
	    }
	    else
	    {
		parent.rightchild=focusnode.leftchild;
	    }
	}
	else
	{
	    Node replacement=getreplacementNode(focusnode);
	    if(focusnode==root)
	    {
		root=replacement;
	    }
	    else if(isAleftNode)
	    {
		parent.leftchild=replacement;
	    }
	    else
	    {
		parent.rightchild=replacement;
	    }
	    replacement.leftchild=focusnode.leftchild;
	}
	return true;
    }
    public Node getreplacementNode(Node replacedNode)
    {
	Node replacementParent=replacedNode;
	Node replacement=replacedNode;
	Node focusnode=replacedNode.rightchild;
	while(focusnode!=null)  // Till the last left child we ned to iterate. So that we can find the element to be replaced.
	{
	    replacementParent=replacement;
	    replacement=focusnode;
	    focusnode=focusnode.leftchild; 
	}
	//If more than one left branch is present then we need to change
	//the parent of left brank to null. In certain cases, a right ellemnt too
	if(replacement!=replacedNode.rightchild)//More than one branch present
	{
	    replacementParent.leftchild=replacement.rightchild;
	    replacement.rightchild=replacedNode.rightchild;
	}
	return replacement;
    }
    public static void main(String[] arul)
    {
	BST_MAIN obj=new BST_MAIN();
	root=obj.insert2(root,10, "Arul");
	root=obj.insert2(root,2, "Dhana");
	root=obj.insert2(root,4, "Saam ");
	root=obj.insert2(root,4, "prakash");
	obj.inorder(root); // ascending order
	System.out.println("After deleting root");
	obj.delete(2);
	obj.inorder(root);
	//obj.preorder(root);
	//obj.postorder(root); // left, right, root
    }
    
}
