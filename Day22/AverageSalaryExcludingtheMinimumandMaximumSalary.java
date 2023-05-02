// You are given an array of unique integers salary where salary[i] is the salary of the ith employee.

// Return the average salary of employees excluding the minimum and maximum salary. Answers within 10-5 of the actual answer will be accepted.

 

// Example 1:

// Input: salary = [4000,3000,1000,2000]
// Output: 2500.00000
// Explanation: Minimum salary and maximum salary are 1000 and 4000 respectively.
// Average salary excluding minimum and maximum salary is (2000+3000) / 2 = 2500
// Example 2:

// Input: salary = [1000,2000,3000]
// Output: 2000.00000
// Explanation: Minimum salary and maximum salary are 1000 and 3000 respectively.
// Average salary excluding minimum and maximum salary is (2000) / 1 = 2000

package Day22;
import java.util.*;

class Solution {
    public double average(int[] salary) {
        //sort the array first then our first index will be our min salary and last will be our max
        Arrays.sort(salary);
        int sum=0;
        int length=salary.length;
        //runs a for loop from 1 to n-2 because we have to exclude our min and max salary
        for(int i=1;i<length-1;i++){
            //now sum up our all salaries except min and max salary
             sum+=salary[i];
        }
        //now divide our total salary with n-2 to get our average salary
        return (double)sum/(length-2);
    }
}
