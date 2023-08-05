// Given the root of a binary tree, determine if it is a valid binary search tree (BST).

// A valid BST is defined as follows:

// The left 
// subtree
//  of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
 

// Example 1:
// Input: root = [2,1,3]
// Output: true
// Example 2:
// Input: root = [5,1,4,null,null,3,6]
// Output: false
// Explanation: The root node's value is 5 but its right child's value is 4.

package Day90;

// Definition for a binary tree node.
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }

    private boolean isBST(TreeNode node, Integer min, Integer max) {
        // Base case: If the current node is null, it is a valid BST (empty tree).
        if (node == null) {
            return true;
        }
        // Check if the current node's value violates the BST property with respect to min and max.
        // If the node's value is less than or equal to the min (if min is not null) or greater than or equal to the max
        // (if max is not null), then it is not a valid BST.
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }
        // Recursively check the left and right subtrees.
        // In the left subtree, the maximum allowed value is the current node's value (node.val).
        // In the right subtree, the minimum allowed value is the current node's value (node.val).
        return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
    }
}

