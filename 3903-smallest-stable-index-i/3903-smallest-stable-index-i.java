class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int[] suffixMin=new int [n+1];
        suffixMin[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            suffixMin[i]=Math.min(nums[i],suffixMin[i+1]);
        }
        int maxSum=0;
        for(int i=0;i<n;i++){
            maxSum=Math.max(nums[i],maxSum);
            if(maxSum-suffixMin[i]<=k)return i;
        }
        return -1;
        
    }
}