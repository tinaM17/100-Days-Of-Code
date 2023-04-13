package Day4;

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;

class CyclicallyRotateByOne {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Compute obj = new Compute();
            obj.rotate(a, n);
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<n;i++)
                output.append(a[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Compute {
    
    public void rotate(int arr[], int n)
    {
        //create a temporary array to store our rotated array's data
        int temp[]=new int[n];
        
        for(int i=0;i<n;i++){ //runs a for loop for 0 to n-1
        
            temp[(i+1)%n]=arr[i];  // add one to our current index and module division it by n then we get our
            //perfect position to place our data into the temp array
        }
        
        for(int i=0;i<n;i++){
            //copying the elements to temp to our main array
            arr[i]=temp[i];
        }
    }
}
