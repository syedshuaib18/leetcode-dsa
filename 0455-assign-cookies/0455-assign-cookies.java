class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count =0;
        int i=0;
            int j=0;
            Arrays.sort(g);
            Arrays.sort(s);
            while(j<s.length&&i<g.length){
                if(s[j]>=g[i]){
                    count++;
                    i++;
                    j++;
                    
                }
                else{j++;
                }
            }
        
        return count;
        
    }
}