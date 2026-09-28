class Solution {
    public int reverseDegree(String s) {
        int sum=0;

        for(char i=0;i<s.length();i++){
            sum+=(i+1)*('z'-s.charAt(i)+1);
        }
        return sum;
        
    }
}