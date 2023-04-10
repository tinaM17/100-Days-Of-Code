//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java


import java.io.*;
import java.util.*;


class MaxMinSum {
	public static void main (String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a[] = new int[n];
            
            for(int i=0;i<n;i++){
                a[i] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.findSum(a,n));
        }
        
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{ 
    public static int findSum(int A[],int N) 
    {
        int max= maxEle(A,N);
        int min=minEle(A,N);
        return (max+min);
    }
    
    public static int maxEle(int A[],int N){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            if(max<A[i]){
                max=A[i];
            }
        }
        return max;
        
    }
    public static int minEle(int A[],int N){
         int min=Integer.MAX_VALUE;
          for(int i=0;i<N;i++){
            if(min>A[i]){
                min=A[i];
            }
        }
        return min;
    }
}
