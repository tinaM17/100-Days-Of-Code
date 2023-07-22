// Given a binary tree, find its minimum depth.

// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

// Note: A leaf is a node with no children.

// Example 1:

// Input: root = [3,9,20,null,null,15,7]
// Output: 2
// Example 2:

// Input: root = [2,null,3,null,4,null,5,null,6]
// Output: 5

package Day79;


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
    public int minDepth(TreeNode root) {
        // Base case: If the current node is null (i.e., the tree is empty),
        // then the minimum depth is 0.
        if (root == null) {
            return 0;
        }
        
        // Check if the current node is a leaf node (i.e., it has no children).
        // If it is a leaf node, return 1, indicating the minimum depth is 1.
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        // If the current node has only one child (either left or right),
        // return 1 + the minimum depth of its non-null child.
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        
        // Recursive case:
        // If the current node has both left and right children,
        // calculate the minimum depth of the left subtree and the right subtree,
        // and then take the minimum of the two and add 1 to account for the current node.
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}

