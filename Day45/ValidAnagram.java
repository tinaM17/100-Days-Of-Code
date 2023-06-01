// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

// Example 1:

// Input: s = "anagram", t = "nagaram"
// Output: true
// Example 2:

// Input: s = "rat", t = "car"
// Output: false

package Day45;
import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        //if the length of the two strings are not equal means they are not anagram so return false
        if(s.length()!=t.length())
           return false;
        //create a hashmap to the frequency of the characters of the string
        HashMap<Character,Integer> map=new HashMap<>();
        //run a for loop to iterate over the character of string s
        for(int i=0;i<s.length();i++){
            //put the character as well as the frequencies into the map
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        //again runs a for loop to iterate over the character of string t
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            //now check each character of string t has present in the map or not. if present then check their frequencies if it is 1 then delete the character else frequency-1;
            if(map.get(ch)!=null){
                if(map.get(ch)==1){
                    map.remove(ch);
                }
                else 
                  map.put(ch,map.get(ch)-1);
            }
            //if the character is not present in the map means t has some extra characters so return false
            else {
                return false;
            }
        }
        //after the loop check the map is empty or not
        //if empty return true else false
        return map.isEmpty();
    }
}
