class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum=0,rsum=0,max=0,right=cardPoints.length-1;
        for(int i=0;i<k;i++){
            lsum+=cardPoints[i];
            max=lsum;
        }
        for(int j=k-1;j>=0;j--){
            lsum-=cardPoints[j];
            rsum+=cardPoints[right];
            right--;
            max=Math.max(max,lsum+rsum);
        }
        
        return max;
    }
}