class Solution {
    public int rob(int[] nums) {
        int n =nums.length;
        int[]leaveFirst=new int[n-1];
        int[]leaveLast=new int[n-1];
        if (n == 1) return nums[0];
if (n == 2) return Math.max(nums[0], nums[1]);




        for(int i=0;i<n-1;i++){
            leaveLast[i]=nums[i];
            leaveFirst[i]=nums[i+1];
        }




        int[]dp=new int[n+1];
        dp[0]=leaveLast[0];
        dp[1]=Math.max(leaveLast[1],leaveLast[0]);

        for(int i=2;i<leaveLast.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+leaveLast[i]);
        }

        int  []dp2=new int [n+1];
        dp2[0]=leaveFirst[0];
        dp2[1]=Math.max(leaveFirst[1],leaveFirst[0]);

        for(int i=2;i<leaveFirst.length;i++){
            dp2[i]=Math.max(dp2[i-1],dp2[i-2]+leaveFirst[i]);
        }

        int result=Math.max(dp[leaveLast.length-1],dp2[leaveFirst.length-1]);
return result;



        
    }
}