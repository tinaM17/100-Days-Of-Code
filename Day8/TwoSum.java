package Day8;
import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        //creating a hashmap for storing the value as well as index number of our array
        Map<Integer,Integer> map=new HashMap<>(); 

        for(int i=0;i<nums.length;i++){
            //check if target-nums[i] is present in the map or not
            if(map.containsKey(target-nums[i])){
                //if present then add the indices into our resultant array
                result[0]=map.get(target-nums[i]);
                result[1]=i;
            }
            //if not present then add this value and index number into the hashmap
            else {
                map.put(nums[i],i);
            }
        }
        return result;
    }
}
