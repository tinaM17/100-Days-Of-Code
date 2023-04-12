package Day3;
import java.util.*;

//User function Template for Java

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        //creating a hashset to store the values of nums2 array
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums2.length;i++){
            set.add(nums2[i]);  //storing the values
        }
         HashSet<Integer> ans_set=new HashSet<>(); //creating another main hash set to store our common values btw two arrays
        for(int i=0;i<nums1.length;i++){
            //check if the first hashset contains the same value of nums1 array
            if(set.contains(nums1[i])){
                //if return true then add the value into our main hashset
                ans_set.add(nums1[i]);
            }
        }
        //initialize our main array that we have to return 
        int ans[] = new int[ans_set.size()];
        //index of the array
        int j = 0;
        for (Integer val : ans_set) {
            //copying the values into array from main hashset
            ans[j] = val.intValue();
            j++;
        }
        return ans;
    }
}
