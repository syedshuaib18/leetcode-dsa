class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int alice=0;
        for(int i=0;i<aliceSizes.length;i++){
            
            alice +=aliceSizes[i];
            }
            int bob=0;

            for(int j=0;j<bobSizes.length;j++){
                
                bob+=bobSizes[j];
                
            }


        
        int diff= (bob-alice)/2;

        HashSet<Integer>set=new HashSet<>();
        for(int num:bobSizes){
            set.add(num);
        }
        for(int a:aliceSizes){
            int b =a+diff;
        
        if(set.contains(b)){
            return new int []{a,b};
        }}
            return new int[]{};
    }
}