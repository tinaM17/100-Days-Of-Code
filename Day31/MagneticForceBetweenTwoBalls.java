// In the universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put in his new invented basket. Rick has n empty baskets, the ith basket is at position[i], Morty has m balls and needs to distribute the balls into the baskets such that the minimum magnetic force between any two balls is maximum.

// Rick stated that magnetic force between two different balls at positions x and y is |x - y|.

// Given the integer array position and the integer m. Return the required force.

// Example 1:


// Input: position = [1,2,3,4,7], m = 3
// Output: 3
// Explanation: Distributing the 3 balls into baskets 1, 4 and 7 will make the magnetic force between ball pairs [3, 3, 6]. The minimum magnetic force is 3. We cannot achieve a larger minimum magnetic force than 3.
// Example 2:

// Input: position = [5,4,3,2,1,1000000000], m = 2
// Output: 999999999
// Explanation: We can use baskets 1 and 1000000000.

package Day31;
import java.util.*;

class Solution {
    public int maxDistance(int[] position, int m) {
        //Sort the array first to apply our binary search algo
        Arrays.sort(position);
        //initialize our low=0 and high=max value of the stallls
        int low=0;
        int n=position.length;
        int high=position[n-1];
        
        int ans=0;
        
        while(low<high){
            //find the mid first
            int mid=(low+high)/2;
            //then check can we place all the balls with respect to the mid distance
            if(isPossible(n,m,position,mid)){
                //if possible then it could be our answer so store it in ans variable
                ans=mid;
                //and also increase our search space because we have to find the min of max distance btw them 
                low=mid+1;
            }
            //else for the current mid value we can not placed all the balls so, also for greater values we can not place the balls. so we have reduce our search space by high=mid;
            else {
                high=mid;
            }
        }
        //now return our answer
        return ans;
    }


     //method to check for a mid value all the balls can be placed or not
    public static boolean isPossible(int n, int m, int[] position,int mid){
        //initialize balls variable to 1
        int balls=1;
        //our distance will be counting from the first stall
        int distance=position[0];
        //iterate over all the position
        for(int i=1;i<n;i++){
            //if the current position - distance greater than equal to our mid value then here we place a ball
            if(position[i]-distance>=mid){
                //so ball=ball+1;
                balls++;
                //now our next distance will be the current position value.because in next iteration we have to delete the current value with this distance
                distance=position[i];
            }
        }
        //now after the for loop we have to check if our placed balls value is greater than equal to given balls then return true else return false
        if(balls>=m){
            return true;
        }
        else 
          return false;
    }
}