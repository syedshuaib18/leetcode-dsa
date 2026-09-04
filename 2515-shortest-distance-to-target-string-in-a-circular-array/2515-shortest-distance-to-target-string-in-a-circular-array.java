class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n=words.length;
        int output=Integer.MAX_VALUE;
    
        int direct=Integer.MAX_VALUE;
        int circular= Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            
                if(words[i].equals(target)){
                direct=Math.abs(i-startIndex);
                circular=n-direct;
                output=Math.min(output,Math.min(direct,circular));


                }
            }
        return output==Integer.MAX_VALUE ?-1:output;
        
    }
}