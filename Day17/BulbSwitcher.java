// There are n bulbs that are initially off. You first turn on all the bulbs, then you turn off every second bulb.

// On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb.

// Return the number of bulbs that are on after n rounds.

// Example 1:

// Input: n = 3
// Output: 1
// Explanation: At first, the three bulbs are [off, off, off].
// After the first round, the three bulbs are [on, on, on].
// After the second round, the three bulbs are [on, off, on].
// After the third round, the three bulbs are [on, off, off]. 
// So you should return 1 because there is only one bulb is on.
// Example 2:

// Input: n = 0
// Output: 0
// Example 3:

// Input: n = 1
// Output: 1



package Day17;

class Solution {
    public int bulbSwitch(int n) {
        //Ex1:- n=4
        //i=1, on,on,on,on
        //i=2, on,off,on,off
        //i=3, on,off,off,off
        //i=4, on,off,off,on
        //so ans is 2 because 2 bulbs are on.i.e; square root of 4=2
        
        //Another example,Ex2:- n=6
        //i=1, on,on,on,on,on,on
        //i=2, on,off,on,off,on,off
        //i=3, on,off,off,off,on,on
        //i=4, on,off,off,on,on,on
        //i=5, on,off,off,on,off,on
        //i=6, on,off,off,on,off,off
        //so ans is 2 because 2 bulbs are on.i.e; square root of 6=2


        return (int)Math.sqrt(n);
    }
}
