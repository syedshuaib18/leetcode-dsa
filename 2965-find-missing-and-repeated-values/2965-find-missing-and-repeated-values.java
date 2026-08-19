class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int missing =-1;
        int repeating =-1;
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                int nums=grid[i][j];
                if(set.contains(nums))
                repeating=nums;
                else{
                    set.add(nums);
                
                }
            }
        }
        int n=grid.length*grid.length;
        for(int k=1;k<=n;k++){
            if(!set.contains(k)){
                missing=k;
                break;
            }
        }
        return new int []{repeating,missing};
        
    }
}