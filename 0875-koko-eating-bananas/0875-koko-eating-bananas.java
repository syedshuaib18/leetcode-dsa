class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min=1;
        int max=0;
        for(int  x:piles){
            max=Math.max(max,x);
        }
        while(min<max){
            long sum=0;
            int mid=min+(max-min)/2;
            for(int x:piles){
                sum+=(x+mid-1)/mid;
            }
            if(sum<=h)max=mid;
            else{
                min=mid+1;
            }

            
            
        }
        return min;
        
    }
}