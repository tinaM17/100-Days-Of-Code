// You are given an array consisting of n integers which denote the position of a stall. You are also given an integer k which denotes the number of aggressive cows. You are given the task of assigning stalls to k cows such that the minimum distance between any two of them is the maximum possible.
// The first line of input contains two space-separated integers n and k.
// The second line contains n space-separated integers denoting the position of the stalls.

// Example 1:

// Input:
// n=5 
// k=3
// stalls = [1 2 4 8 9]
// Output:
// 3
// Explanation:
// The first cow can be placed at stalls[0], 
// the second cow can be placed at stalls[2] and 
// the third cow can be placed at stalls[3]. 
// The minimum distance between cows, in this case, is 3, 
// which also is the largest among all possible ways.
// Example 2:

// Input:
// n=5 
// k=3
// stalls = [10 1 2 7 5]
// Output:
// 4
// Explanation:
// The first cow can be placed at stalls[0],
// the second cow can be placed at stalls[1] and
// the third cow can be placed at stalls[4].
// The minimum distance between cows, in this case, is 4,
// which also is the largest among all possible ways.
// Your Task:
// Complete the function int solve(), which takes integer n, k, and a vector stalls with n integers as input and returns the largest possible minimum distance between cows.

// Expected Time Complexity: O(n*log(10^9)).
// Expected Auxiliary Space: O(1).


package Day30;
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class AggressiveCows {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int solve(int n, int k, int[] stalls) {
        //Sort the array first to apply our binary search algo
        Arrays.sort(stalls);
        //initialize our low=0 and high=max value of the stallls
        int low=0;
        int high=stalls[n-1];
        
        int ans=0;
        
        while(low<high){
            //find the mid first
            int mid=(low+high)/2;
            //then check can we place all the cows with respect to the mid distance
            if(isPossible(n,k,stalls,mid)){
                //if possible then it could be our answer so store it in ans variable
                ans=mid;
                //and also increase our search space because we have to find the min of max distance btw them 
                low=mid+1;
            }
            //else for the current mid value we can not placed all the cows so, also for greater values we can not place the cows. so we have reduce our search space by high=mid;
            else {
                high=mid;
            }
        }
        //now return our answer
        return ans;
    }
    
    //method to check for a mid value all the cows can be placed or not
    public static boolean isPossible(int n, int k, int[] stalls,int mid){
        //initialize cows variable to 1
        int cows=1;
        //our distance will be counting from the first stall
        int distance=stalls[0];
        //iterate over all the stalls
        for(int i=1;i<n;i++){
            //if the current stalls - distance greater than equal to our mid value then here we place a cow
            if(stalls[i]-distance>=mid){
                //so cow=cow+1;
                cows++;
                //now our next distance will be the current stall value.because in next iteration we have to delete the current value with this distance
                distance=stalls[i];
            }
        }
        //now after the for loop we have to check if our placed cows value is greater than equal to given cows then return true else return false
        if(cows>=k){
            return true;
        }
        else 
          return false;
    }
}