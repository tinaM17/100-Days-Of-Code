// Given an integer numRows, return the first numRows of Pascal's triangle.

// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

//               1
//             1   1
//           1   2   1
//         1   3   3    1
//       1   4   6   4    1  

// Example 1:

// Input: numRows = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// Example 2:

// Input: numRows = 1
// Output: [[1]]


package Day15;
import java.util.*;
class Solution {
    public List<List<Integer>> generate(int numRows) {
        // Create an array list to store the output result...
        List<List<Integer>> result = new ArrayList<>();
        // Base cases...
	    if (numRows <= 0)  return result;
        // Create an array list to store the prev triangle value for further addition...
	    ArrayList<Integer> prev = new ArrayList<>();
        // Inserting for the first row & store the prev array to the output array...
	    prev.add(1);
	    result.add(prev);
        // For rest of the rows, Traverse all elements through a for loop...
	    for (int i = 2; i <= numRows; i++) {
            // Create another array to store the current triangle value...
		    ArrayList<Integer> curr = new ArrayList<>();
		    curr.add(1);    //first
            // Calculate for each of the next values...
		    for (int j = 0; j < prev.size() - 1; j++) {
                // Inserting the addition of the prev arry two values...
			    curr.add(prev.get(j) + prev.get(j + 1));    //middle
		    }
            // Store the number 1...
		    curr.add(1);    //last
            // Store the value in the Output array...
		    result.add(curr);
            // Set prev is equal to curr...
		    prev = curr;
	    }
	    return result;      // Return the output list of pascal values...
    }
}
