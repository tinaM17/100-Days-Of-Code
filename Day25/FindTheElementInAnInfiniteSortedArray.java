package Day25;
import java.util.*;

public class FindTheElementInAnInfiniteSortedArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
            
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int key = sc.nextInt();    
        Solution ob = new Solution();
            
        System.out.println(ob.searchInfinte(a,key));   
        sc.close();
    }
    
}

class Solution {
    public int searchInfinte(int[] a,int key){
         int low=0, high=1;

         while(a[high]<key){
            low=high;
            high=2*high;
         }
         return binarySearch(a,key,low,high);
    }
     public int binarySearch(int[] a,int key,int low,int high){

         while(low<=high){
            int mid=(low+high)/2;
            if(a[mid]==key) return mid;
            if(key>a[mid])
               low=mid+1;
            else 
               high=mid-1;
         }
         return -1;
    }
}
