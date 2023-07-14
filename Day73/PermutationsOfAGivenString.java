package Day73;

//{ Driver Code Starts
import java.util.*;
import java.io.*;
public class PermutationsOfAGivenString
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        List<String> ans = new ArrayList<>(); // List to store the unique permutations
        permutation(S.toCharArray(), 0, S.length() - 1, ans); // Call the recursive permutation function
        Collections.sort(ans); // Sort the result list
        return ans; // Return the sorted list of permutations
    }

    // Recursive function to generate permutations
    private void permutation(char[] s, int l, int r, List<String> res) {
        if (l == r) {
            res.add(String.valueOf(s)); // Found a unique permutation, add it to the result list
            return;
        }
        for (int i = l; i <= r; i++) {
            if (!shouldSwap(s, l, i))
                continue; // Skip duplicate characters to avoid redundant permutations
            swap(s, l, i); // Swap the current character with the next character
            permutation(s, l + 1, r, res); // Recursively generate permutations for the remaining characters
            swap(s, l, i); // Restore the original order by swapping back
        }
    }

    // Check if swapping characters is required to avoid duplicates
    private boolean shouldSwap(char[] s, int start, int end) {
        for (int i = start; i < end; i++) {
            if (s[i] == s[end]) {
                return false; // If a duplicate character is found, no swapping should be done
            }
        }
        return true; // Swapping is allowed as no duplicate characters were found
    }

    // Utility function to swap characters at indices i and j
    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}

