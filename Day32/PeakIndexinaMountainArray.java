// An array arr a mountain if the following properties hold:

// arr.length >= 3
// There exists some i with 0 < i < arr.length - 1 such that:
// arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
// arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
// Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].

// You must solve it in O(log(arr.length)) time complexity.

 

// Example 1:

// Input: arr = [0,1,0]
// Output: 1
// Example 2:

// Input: arr = [0,2,1,0]
// Output: 1
// Example 3:

// Input: arr = [0,10,5,2]
// Output: 1

package Day32;

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        //initialize low=0 and high=length of the array-1
        int low=0,high=arr.length-1,ans=-1;

        while(low<high){
            //find mid of our current part
            int mid=low+(high-low)/2;
            //if arr[mid] greater than it's next element then our mid can be our answer so store it in ans var and also we have to reduce our search space by high=mid because our mid can be our answer so our high can not be mid+1
            if(arr[mid]>arr[mid+1]){
                ans=mid;
                high=mid;
            }
            //else our mid+1 can be our answer so store it in ans var and also we have to reduce our search space by low=mid+1 because our mid+1 can be our answer.
            else {
                ans=mid+1;
                low=mid+1;
            }
        }
        //now return the ans
        return ans;
    }
}
