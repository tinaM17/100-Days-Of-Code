// Given a non-negative integer x, return the square root of x rounded down to the nearest integer. 
//The returned integer should be non-negative as well.

// You must not use any built-in exponent function or operator.

// For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 

// Example 1:

// Input: x = 4
// Output: 2
// Explanation: The square root of 4 is 2, so we return 2.
// Example 2:

// Input: x = 8
// Output: 2
// Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.

package Day10;

class Solution {
    public int mySqrt(int x) {
        if(x==0) return 0;
        //if the number is 0 then return 0 no further operation requires
        //initialize low and mid
        int low=1,high=x;
        int ans=0;

        while(low<=high){
            //we know mid=(high+low)/2 but here it gives us a interger overflow exception if we do this. Because when the high value is the max of integer value and we are trying to add something to this,it gives an overflow exception. So instead of adding we are subtract the value.
            int mid=(high-low)/2 + low;
            //now check if the number/mid == mid then simply that's our answer
            if((x/mid)==mid)
               return mid;

            //if num/mid less than mid then we have to discard the last part,so now our high=mid-1
            else if((x/mid)<mid)
               high=mid-1;
            
            //else num/mid greater than mid then we have to discard the first part,so now our low=mid+1
            else {
                low=mid+1;
                //here we take an ans variable to store our mid value because when the number is not perfect sq the we have to return the rounded down to nearest number
                ans=mid;
            }
        }
        return ans;

    }
}
