package Day4;

class Solution {
    public void rotate(int[] nums, int k) {
         //create a temporary array to store our rotated array's data
         int n=nums.length;
        int temp[]=new int[n];
        
        for(int i=0;i<n;i++){ //runs a for loop for 0 to n-1
        
            temp[(i+k)%n]=nums[i];  // add k value to our current index and module division it by n then we get our perfect position to place our data into the temp array
        }
        
        for(int i=0;i<n;i++){
            //copying the elements to temp to our main array
            nums[i]=temp[i];
        }
    }
}