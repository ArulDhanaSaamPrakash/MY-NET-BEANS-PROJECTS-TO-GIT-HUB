/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaSortings;
import static java.lang.System.exit;
import java.util.*;

/**
 *
 * @author Arul
 */
public class MergeSort {
    int[] array=new int[10];
    int[] temparray=new int[10];
    public void getdata()
    {
	Scanner in=new Scanner(System.in);
	System.out.println("Enter the elemnets of the array");
	for(int i=0;i<array.length;i++)
	{
	    array[i]=in.nextInt();
	}
	display();
	mergesort(0,array.length-1);
	display();
    }
    public void display()
    {
	System.out.println("\nArray element created is\n");
	for(int i=0;i<array.length;i++)
	{
	    System.out.print(array[i]+" ");
	}
    }
    public void mergesort(int lowerindex, int upperindex)
    {
	if(lowerindex<upperindex)
	{
	    int middle=(lowerindex+upperindex)/2;
	    mergesort(lowerindex,middle);
	    mergesort(middle+1,upperindex);
	    mergeparts(lowerindex,middle,upperindex);
	}
    }
    public void mergeparts(int lowerindex,int middle,int upperindex)
    {
	for(int i=0;i<=upperindex;i++)
	{
	    temparray[i]=array[i];
	}
	int i=lowerindex;
	int j=middle+1;
	int k=lowerindex;
	while(i<=middle && j<=upperindex)
	{
	    if(temparray[i]<temparray[j])
	    {
		array[k]=temparray[i];
		i++;
	    }
	    else
	    {
		array[k]=temparray[j];
		j++;
	    }
	    k++;
	}
	while(i<=middle)
	{
	    array[k]=temparray[i];
	    k++;
	    i++;
	}
    }
    
    public static void main(String[] arul)
    {
	MergeSort m=new MergeSort();
	m.getdata();
    }
    
}
