
/* Here i use priority queue for solving this problem */

import java.io.*;
import java.util.*;
class KthSmallestElement {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    int k=sc.nextInt();
		    Solution ob = new Solution();
		    out.println(ob.kthSmallest(arr,0, n-1, k));
		}
		out.flush();
        sc.close();
	}
}



//solution class for our main functionality

class Solution{
    public int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        //creating a max heap of size k

        for(int i=l;i<k;i++){  
            pq.add(arr[i]);  //adding the elements into our max heap
        }
        
        for(int i=k;i<=r;i++){   //then from kth index to last index check if there exist a small number then add this into our queue and remove the previous top element first
            if(pq.peek()>arr[i]){
                pq.remove();
                pq.add(arr[i]);
            }
        }
        //after running the loop we can get our kth smallest element in the top of our max heap
        return pq.peek();
    } 
}
