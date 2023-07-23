// Given a Binary Tree, find maximum and minimum elements in it.

// Example 1:

// Input: 
           
// Output: 11 1
// Explanation:                           
//  The maximum and minimum element in 
// this binary tree is 11 and 1 respectively.
// Example 2:

// Input: 
//            6
//         / \
//        5   8
//       /
//      2
// Output: 8 2
// Your Task:
// You don't need to read input or print anything. Your task is to complete findMax() and findMin() functions which take root node of the tree as input parameter and return the maximum and minimum elements in the binary tree respectively.

// Expected Time Complexity: O(N)
// Expected Auxiliary Space: O(N)

package Day80;

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 


class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}

class GFG {
    
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    public static void inorder(Node root){
        if(root == null)
            return;
        
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
		while(t-- > 0){
		    String s = br.readLine();
	    	Node root = buildTree(s);
		    Solution obj = new Solution();
		    int mx = obj.findMax(root);
		    int mn = obj.findMin(root);
		    System.out.println(mx+" "+mn);
		}
	}
}
// } Driver Code Ends


//User function Template for Java

/*
class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    public static int findMax(Node root) {
        // Base case: If the current node is null (i.e., the tree is empty),
        // return the minimum possible integer value to represent no maximum value.
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        
        // Recursive case:
        // To find the maximum value in the binary tree, we calculate the maximum value
        // among the current node's data and the maximum values in its left and right subtrees.
        // Then, we return the maximum of these three values.
        return Math.max(root.data, Math.max(findMax(root.left), findMax(root.right)));
    }
    
    public static int findMin(Node root) {
        // Base case: If the current node is null (i.e., the tree is empty),
        // return the maximum possible integer value to represent no minimum value.
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        
        // Recursive case:
        // To find the minimum value in the binary tree, we calculate the minimum value
        // among the current node's data and the minimum values in its left and right subtrees.
        // Then, we return the minimum of these three values.
        return Math.min(root.data, Math.min(findMin(root.left), findMin(root.right)));
    }
}

