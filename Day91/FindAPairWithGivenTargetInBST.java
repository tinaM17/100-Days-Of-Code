// Given a Binary Search Tree and a target sum. Check whether there's a pair of Nodes in the BST with value summing up to the target sum. 

// Example 1:

// Input:
//         2
//       /   \
//      1     3
// sum = 5
// Output: 1 
// Explanation: 
// Nodes with value 2 and 3 sum up to 5.
// Example 2:

// Input:
//            6
//           /    
//          5     
//         /
//        3 
//      /  \
//     1    4
// sum = 2
// Output: 0 
// Explanation: 
// There's no pair that sums up to 2.
// Your Task:
// You don't need to read input or print anything. Your task is to complete the function isPairPresent() that takes a root node and a target value as a parameter and returns 1 if there's a pair of Nodes in the BST with values summing up to the target sum, else returns 0. 

// Expected Time Complexity: O(N).
// Expected Auxiliary Space: O(Height of the BST).

package Day91;

//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            int target = Integer.parseInt(br.readLine().trim());
            
            Solution T = new Solution();
            System.out.println(T.isPairPresent(root,target));
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    // root : the root Node of the given BST
    // target : the target sum
    public int isPairPresent(Node root, int target) {
        Set<Integer> set = new HashSet<>();
        boolean ans = findPair(root, target, set);
        return ans == true ? 1 : 0;
    }

    // Helper function to find the pair of nodes with the given target sum.
    private boolean findPair(Node root, int target, Set<Integer> set) {
        if (root == null) {
            return false; // Base case: If the current node is null, return false.
        }

        // Check if there exists a node with the value (target - current node's value)
        // in the set. If yes, then we have found a pair whose values add up to the target.
        if (set.contains(target - root.data)) {
            return true;
        }

        // Add the current node's value to the set and continue searching for the pair in
        // the left and right subtrees.
        set.add(root.data);
        return findPair(root.left, target, set) || findPair(root.right, target, set);
    }
}


