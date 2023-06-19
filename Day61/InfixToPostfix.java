// Given an infix expression in the form of string str. Convert this infix expression to postfix expression.

// Infix expression: The expression of the form a op b. When an operator is in-between every pair of operands.
// Postfix expression: The expression of the form a b op. When an operator is followed for every pair of operands.
// Note: The order of precedence is: ^ greater than * equals to / greater than + equals to -. 
// Example 1:

// Input: str = "a+b*(c^d-e)^(f+g*h)-i"
// Output: abcd^e-fgh*+^*+i-
// Explanation:
// After converting the infix expression 
// into postfix expression, the resultant 
// expression will be abcd^e-fgh*+^*+i-
// Example 2:

// Input: str = "A*(B+C)/D"
// Output: ABC+*D/
// Explanation:
// After converting the infix expression 
// into postfix expression, the resultant 
// expression will be ABC+*D/
 
// Your Task:
// This is a function problem. You only need to complete the function infixToPostfix() that takes a string(Infix Expression) as a parameter and returns a string(postfix expression). The printing is done automatically by the driver code.

// Expected Time Complexity: O(|str|).
// Expected Auxiliary Space: O(|str|).

package Day61;

//{ Driver Code Starts
import java.util.*;
import java.io.*;

class InfixToPostfix {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        //Create an object of StringBuilder to concatinate the resultant string
       StringBuilder postfix = new StringBuilder();
       //Create a stack object
        Stack<Character> stack = new Stack<>();

        //Run a for loop to iterate over the string and change it as a character array by using toCharArray()
        for (char ch : exp.toCharArray()) {
            //Step1:- Now check if the current char is a letter or digit then simply append it with postfix StringBuilder
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            } 
            //Step2:- if the char is opening parenthesis then push it into the stack
            else if (ch == '(') {
                stack.push(ch);
            } 
            //Step3:- if the char is closing parenthesis then pop from the stack while we don't get a '(' braces and append it in postfix String 
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                //If we don't found any '(' braces then throw an exception
                if (!stack.isEmpty() && stack.peek() != '(') {
                    throw new IllegalArgumentException("Invalid infix expression: Mismatched parentheses");
                }
                //Now Discard the opening parenthesis
                stack.pop();
            } 
            //Step4:- If the char is a operator then check it's precedence
            else { // Operator encountered
               //while stack is not empty and precedence of the current char is less than equal to the top operator in the stack then
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    //check if the peek() operator is a '(' braces then throw exception
                    if (stack.peek() == '(') {
                        throw new IllegalArgumentException("Invalid infix expression: Mismatched parentheses");
                    }
                    //else just pop the operator and append it to the string
                    postfix.append(stack.pop());
                }
                //If stack is empty or precedence is greater then simply push into the stack
                stack.push(ch);
            }
        }
        //After the for loop we traverse entire the string now while the stack is not empty pop the char from the stack and append it with the string
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                throw new IllegalArgumentException("Invalid infix expression: Mismatched parentheses");
            }
            postfix.append(stack.pop());
        }

        //Finally return the postfix string
        return postfix.toString();
    }

    //Method to check the precedence of the operator
    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

}