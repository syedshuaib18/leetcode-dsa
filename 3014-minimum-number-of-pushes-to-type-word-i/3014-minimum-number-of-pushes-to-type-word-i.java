class Solution {
    public int minimumPushes(String word) {
        int n =word.length();
        int push=1;
        int ans=0;
   while(n>0){
    int take = Math.min(8,n);
    ans+=take*push;
    n-=take;
    push++;
   } 
   return ans;

    }
}