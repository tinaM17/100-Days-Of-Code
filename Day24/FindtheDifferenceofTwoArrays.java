// Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:

// answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
// answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
// Note that the integers in the lists may be returned in any order.

 

// Example 1:

// Input: nums1 = [1,2,3], nums2 = [2,4,6]
// Output: [[1,3],[4,6]]
// Explanation:
// For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
// For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].
// Example 2:

// Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
// Output: [[3],[]]
// Explanation:
// For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
// Every integer in nums2 is present in nums1. Therefore, answer[1] = [].

package Day24;
import java.util.*;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        //creating two hash sets to store unique values from the two array
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        //This is our answer list
        List<List<Integer>> answer=new ArrayList<>();

        //put all the values of array2 in set1
        for(int i=0;i<nums1.length;i++){
            set1.add(nums1[i]);
        }
        //put all the values of array1 in set2
        for(int i=0;i<nums2.length;i++){
            set2.add(nums2[i]);
        }
        //Now creating two lists which store our distinct integers in nums1 and nums2
        List<Integer> temp1=new ArrayList<>();
        List<Integer> temp2=new ArrayList<>();
        //iterate over set 1, now check if the num of set1 is not present in set2 then add the num into our list1
        for(int num:set1){
            if(!set2.contains(num)){
                temp1.add(num);
            }
        }
      
        //iterate over set 2, now check if the num of set2 is not present in set1 then add the num into our list2
        for(int num:set2){
            if(!set1.contains(num)){
                temp2.add(num);
            }
        }
        //Now add both the lists into our final list of list and return the answer
        answer.add(temp1);
        answer.add(temp2);

        return answer;
    }
}