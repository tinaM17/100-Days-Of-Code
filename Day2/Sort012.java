package Day2;

//{ Driver Code Starts
//Initial template for Java

import java.io.*;


// } Driver Code Ends
//User function template for Java

class Solution
{
    public void sort012(int a[], int n)
    {
        int temp;
        //taking 3 pointers as low, mid and high
        int low=0;
        int mid=0;
        int high=n-1;
        
        //runs the loop while mid value less than or equal to high value
        while(mid<=high){
            //if array of mid value=0 then swap it with array of low. because here we use dutch national flag algorithm
            //in this algo 0 lies between index 0 to low-1, 
            //1 lies btw index low to mid-1
            //2 lies btw index high+1 to n
            if(a[mid]==0){
                temp=a[mid];
                a[mid]=a[low];
                a[low]=temp;
                low++;
                mid++;
            }
            //if array of mid value=1 then increment mid
            else if(a[mid]==1){
                mid++;
            }
            //if array of mid value=2 then swap it with array of high. then decrement high
            else {
                temp=a[mid];
                a[mid]=a[high];
                a[high]=temp;
                high--;
            }
        }
    }
}

//{ Driver Code Starts.

class Sort012 {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob=new Solution();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}


