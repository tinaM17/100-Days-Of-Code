// Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

// Example 1:


// Input: root = [1,2,3,null,5,null,4]
// Output: [1,3,4]
// Example 2:

// Input: root = [1,null,3]
// Output: [1,3]
// Example 3:

// Input: root = []
// Output: []

package Day82;
import java.util.*;
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        // Call the recursive rightView function to populate the right side view of the tree
        rightView(root,ans,0);
        return ans;
    }
    // Recursive function to populate the right side view of the tree
    private void rightView(TreeNode root,List<Integer> res,int level){
        // If the root is null, we have reached the end of the tree or a leaf node
        if(root==null) return;
        
        // If the level is equal to the size of the result list, it means we are
        // visiting the rightmost node at this depth for the first time
        // So, add the current node's value to the result list for the right side view
        
        if(level==res.size()){
            res.add(root.val);
        }
        // Recursively call the rightView function on the right and left subtrees, 
        // incrementing the level by 1 for each recursive call
        // The right subtree is processed before the left subtree, ensuring that the rightmost 
        // node at each depth is added to the result list
        rightView(root.right,res,level+1);
        rightView(root.left,res,level+1);
    }
}