class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE; 
        
        int index1=0;
        int index2=0;
        
        for(int i=0;i<n;i++){
            if(nums[i]>max){max=nums[i];index1=i;}

            if(nums[i]<min){min=nums[i];index2=i;}
        }
        int left =Math.max(index1,index2)+1;
        int right=n-Math.min(index1,index2);
        int both =Math.min(index1,index2)+1+n-Math.max(index1,index2);
        return Math.min(left,Math.min(right,both))  ;
    }
}