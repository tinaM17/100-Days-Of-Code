// You are given the root of a binary search tree (BST) and an integer val.

// Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.

// Example 1:
// Input: root = [4,2,7,1,3], val = 2
// Output: [2,1,3]

// Example 2:
// Input: root = [4,2,7,1,3], val = 5
// Output: []

package Day87;


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
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null; // Base case: if the current node is null, return null (value not found)

        if (root.val > val) {
            // If the current node's value is greater than the target value 'val',
            // recursively search the left subtree.
            return searchBST(root.left, val);
        } else if (root.val < val) {
            // If the current node's value is less than the target value 'val',
            // recursively search the right subtree.
            return searchBST(root.right, val);
        } else {
            // If the current node's value is equal to the target value 'val',
            // we have found the node with the given value in the BST. Return the node.
            return root;
        }
    }
}

