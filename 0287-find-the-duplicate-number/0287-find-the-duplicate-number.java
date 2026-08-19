class Solution {
    public int findDuplicate(int[] nums) {
      Set<Integer>set = new HashSet<>();
      int repeated =-1;
      for(int num:nums){
        if(set.contains(num)){
            repeated=num;
        }
        else{
            set.add(num);
        }
      }
      return repeated;
           }
}