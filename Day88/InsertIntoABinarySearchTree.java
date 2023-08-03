// You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

// Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

// Example 1:
// Input: root = [4,2,7,1,3], val = 5
// Output: [4,2,7,1,3,5]
// Explanation: Another accepted tree is:

// Example 2:
// Input: root = [40,20,60,10,30,50,70], val = 25
// Output: [40,20,60,10,30,50,70,null,null,25]

// Example 3:
// Input: root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
// Output: [4,2,7,1,3,5]

package Day88;

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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // Create a new TreeNode with the given value 'val'
        TreeNode node = new TreeNode(val);

        // Initialize 'curr' to the root of the BST, and 'parent' to null
        TreeNode curr = root;
        TreeNode parent = null;

        // Traverse down the tree to find the appropriate position to insert the new node
        while (curr != null) {
            parent = curr;
            if (val > curr.val) {
                // If 'val' is greater than the current node's value, move to the right subtree
                curr = curr.right;
            } else {
                // If 'val' is less than or equal to the current node's value, move to the left subtree
                curr = curr.left;
            }
        }

        // 'parent' will be the parent node of the new node 'node'
        // Insert the new node as the left or right child of the 'parent' based on 'val'
        if (parent == null) {
            // If 'parent' is null, it means the tree was empty, so the new node becomes the root
            return node;
        }
        if (parent.val > val) {
            parent.left = node; // Insert the new node as the left child of 'parent'
        } else {
            parent.right = node; // Insert the new node as the right child of 'parent'
        }

        // Return the root of the updated BST
        return root;
    }
}

