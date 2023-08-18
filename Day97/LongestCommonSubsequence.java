// Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

// A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

// For example, "ace" is a subsequence of "abcde".
// A common subsequence of two strings is a subsequence that is common to both strings.

 

// Example 1:

// Input: text1 = "abcde", text2 = "ace" 
// Output: 3  
// Explanation: The longest common subsequence is "ace" and its length is 3.
// Example 2:

// Input: text1 = "abc", text2 = "abc"
// Output: 3
// Explanation: The longest common subsequence is "abc" and its length is 3.
// Example 3:

// Input: text1 = "abc", text2 = "def"
// Output: 0
// Explanation: There is no such common subsequence, so the result is 0.

package Day97;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(); // Length of text1
        int n = text2.length(); // Length of text2
        
        int dp[][] = new int[m+1][n+1]; // Create a 2D DP array to store the maximum length of each subsequence characters
        
        return lcs(m, n, text1, text2, dp); // Return the result of LCS
    }

    // Function to compute Longest Common Subsequence (LCS)
    private int lcs(int m, int n, String text1, String text2, int dp[][]) {
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // If characters match, increment LCS length by diagonal cell value+1
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // Otherwise, choose the maximum from previous up or left cell position value
                }
            }
        }
        return dp[m][n]; // Return the last cell value which is the maximum LCS length for the given strings
    }
}

