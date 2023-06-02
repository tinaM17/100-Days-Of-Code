// Given an integer n, return a string array answer (1-indexed) where:

// answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
// answer[i] == "Fizz" if i is divisible by 3.
// answer[i] == "Buzz" if i is divisible by 5.
// answer[i] == i (as a string) if none of the above conditions are true.
 

// Example 1:

// Input: n = 3
// Output: ["1","2","Fizz"]
// Example 2:

// Input: n = 5
// Output: ["1","2","Fizz","4","Buzz"]
// Example 3:

// Input: n = 15
// Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]

package Day46;
import java.util.*;

class Solution {
    public List<String> fizzBuzz(int n) {
        //create a list to store our answer
        List<String> ans=new ArrayList<>();
        //Runs a for loop from 1 to n
        for(int i=1;i<=n;i++){
            //if i is divisible by 3 & 5 then add "FizzBuzz" to list
            if(i%3==0 && i%5==0){
                ans.add("FizzBuzz");
            }
            //else if i is divisible by 3 then add "Fizz" to list
            else if(i%3==0){
                ans.add("Fizz");
            }
            //else if i is divisible by 5 then add "Buzz" to list
            else if(i%5==0)
            {
                ans.add("Buzz");
            }
            //else add the string value of i into the list
            else {
                ans.add(Integer.toString(i));
            }
        }
        return ans;
    }
}
