// Given the root of a binary tree, return the preorder traversal of its nodes' values.

// Example 1:
// Input: root = [1,null,2,3]
// Output: [1,2,3]
// Example 2:

// Input: root = []
// Output: []
// Example 3:

// Input: root = [1]
// Output: [1]

package Day77;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>(); // List to store the preorder traversal result
        preorder(root, ans); // Call the recursive preorder traversal function
        return ans; // Return the preorder traversal result
    }
    
    // Recursive function to perform preorder traversal
    private void preorder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return; // Base case: if the current node is null, return to previous recursive call
        }
        
        ans.add(root.val); // Add the value of the current node to the result list
        
        preorder(root.left, ans); // Recursively traverse the left subtree
        
        preorder(root.right, ans); // Recursively traverse the right subtree
    }
}

