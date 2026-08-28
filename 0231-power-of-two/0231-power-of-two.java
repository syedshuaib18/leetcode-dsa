class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;

        for (long i = 0; Math.pow(2, i) <= n; i++) {
            if (Math.pow(2, i) == n) return true;
        }
        return false;
    }
}