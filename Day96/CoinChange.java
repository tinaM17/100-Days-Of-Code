// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

// Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

// You may assume that you have an infinite number of each kind of coin.

// Example 1:

// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1
// Example 2:

// Input: coins = [2], amount = 3
// Output: -1
// Example 3:

// Input: coins = [1], amount = 0
// Output: 0

package Day96;

class Solution {
    public int coinChange(int[] coins, int amount) {
        // Create an array to store minimum number of coins needed for each amount.
        int dp[] = new int[amount + 1];
        
        // Initialize the array with a value greater than the maximum possible coins needed.
        Arrays.fill(dp, amount + 1);
        
        // Base case: To make an amount of 0, 0 coins are needed.
        dp[0] = 0;

        // Iterate through each amount from 1 to the target amount.
        for (int i = 1; i <= amount; i++) {
            // For each coin denomination in the set of coins.
            for (int coin : coins) {
                // Check if subtracting the current coin value from the current amount is valid.
                if (i - coin >= 0) {
                    // Update the minimum coins needed for the current amount.
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        // Return -1 if it's not possible to make the target amount using the given coins.
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

