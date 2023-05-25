// Given a row wise sorted matrix of size R*C where R and C are always odd, find the median of the matrix.

// Example 1:

// Input:
// R = 3, C = 3
// M = [[1, 3, 5], 
//      [2, 6, 9], 
//      [3, 6, 9]]
// Output: 5
// Explanation: Sorting matrix elements gives 
// us {1,2,3,3,5,6,6,9,9}. Hence, 5 is median. 
 

// Example 2:

// Input:
// R = 3, C = 1
// M = [[1], [2], [3]]
// Output: 2
// Explanation: Sorting matrix elements gives 
// us {1,2,3}. Hence, 2 is median.

// Your Task:  
// You don't need to read input or print anything. Your task is to complete the function median() which takes the integers R and C along with the 2D matrix as input parameters and returns the median of the matrix.

// Expected Time Complexity: O(32 * R * log(C))
// Expected Auxiliary Space: O(1)


// Constraints:
// 1 <= R, C <= 400
// 1 <= matrix[i][j] <= 2000

package Day39;

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;


class MedianinarowwisesortedMatrix
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int median(int matrix[][], int R, int C) {
        //initialize our search space to start=0 and end=2000
        int start=0,end=2000;
        //our median will lie in row*col/2;
        int median=(R*C)/2;
        
        //while start less than equal to end do
        while(start<=end){
            //find mid value in the search space
            int mid=start+(end-start)/2;
            //initialize our count var to 0, this will holds the total number of elements less than equal to mid
            int count=0;
            //runs a for loop from 0 to row, here i use binary search to count the number of elements greater than mid in each row and sum up the numbers
            for(int i=0;i<R;i++){
                //initialize low=0 and high=C-1
                int low=0,high=C-1;
                while(low<=high){
                    //find mid index of each row
                    int middle=low+(high-low)/2;
                    //then check matrix of midindex less than the mid value then check for the right side search space so low=middle+1;
                    if(matrix[i][middle]<=mid) low=middle+1;
                    //else check for the leftt side search space so end=middle-1;
                    else high=middle-1;
                }
                //our low will holds the number of elements greater than mid in each row so sum up in count
                count+=low;
            }
            //Now check if count less than equal to median then increase the search space by start=mid+1;
            if(count<=median) start=mid+1;
            //else our search space will be end=mid-1
            else end=mid-1;
        }
        //now return the start value
        return start;
    }
}

