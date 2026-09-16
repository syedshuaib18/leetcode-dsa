class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int k = 0;

       for(int x:nums1)nums[k++]=x;
       for(int x:nums2)nums[k++]=x;
       Arrays.sort(nums);
       int n =nums.length;
       if(n%2==1){
        return nums[n/2];
       }
       else{
        return (nums[n/2-1]+nums[n/2])/2.0;
       }
       //return n%2==1 ?nums[n/2]:(nums[n/2-1]+nums[n/2])/2.0;
    }
}