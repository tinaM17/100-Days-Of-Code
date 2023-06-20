// Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

// Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

// Example 1:

// Input: s = "1 + 1"
// Output: 2
// Example 2:

// Input: s = " 2-1 + 2 "
// Output: 3
// Example 3:

// Input: s = "(1+(4+5+2)-3)+(6+8)"
// Output: 23

package Day62;
import java.util.*;

class Solution {
    public int calculate(String s) {
      Stack<Integer> stack = new Stack<Integer>(); // Stack to store intermediate results and signs
    int result = 0; // Accumulated result of the expression
    int number = 0; // Current number being processed
    int sign = 1; // Sign of the current number or expression

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);

        if (Character.isDigit(c)) {
            // Extend the current number by multiplying it by 10 and adding the current digit
            number = 10 * number + (int)(c - '0');
        } else if (c == '+') {
            // Add the current number to the result with the appropriate sign
            result += sign * number;
            number = 0; // Reset the number
            sign = 1; // Update the sign to positive
        } else if (c == '-') {
            // Add the current number to the result with the appropriate sign
            result += sign * number;
            number = 0; // Reset the number
            sign = -1; // Update the sign to negative
        } else if (c == '(') {
            // Store the current result and sign on the stack before processing the sub-expression
            stack.push(result);
            stack.push(sign);
            sign = 1; // Reset the sign for the sub-expression
            result = 0; // Reset the result for the sub-expression
        } else if (c == ')') {
            // Add the current number to the result with the appropriate sign
            result += sign * number;
            number = 0; // Reset the number
            
            // Multiply the result by the sign before the sub-expression
            result *= stack.pop();
            
            // Add the stored result from the stack to the current result
            result += stack.pop();
        }
    }

    if (number != 0) {
        // Add the remaining number to the result if it is not zero
        result += sign * number;
    }

    return result; // Return the final result
  }
}
