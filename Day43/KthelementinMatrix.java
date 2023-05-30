// Given a N x N matrix, where every row and column is sorted in non-decreasing order. Find the kth smallest element in the matrix.

// Example 1:
// Input:
// N = 4
// mat[][] =     {{16, 28, 60, 64},
//                    {22, 41, 63, 91},
//                    {27, 50, 87, 93},
//                    {36, 78, 87, 94 }}
// K = 3
// Output: 27
// Explanation: 27 is the 3rd smallest element.
 

// Example 2:
// Input:
// N = 4
// mat[][] =     {{10, 20, 30, 40}
//                    {15, 25, 35, 45}
//                    {24, 29, 37, 48}
//                    {32, 33, 39, 50}}
// K = 7
// Output: 30
// Explanation: 30 is the 7th smallest element.


// Your Task:
// You don't need to read input or print anything. Complete the function kthsmallest() which takes the mat, N and K as input parameters and returns the kth smallest element in the matrix.
 

// Expected Time Complexity: O(K*Log(N))
// Expected Auxiliary Space: O(N)

package Day43;
//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
class KthelementinMatrix{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=Integer.parseInt(sc.next());
		while(t>0)
		{
			int n=Integer.parseInt(sc.next());
			int[][] a=new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
    				a[i][j]=Integer.parseInt(sc.next());
    		
			int k=Integer.parseInt(sc.next());
		    Solution ob = new Solution();
		    System.out.println(ob.kthSmallest(a,n,k));
		    
		    t--;
		}
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
	public static int kthSmallest(int[][]mat,int n,int k)
	{
	    //initialize low=matrix 1st value which is the lowest value and high=matrix last value which is the highest value
        int low=mat[0][0];
        int high=mat[n-1][n-1];
        int midValue=0;
        
        //while low less than high do this,
        while(low<high){
            //find the mid value of this low,high range
            midValue=(high+low)/2;
            int count=0;
            //Now we have to check how many numbers are less than and equal to this mid value
            //for this we runs a loop over the each row and check how many numbers lie btw this mid value here we use binary search to count the number
            for(int i=0;i<n;i++){
                //so our start will be the 0 index and end will be the last index i,e; n-1
                int start=0,end=n-1;
                //again runs a while loop
                while(start<=end){
                    //find the mid index btw them
                    int mid=(end+start)/2;
                    //now check if the value of the mid index is less than or equal to our midValue the we have increase our search space so start will be mid+1
                    if(mat[i][mid]<=midValue){
                        start=mid+1;
                    }
                    //else decrease the search space by end=mid-1
                    else {
                        end=mid-1;
                    }
                }
                //so after the while loop whenever our start points that value is the total count for this current row
                count+=start;
            }
            //Now after the for loop we get total number of count, so check if count is less than k means we have to increase our search space
            if(count<k){
                low=midValue+1;
            }
            //else decrease the search space by end=midValue;
            else 
               high=midValue;
        }
        //Now our low will points the kth smallest number so return low
        return low;
    }
}