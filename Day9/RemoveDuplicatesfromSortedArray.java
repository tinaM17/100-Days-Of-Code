package Day9;

class Solution {
    public int removeDuplicates(int[] nums) {
        int index=1;
        //because the first element will be always present in the new unique array
        for(int i=0;i<nums.length-1;i++){
            //runs a loop from 0 to length-2; because in each loop we also calculte the i+1th value also

            if(nums[i]<nums[i+1]){
                //if the current element is less than the next element
                nums[index]=nums[i+1];
                //move the next element to our new index to store the unique values
                index++;
                //increment index by one to store the new value in the next iteration
            }
        }
        //return index which is the new size of our unique array
        return index;
    }
}
