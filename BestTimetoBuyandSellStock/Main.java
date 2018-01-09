package BestTimetoBuyandSellStock;

public class Main {
}
class Solution {
    public int maxProfit(int[] prices) {
        int max_value = Integer.MAX_VALUE;
        int result = 0;
        for(int i=0;i<prices.length;i++)
        {
            if(max_value > prices[i])
            {
                max_value = prices[i];
            }
            else{
                result = Math.max (prices[i] - max_value,result);
            }
        }
        return result;
    }
}