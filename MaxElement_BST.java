/*
 * Anusha Peddigari
 * 001023769
 */


package Test;



/**
 *
 * @author 16175
 */
public class MaxElement_BST {
	
	private static class Node{
	    int data; 
	    Node left; 
	    Node right;
	}
	
	static Node insert(Node node, int data) 
	{ 
	    /* 1. If the tree is empty, return a new,      
	    single node */
	    if (node == null) {
	    	Node n = new Node();
	    	n.data = data;
	    	n.left = null;
	    	n.right = null;
	    	return n;
	    }
	    else 
	    { 
	        /* 2. Otherwise, recur down the tree */
	        if (data <= node.data) 
	            node.left = insert(node.left, data); 
	        else
	            node.right = insert(node.right, data); 
	  
	        /* return the (unchanged) node pointer */
	        return node; 
	    } 
	}
	
	static int maxValue(Node node) 
	{  
	    /* loop down to find the rightmost leaf */
	    Node current = node; 
	    while (current.right != null)  
	        current = current.right; 
	      
	    return (current.data); 
	} 
	
	static int[] convert(String s) {
		int[] arr = new int[s.length()];
		for (int i = 0; i < s.length(); i++){
		    char ch = s.charAt(i);
		    int n = ch - 'a';
		    arr[i] = n;
		}
		
		return arr;
	}

	public static void main(String[] args) {
		int[] input = convert("abdcceddfcabbeddccefddaaf");
		Node root = null; 
	    root = insert(root, input[0]); 
	    for (int i = 1; i < input.length; i++) {
	    	insert(root, input[i]); 
		}
	    int max =  maxValue(root);
	    System.out.println("Maximum value in BST is " + String.valueOf((char)(max + 'A' - 1))); 
	}

}
