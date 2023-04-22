// Reverse bits of a given 32 bits unsigned integer.

// Note:

// Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
// In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.
 

// Example 1:

// Input: n = 00000010100101000001111010011100
// Output:    964176192 (00111001011110000010100101000000)
// Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
// Example 2:

// Input: n = 11111111111111111111111111111101
// Output:   3221225471 (10111111111111111111111111111111)
// Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.

package Day13;

class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
         int res =0;
        for(int i =0;i<32;i++) {
            //this is used to find least significant digit (lsb)
            // 00000010100101000001111010011100 & 1 = 00000010100101000001111010011100<- lsb =0
            int lsb = n & 1;

            // so, now we have to left shift our lsb in 31-ith position to get our reverse digit
            int revLsb = lsb<<(31-i);
           // now to store the revLsb in our result variable we have to do OR/'+' operation between res & revLsb, because in every iteration we got a new 32bits int. 
            res = res|revLsb; //res+revLsb both works fine

            // right sift of n , to discard one bit in one loop
            n= n>>1;
        }
        return res;
            
        }
}
