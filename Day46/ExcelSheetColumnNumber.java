// Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.

// For example:

// A -> 1
// B -> 2
// C -> 3
// ...
// Z -> 26
// AA -> 27
// AB -> 28 
// ...
 

// Example 1:

// Input: columnTitle = "A"
// Output: 1
// Example 2:

// Input: columnTitle = "AB"
// Output: 28
// Example 3:

// Input: columnTitle = "ZY"
// Output: 701

package Day46;

class Solution {
    public int titleToNumber(String columnTitle) {
        // Initialize the columnNumber result...
        int columnNumber=0;
        // Traverse the whole string through the loop...
        for(int i=0;i<columnTitle.length();i++){
            //In the first loop in columnNumber we have 0, so 0*26=0 then add the first alphabet value. If the loop ends then return the columnNumber but if not then for the 2nd iteration we have multiply 26 in the column number then add the alphabet value.
            columnNumber*=26;
            columnNumber+=columnTitle.charAt(i)-'A'+1;
        }
        return columnNumber;
    }
}
