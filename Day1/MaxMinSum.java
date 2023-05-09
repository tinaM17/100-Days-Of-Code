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
        sc.close();
        
	}
}

//Solution class for our main functionality

class Solution
{ 
    public int findSum(int A[],int N) 
    {
        int max= maxEle(A,N); //call the function to find the max
        int min=minEle(A,N); //call the function to find the min
        return (max+min); //return the sum of the max and min element
    }
    
    //Method for finding the max element of the array
    public static int maxEle(int A[],int N){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            if(max<A[i]){
                max=A[i];
            }
        }
        return max;
        
    }

    //Method for finding the min element of the array
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
