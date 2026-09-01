class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left=findIndexLeft(nums,target);
        int right=findIndexRight(nums,target);
        return new int[]{left,right};
        
    }
     private int findIndexRight(int []nums,int target){
        int index=-1;int low=0;int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                index=mid;
                low=mid+1;

            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return index;
    }
    private int findIndexLeft(int []nums,int target){
        int index=-1;int low=0;int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                index=mid;
                high=mid-1;

            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return index;
    }
}