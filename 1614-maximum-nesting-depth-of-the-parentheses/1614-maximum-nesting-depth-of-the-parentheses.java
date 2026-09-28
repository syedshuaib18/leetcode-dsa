class Solution {
    public int maxDepth(String s) {
       
        int count=0;
        int max=0;
        for(char x=0;x<s.length();x++){
            if(s.charAt(x)=='('){
                count++;
            }
            if(s.charAt(x)==')'){
                count--;
            }
            max=Math.max(max,count);
        }
        return max;
        
    }
}