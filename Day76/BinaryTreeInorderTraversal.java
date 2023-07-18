// Given the root of a binary tree, return the inorder traversal of its nodes' values.

// Example 1:

// Input: root = [1,null,2,3]
// Output: [1,3,2]
// Example 2:

// Input: root = []
// Output: []
// Example 3:

// Input: root = [1]
// Output: [1]

package Day76;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>(); // List to store the inorder traversal result
        traversal(root, ans); // Call the recursive traversal function
        return ans; // Return the inorder traversal result
    }
    // Recursive function to perform inorder traversal
    public void traversal(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return; // Base case: if the current node is null, return to previous recursive call
        }
        traversal(root.left, ans); // Recursively traverse the left subtree
        ans.add(root.val); // Add the value of the current node to the result list
        traversal(root.right, ans); // Recursively traverse the right subtree
    }
}

