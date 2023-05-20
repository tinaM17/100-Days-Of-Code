// We are playing the Guess Game. The game is as follows:

// I pick a number from 1 to n. You have to guess which number I picked.

// Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

// You call a pre-defined API int guess(int num), which returns three possible results:

// -1: Your guess is higher than the number I picked (i.e. num > pick).
// 1: Your guess is lower than the number I picked (i.e. num < pick).
// 0: your guess is equal to the number I picked (i.e. num == pick).
// Return the number that I picked.

 

// Example 1:

// Input: n = 10, pick = 6
// Output: 6
// Example 2:

// Input: n = 1, pick = 1
// Output: 1
// Example 3:

// Input: n = 2, pick = 1
// Output: 1

package Day33;

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        //The number is between 1 to n so, initialize our low=1 and high=n;
        int low=1,high=n;
        
        while(low<=high){
            //find the mid first to check if mid==pick number
            int mid=low+(high-low)/2;
            //call the guess() and it returns a int value 0,1,or -1
            int res=guess(mid);
            //if it returns 0 means mid is the guessing number so return mid
            if(res==0) return mid;
            //else if it returns 1 means our mid less than the guessing number so we have to search the right side so new low=mid+1
            if(res==1) low=mid+1;
            //else search on the left side so high=mid+1
            else  high=mid-1;
        }
        //if not found then return -1
        return -1;
    }
}
