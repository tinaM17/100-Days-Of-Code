// Given the root of a binary tree, return the postorder traversal of its nodes' values.

// Example 1:
// Input: root = [1,null,2,3]
// Output: [3,2,1]
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>(); // List to store the postorder traversal result
        postorder(root, ans); // Call the recursive postorder traversal function
        return ans; // Return the postorder traversal result
    }

    // Recursive function to perform postorder traversal
    private void postorder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return; // Base case: if the current node is null, return to the previous recursive call
        }
        
        postorder(root.left, ans); // Recursively traverse the left subtree
        
        postorder(root.right, ans); // Recursively traverse the right subtree
        
        ans.add(root.val); // Add the value of the current node to the result list
    }
}

