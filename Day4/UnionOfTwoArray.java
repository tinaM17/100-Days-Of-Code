package Day4;

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
class UnionOfTwoArray {
	public static void main (String[] args) {
	    
	    //Taking input using class Scanner
		Scanner sc=new Scanner(System.in);
		
		//Taking total count of testcases
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    
		    int n,m;
		    
		    //taking size of array a
		    n=sc.nextInt();
		    
		    //taking size of array b
		    m=sc.nextInt();
		    
		    //Creating 2 array of size n and m
		    int a[]=new int[n];
		    int b[]=new int[m];
		    
		    //inserting elements to array a
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    
		    //inserting elements to array b
		    for(int i=0;i<m;i++)
		    {
		        b[i]=sc.nextInt();
		    }
		    Solution ob=new Solution();
		    //calling doUnion method and printing the results
		    System.out.println(ob.doUnion(a,n,b,m));
		}

        sc.close();
		
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int doUnion(int a[], int n, int b[], int m) 
    {
        HashSet<Integer> set = new HashSet<>();
        //creating a hash set to store the unique elements of array b
        
        for(int i=0;i<m;i++){
            set.add(b[i]);
            //runs a for loop to store all the unique elements of array b
        }
        
        for(int i=0;i<n;i++){
            //again runs a for loop to check if the elements of the array a present in the hash set or not
            if(!set.contains(a[i])){
                //if the element is not present then add this into our hashset
                set.add(a[i]);
            }
        }
        
        //so now return the size of the hash set because the set contains union of two arrays with unique no's
        return set.size();
    }
}
