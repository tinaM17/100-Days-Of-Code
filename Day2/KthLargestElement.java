package Day2;

/* Here i use priority queue for solving this problem */

import java.io.*;
import java.util.*;
class KthLargestElement {
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
		    out.println(ob.findKthLargest(arr, k));
		}
		out.flush();
        sc.close();
	}
}



//solution class for our main functionality

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        //creating a min heap of size k

        for(int i=0;i<k;i++){
            pq.add(nums[i]); //adding the elements into our min heap
        }
        for(int i=k;i<nums.length;i++){ //then from kth index to last index check if there exist a greater number then add this into our queue and remove the previous top element first
            if(pq.peek()<nums[i]){
                pq.remove();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
        
    }
}