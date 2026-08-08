class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        // next[i] = maximum number of characters
        // from the end of word2 that can be matched
        // using word1[i...]
        int[] next = new int[n + 1];

        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {

            next[i] = next[i + 1];

            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                next[i]++;
                j--;
            }
        }

        int[] ans = new int[m];

        int i = 0;
        boolean changed = false;

        for (int k = 0; k < m; k++) {

            while (i < n) {

                // Normal matching
                if (word1.charAt(i) == word2.charAt(k)) {
                    ans[k] = i;
                    i++;
                    break;
                }

                // Change this character if the remaining
                // characters can still be matched
                if (!changed && next[i + 1] >= m - k - 1) {
                    ans[k] = i;
                    changed = true;
                    i++;
                    break;
                }

                i++;
            }

            if (i > n) {
                return new int[0];
            }
        }

        return ans;
    }
}