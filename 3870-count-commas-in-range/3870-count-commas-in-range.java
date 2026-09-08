class Solution {
    public int countCommas(int n) {
        int count=0;
        for(int i=1000;i<=n;i++){
            count++;
        }
        if(count<1) return 0;
        else return count;

       
        

        
    }
    
}