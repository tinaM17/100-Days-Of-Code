package Day6;
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

  public class MinimizeTheHeights {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().getMinDiff(arr, n, k);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        //Step1:- we have to sort our array so we get our first element as sortest and last element as largest
        Arrays.sort(arr);
        
        //Step-2:- calculate the maximum height between smallest and largest tower
        int minHeight=arr[n-1]-arr[0];
        int max=0,min=0;
        
        //Step3:- runs a for loop from 1 to n-1. why 1 because we have calculate our previous index also
        for(int i=1;i<n;i++){
            //if value is >=k only then we perform our operation otherwise if we decrement the value then it goes to negative value
            if(arr[i]>=k){
                //Step4:- we have to find out our current max. so we know our max is the last element, but after adding k to the i-1 element we have check which is our current max now
                max=Math.max(arr[i-1]+k,arr[n-1]-k);
                //Step5:- we have to find out our current min. so we know our min is the first element, but after subtracting k to the ith element we have check which is our current min now
                min=Math.min(arr[i]-k,arr[0]+k);
                
                //Step6:- check if our current min height is minimum then previous one then update it
                minHeight=Math.min(minHeight,max-min);
            }
            else {
                continue;
            }
        }
        
        return minHeight;
        
    }
}

