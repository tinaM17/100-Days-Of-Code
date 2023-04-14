package Day5;

class Solution {
    public int maxProfit(int[] prices) {
        //initialize to variable
        int maxProfit=0;
        int minSofar=prices[0];

        for(int i=0;i<prices.length;i++){
            //check the minimum element between current element and previous elements
            minSofar=Math.min(minSofar,prices[i]);
            //now calculate the profit of stock by subtracting current element with the minimum element
            int profit = prices[i]-minSofar;
            //step3 check the max profit between current profit and max profit
            maxProfit = Math.max(maxProfit,profit);
        }
        return maxProfit;
    }
}