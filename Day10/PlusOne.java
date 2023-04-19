// You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

// Increment the large integer by one and return the resulting array of digits.

 

// Example 1:

// Input: digits = [1,2,3]
// Output: [1,2,4]
// Explanation: The array represents the integer 123.
// Incrementing by one gives 123 + 1 = 124.
// Thus, the result should be [1,2,4].

package Day10;

class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        for(int i=n-1;i>=0;i--){
            //runs a for loop from n-1 to 0.because we have to add our extreme right digit first
            if(digits[i]<9){
                digits[i]+=1;
                return digits;
            }
            //if the array contains [2,7] means the last element is less than 9. So we just simply add 1 to it and return the array [2.8] like this
            //But if the array contains [2,9] then after adding one the last digit become 0 and we have to add one to it's previous digits. We just simply assign 0 to that digit and run the for loop again

            digits[i]=0;
        }

        //But our code will failed if the array contains only 9, i,e; [9,9,9] So after runs the for loop our array now becomes [0,0,0] and it does not return anything. We have to return [1,0,0,0] instead of [0,0,0]
        //So we to create a new array of length n+1; by deafult all it values are 0's. We just assign one to the first index and return our new array that's it.

        int[] res=new int[n+1];
        res[0]=1;
        return res;

    }
}