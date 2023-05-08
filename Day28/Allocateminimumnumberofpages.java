// You have N books, each with Ai number of pages. M students need to be allocated contiguous books, with each student getting at least one book. Out of all the permutations, the goal is to find the permutation where the student with the most pages allocated to him gets the minimum number of pages, out of all possible permutations.

// Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).


// Example 1:

// Input:
// N = 4
// A[] = {12,34,67,90}
// M = 2
// Output:113
// Explanation:Allocation can be done in 
// following ways:
// {12} and {34, 67, 90} Maximum Pages = 191
// {12, 34} and {67, 90} Maximum Pages = 157
// {12, 34, 67} and {90} Maximum Pages =113.
// Therefore, the minimum of these cases is 113,
// which is selected as the output.

// Example 2:

// Input:
// N = 3
// A[] = {15,17,20}
// M = 2
// Output:32
// Explanation: Allocation is done as
// {15,17} and {20}

package Day28;

//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.util.*;
public class Allocateminimumnumberofpages {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
        sc.close();
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
       //maximum of the array
       int min=max(A,N);
       //sum of all the number
       int max=sum(A,N);
       //initialize res var to 0
       int res=0;
       //if the length of the array is greater than the no.of students then return -1;
       if(M>N) return -1;
       
       while(min<=max){
           //find the mid value of min and max
           int mid=(min+max)/2;
           //now check the mid value is feasible for the number of student or not
           if(isFeasible(A,N,M,mid)){
               //if feasible then store the value into our res var and decrease our search space to find a better minimum mid
               //so our new max=mid-1;
               res=mid;
               max=mid-1;
           }
           else
              //else it is not feasible so we have to discard our mid's left side and search on the right.so new min=mid+1;
              min=mid+1;
       }
       //after the loop return the res;
       return res;
    }
    //function to check our maximum number of pages could be divided by M number of student or not
    
    public static boolean isFeasible(int[] A,int N,int M,int mid){
        //initialize our student var=1 and sum=0;
        int student=1,sum=0;
        //runs a loop to iterate the array
        for(int i=0;i<N;i++){
            //check the current sum+current element is greater than mid then we need one more student to distribute
            if(sum+A[i]>mid){
                //so student=student+1 and new sum=current number
                student++;
                sum=A[i];
            }
            //else sum+current element less than mid so we can distribute this book to our current student
            else {
                sum+=A[i];
            }
        }
        //now check student is less than equal to given student then return true else false;
        return student<=M;
    }
    
    //function to find maximum number in the array
    public static int max(int[] A,int N){
        int maxi=Integer.MIN_VALUE;
        
        for(int i=0;i<N;i++){
            if(A[i]>maxi){
                maxi=A[i];
            }
        }
        return maxi;
    }
    //function to find sum of all the number in the array
    public static int sum(int[] A,int N){
        int ans=0;
        
        for(int i=0;i<N;i++){
            ans+=A[i];
        }
        return ans;
    }
};
