class Solution {

    long LIMIT;

    public String smallestPalindrome(String s, int k) {

        LIMIT = k;

        int[] freq = new int[26];

        for(char c : s.toCharArray())
            freq[c-'a']++;

        String mid="";

        int[] half=new int[26];

        int len=0;

        for(int i=0;i<26;i++){

            if(freq[i]%2==1)
                mid=""+(char)('a'+i);

            half[i]=freq[i]/2;
            len+=half[i];
        }

        if(countWays(half,len)<k)
            return "";

        StringBuilder left=new StringBuilder();

        while(len>0){

            for(int i=0;i<26;i++){

                if(half[i]==0)
                    continue;

                half[i]--;

                long ways=countWays(half,len-1);

                if(ways>=k){

                    left.append((char)('a'+i));
                    len--;
                    break;

                }else{

                    k-=ways;
                    half[i]++;

                }
            }
        }

        String right=new StringBuilder(left).reverse().toString();

        return left.toString()+mid+right;
    }

    private long countWays(int[] cnt,int total){

        long ans=1;

        int used=0;

        for(int c:cnt){

            for(int i=1;i<=c;i++){

                used++;

                ans=ans*used/i;

                if(ans>LIMIT)
                    return LIMIT+1;
            }
        }

        return ans;
    }
}