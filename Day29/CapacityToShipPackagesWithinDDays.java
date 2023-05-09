// A conveyor belt has packages that must be shipped from one port to another within days days.

// The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

// Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.

 

// Example 1:

// Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
// Output: 15
// Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
// 1st day: 1, 2, 3, 4, 5
// 2nd day: 6, 7
// 3rd day: 8
// 4th day: 9
// 5th day: 10

// Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
// Example 2:

// Input: weights = [3,2,2,4,1,4], days = 3
// Output: 6
// Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
// 1st day: 3, 2
// 2nd day: 2, 4
// 3rd day: 1, 4
// Example 3:

// Input: weights = [1,2,3,1,1], days = 4
// Output: 3
// Explanation:
// 1st day: 1
// 2nd day: 2
// 3rd day: 3
// 4th day: 1, 1

package Day29;

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        //maximum of the array
        int min=max(weights);
        //sum of all the number
        int max=sum(weights);
        //initialize res var to 0
        int res=0;
        //if the length of the array is greater than the no.of days then return -1;
        if(weights.length<days) return -1;

        while(min<=max){
             //find the mid value of min and max
            int mid=(min+max)/2;
            //now check the mid value is feasible for the number of days or not
            if(isFeasible(weights,days,mid)){
                //if feasible then store the value into our res var and decrease our search space to find a better minimum mid
               //so our new max=mid-1;
                res=mid;
                max=mid-1;
            }
            else {
                //else it is not feasible so we have to discard our mid's left side and search on the right.so new min=mid+1;
                min=mid+1;
            }
        }
        //after the loop return the res;
        return res;
    }

//method to check our maximum number of pages could be divided by M number of student or not

    public boolean isFeasible(int[] weights, int days,int mid){
         //initialize our totalDays=1 and sum=0;
        int totalDays=1,sum=0;
        //runs a loop to iterate the array
        for(int i=0;i<weights.length;i++){
            //check the current sum+current element is greater than mid then we need one more day to distribute
            if(sum+weights[i]>mid){
                //so totalDays=totalDays+1 and new sum=current number
                totalDays++;
                sum=weights[i];
            }
            //else sum+current element less than mid so we can distribute the in our current days
            else {
                sum+=weights[i];
            }
        }
        //now check totalDays is less than equal to given days then return true else false;
        return totalDays<=days;
    }

//method to find maximum number in the array
    public int max(int[] weights){
         int maxi=Integer.MIN_VALUE;
         for(int i=0;i<weights.length;i++){
             if(maxi<weights[i])
                maxi=weights[i];
         }
         return maxi;
    }

    //method to find sum of all the number in the array
    public int sum(int[] weights){
         int ans=0;
         for(int i=0;i<weights.length;i++){
             ans+=weights[i];
         }
         return ans;
    }
}
