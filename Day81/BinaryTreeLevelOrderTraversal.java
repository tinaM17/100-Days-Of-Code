// Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

// Example 1:

// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[9,20],[15,7]]
// Example 2:

// Input: root = [1]
// Output: [[1]]
// Example 3:

// Input: root = []
// Output: []

package Day81;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>(); // List to store the level-order traversal result

        if (root == null) {
            return ans; // If the tree is empty, return an empty list
        }

        Queue<TreeNode> q = new LinkedList<>(); // Queue to perform the level-order traversal
        q.add(root); // Add the root node to the queue (start the traversal from the root)

        while (!q.isEmpty()) {
            int levels = q.size(); // Get the number of nodes in the current level
            List<Integer> temp = new ArrayList<>(); // List to store the values of nodes in the current level

            for (int i = 0; i < levels; i++) {
                TreeNode node = q.remove(); // Remove the first node from the queue (front of the queue)
                temp.add(node.val); // Add the value of the current node to the temporary list

                // Add the left and right children of the current node to the queue (if they exist)
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }

            ans.add(temp); // Add the temporary list (current level nodes) to the final result list
        }

        return ans; // Return the level-order traversal result
    }
}
