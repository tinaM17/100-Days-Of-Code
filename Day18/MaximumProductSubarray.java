// Given an integer array nums, find a 
// subarray
//  that has the largest product, and return the product.

// The test cases are generated so that the answer will fit in a 32-bit integer.

 

// Example 1:

// Input: nums = [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.
// Example 2:

// Input: nums = [-2,0,-1]
// Output: 0
// Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

package Day18;

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int l=1,r=1;
        int ans=nums[0];
        
        for(int i=0;i<n;i++){
            
			//if any of l or r become 0 then update it to 1
            l = l==0 ? 1 : l;
            r = r==0 ? 1 : r;
            
            l *= nums[i];   //prefix product
            r *= nums[n-1-i];    //suffix product
            
            ans = Math.max(ans,Math.max(l,r));
            
        }
        
        return ans;
    }
}
