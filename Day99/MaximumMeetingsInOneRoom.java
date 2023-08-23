// There is one meeting room in a firm. There are N meetings in the form of (S[i], F[i]) where S[i] is the start time of meeting i and F[i] is the finish time of meeting i. The task is to find the maximum number of meetings that can be accommodated in the meeting room. You can accommodate a meeting if the start time of the meeting is strictly greater than the finish time of the previous meeting. Print all meeting numbers.

// Note: If two meetings can be chosen for the same slot then choose meeting with smaller index in the given array.

// Example 1:

// Input:
// N= 6
// S = {1,3,0,5,8,5}
// F = {2,4,6,7,9,9} 
// Output:
// {1,2,4,5}
// Explanation:
// We can attend the 1st meeting from (1 to 2),
// then the 2nd meeting from (3 to 4), then the
// 4th meeting from (5 to 7), and the last meeting
// we can attend is the 5th from (8 to 9). It can
// be shown that this is the maximum number of
// meetings we can attend.
 

// Example 2:

// Input:
// N= 1
// S = {3}
// F = {7}
// Output:
// {1}
// Explanation:
// Since there is only one meeting, we can attend the meeting.
 
// Your Task:

// You don't need to read input or print anything. Your task is to complete the function maxMeetings() which takes the arrays S[], F[], and its size N as inputs and returns the meeting numbers we can attend in sorted order.

// Expected Time Complexity: O(N*log(N))
// Expected Auxiliary Space: O(N)

package Day99;

//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N; 
            N = Integer.parseInt(br.readLine());
            
            
            int[] S = IntArray.input(br, N);
            
            
            int[] F = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.maxMeetings(N, S, F);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        ArrayList<Integer> ans = new ArrayList<>();

        // Create a 2D array to store meeting details: index, start time, and end time
        int sortedTime[][] = new int[N][3];

        // Fill the sortedTime array with meeting details
        for (int i = 0; i < N; i++) {
            sortedTime[i][0] = i + 1; // Meeting index
            sortedTime[i][1] = S[i]; // Meeting start time
            sortedTime[i][2] = F[i]; // Meeting end time
        }

        // Sort the meetings based on end times in ascending order
        Arrays.sort(sortedTime, Comparator.comparingInt(obj -> obj[2]));

        int endTime = sortedTime[0][2]; // Initialize end time with the first meeting's end time
        ans.add(sortedTime[0][0]); // Add the index of the first meeting to the answer list

        // Iterate through the sorted meetings to find the maximum number of non-overlapping meetings
        for (int i = 1; i < N; i++) {
            if (sortedTime[i][1] > endTime) {
                endTime = sortedTime[i][2]; // Update end time if the current meeting doesn't overlap
                ans.add(sortedTime[i][0]); // Add the index of the non-overlapping meeting to the answer list
            }
        }

        Collections.sort(ans); // Sort the answer list

        return ans; // Return the list of indices of selected non-overlapping meetings
    }
}

