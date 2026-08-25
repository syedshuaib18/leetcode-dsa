class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n=101;
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int result=0;

        for(int i=1;i<=n;i++){
            if(!set.contains(k*i)){
                  result = k*i;
                break;
            }
        }
        return result;
    }
}