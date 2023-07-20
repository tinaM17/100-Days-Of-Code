// Given the root of a binary tree, return its maximum depth.
// A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: 3

// Example 2:
// Input: root = [1,null,2]
// Output: 2

package Day78;

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
    public int maxDepth(TreeNode root) {
        // Base case: If the current node is null (i.e., the tree is empty),
        // then the depth of the tree is 0.
        if (root == null) {
            return 0;
        }
        
        // Recursive case:
        // To find the depth of the tree, we calculate the depth of the left subtree
        // and the depth of the right subtree, and then take the maximum of the two
        // and add 1 to account for the current node's depth.
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

