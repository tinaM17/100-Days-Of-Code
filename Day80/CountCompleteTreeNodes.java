// Given the root of a complete binary tree, return the number of the nodes in the tree.

// According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

// Design an algorithm that runs in less than O(n) time complexity.

// Example 1:

// Input: root = [1,2,3,4,5,6]
// Output: 6
// Example 2:

// Input: root = []
// Output: 0
// Example 3:

// Input: root = [1]
// Output: 1

package Day80;

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
    public int countNodes(TreeNode root) {
        // Base case: If the current node is null (i.e., the tree is empty),
        // then the number of nodes is 0.
        if (root == null) {
            return 0;
        }

        // Recursive case:
        // To count the number of nodes in the tree, we recursively count the number of nodes
        // in the left subtree and the number of nodes in the right subtree.
        // Then, we add 1 to account for the current node itself.
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}

