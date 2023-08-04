// Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

// Basically, the deletion can be divided into two stages:

// Search for a node to remove.
// If the node is found, delete the node.

// Example 1:
// Input: root = [5,3,6,2,4,null,7], key = 3
// Output: [5,4,6,2,null,null,7]
// Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
// One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
// Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

// Example 2:

// Input: root = [5,3,6,2,4,null,7], key = 0
// Output: [5,3,6,2,4,null,7]
// Explanation: The tree does not contain a node with value = 0.
// Example 3:

// Input: root = [], key = 0
// Output: []

package Day89;

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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root; // Base case: If the tree is empty or node not found, return the root

        // If 'key' is less than the value of the current node, search in the left subtree
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        // If 'key' is greater than the value of the current node, search in the right subtree
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        // If the current node has the value 'key' to be deleted
        else {
            // If the node has only one child or no child, return the non-null child (if any)
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // If the node has both left and right children, find the minimum value in the right subtree
            root.val = minValue(root.right);

            // Delete the node with the minimum value from the right subtree
            root.right = deleteNode(root.right, root.val);
        }

        return root; // Return the root of the updated BST
    }

    //method to find the min node from the right sub tree left child
    private int minValue(TreeNode root) {
        int min = root.val;

        while (root.left != null) {
            min = root.left.val;
            root = root.left;
        }
        return min;
    }
}

