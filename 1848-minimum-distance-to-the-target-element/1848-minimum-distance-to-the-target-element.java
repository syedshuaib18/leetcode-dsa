class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        
        int output=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                
                 output=Math.min(output,Math.abs(i-start));
            }
        }
        return output;
    }
}