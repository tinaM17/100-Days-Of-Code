// Given the root of a binary tree, return the length of the diameter of the tree.

// The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

// The length of a path between two nodes is represented by the number of edges between them.

// Example 1:
// Input: root = [1,2,3,4,5]
// Output: 3
// Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

// Example 2:
// Input: root = [1,2]
// Output: 1

package Day85;
  //Definition for a binary tree node.
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
    public int diameterOfBinaryTree(TreeNode root) {
        int diameter[] = new int[1]; // An array to store the diameter of the binary tree
        height(root, diameter); // Call the recursive height function to compute the diameter
        return diameter[0]; // Return the diameter of the binary tree
    }

    // Recursive function to compute the height of the binary tree and update the diameter
    private int height(TreeNode root, int[] diameter) {
        if (root == null)
            return 0; // Base case: if the current node is null, return 0

        int leftHeight = height(root.left, diameter); // Recursively compute the height of the left subtree
        int rightHeight = height(root.right, diameter); // Recursively compute the height of the right subtree

        // Update the diameter if the current path (leftHeight + rightHeight) is greater
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);

        // Return the height of the current node (the maximum of leftHeight and rightHeight) + 1
        // This represents the height of the current subtree rooted at the current node.
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

