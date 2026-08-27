class Solution {
    public int maxProfit(int[] prices) {

        int buy=prices[0];
        int profit =0;
        for(int price:prices){
            if(price<buy){
                buy=price;
            }
            int curr =price-buy;
             profit =Math.max(curr,profit);
        }
        return profit;
        
    }
}