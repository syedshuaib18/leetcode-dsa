class Solution {
    public boolean uniformArray(int[] nums1) {
        int modd=Integer.MAX_VALUE;
        int meven=Integer.MAX_VALUE;
        for(int x:nums1) {
            if(x%2==0){
                meven=Math.min(x,meven);
            }
            if(x%2!=0){
                modd=Math.min(x,modd);
            }
        }
        
        if(modd==Integer.MAX_VALUE||meven==Integer.MAX_VALUE){
            return true;
        }
        return modd<meven;
        
    }
}