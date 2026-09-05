class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int  [] suffixMin=new int [n+1];
        int ans=0;
        suffixMin[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            suffixMin[i]=Math.min(nums[i],suffixMin[i+1]);
        }
        int prefix=0;
        for(int i=0;i<nums.length;i++){
            prefix=Math.max(nums[i],prefix);
            if(prefix-suffixMin[i]<=k)return i;
        }        
        return -1;
    }
}