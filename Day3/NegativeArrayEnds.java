package Day3;

import java.io.*;

class NegativeArrayEnds {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            obj.segregateElements(a, n);
            
            for(int i=0;i<n;i++)
            System.out.print(a[i]+" ");
            
            System.out.println();
        }
	}
}



//solution class for our main functionality

class Solution {
    
    public void segregateElements(int arr[], int n)
    {
        int temp[]=new int[n];
        //taking an empty array to temporarily store our data
        int j=0;  //index of temp
        
        for(int i=0;i<n;i++){ //running a for loop from 0 to n-1 to store positive values
            if(arr[i]>=0){ 
                // if the elements is positive then add this into our temp array
                temp[j++]= arr[i];
            }
        }
        
        if(j==n || j==0){
            return;   //if the array contains only positive or only negative number then return the actual array
        }
        
        for(int i=0;i<n;i++){ //running a for loop from 0 to n-1 to store negative values
            if(arr[i]<0){ 
                // if the elements is negative then add this into our temp array
                temp[j++]= arr[i];
            }
        }
        
        // Copy elements of temp[] to arr[]
        for (int i = 0; i < n; i++)
            arr[i] = temp[i];
    }
}