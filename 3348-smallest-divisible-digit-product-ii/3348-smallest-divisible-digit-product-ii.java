import java.util.*;

class Solution {

    private static final Map<Integer, Map<Integer, Integer>> FACTORS = new HashMap<>();

    static {
        FACTORS.put(0, Map.of());
        FACTORS.put(1, Map.of());

        FACTORS.put(2, Map.of(2, 1));
        FACTORS.put(3, Map.of(3, 1));
        FACTORS.put(4, Map.of(2, 2));
        FACTORS.put(5, Map.of(5, 1));
        FACTORS.put(6, Map.of(2, 1, 3, 1));
        FACTORS.put(7, Map.of(7, 1));
        FACTORS.put(8, Map.of(2, 3));
        FACTORS.put(9, Map.of(3, 2));
    }

    public String smallestNumber(String num, long t) {
        PrimeResult primeResult = getPrimeCount(t);

        if (!primeResult.ok) {
            return "-1";
        }

        Map<Integer, Integer> primeCount = primeResult.count;
        Map<Integer, Integer> factorCount = getFactorCount(primeCount);

        // If minimum digits required exceeds string length, make the smallest valid number
        if (sumValues(factorCount) > num.length()) {
            return construct(factorCount);
        }

        Map<Integer, Integer> prefix = getPrimeCountFromString(num);
        int firstZero = num.indexOf('0');

        if (firstZero == -1) {
            firstZero = num.length();
            if (isSubset(primeCount, prefix)) {
                return num;
            }
        }

        // Try to replace a digit from right to left with a strictly greater digit
        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = num.charAt(i) - '0';
            prefix = subtract(prefix, FACTORS.get(digit));

            if (i > firstZero) {
                continue;
            }

            for (int next = digit + 1; next <= 9; next++) {
                Map<Integer, Integer> need = subtract(
                        subtract(primeCount, prefix),
                        FACTORS.get(next)
                );

                Map<Integer, Integer> suffix = getFactorCount(need);

                int remaining = num.length() - i - 1;
                if (sumValues(suffix) <= remaining) {
                    int ones = remaining - sumValues(suffix);

                    StringBuilder ans = new StringBuilder();
                    ans.append(num.substring(0, i));
                    ans.append(next);

                    while (ones-- > 0) {
                        ans.append('1');
                    }

                    ans.append(construct(suffix));
                    return ans.toString();
                }
            }
        }

        // If no replacement was possible within current length, expand length by 1
        Map<Integer, Integer> suffix = getFactorCount(primeCount);
        StringBuilder ans = new StringBuilder();
        int ones = num.length() + 1 - sumValues(suffix);

        while (ones-- > 0) {
            ans.append('1');
        }

        ans.append(construct(suffix));
        return ans.toString();
    }

    // --- Helper Classes & Methods ---

    static class PrimeResult {
        Map<Integer, Integer> count;
        boolean ok;

        PrimeResult(Map<Integer, Integer> c, boolean o) {
            count = c;
            ok = o;
        }
    }

    private PrimeResult getPrimeCount(long t) {
        Map<Integer, Integer> count = new HashMap<>();
        count.put(2, 0);
        count.put(3, 0);
        count.put(5, 0);
        count.put(7, 0);

        int[] primes = {2, 3, 5, 7};
        for (int p : primes) {
            while (t % p == 0) {
                t /= p;
                count.put(p, count.get(p) + 1);
            }
        }

        return new PrimeResult(count, t == 1);
    }

    private Map<Integer, Integer> getPrimeCountFromString(String num) {
        Map<Integer, Integer> count = new HashMap<>();
        count.put(2, 0);
        count.put(3, 0);
        count.put(5, 0);
        count.put(7, 0);

        for (char c : num.toCharArray()) {
            int digit = c - '0';
            for (Map.Entry<Integer, Integer> e : FACTORS.get(digit).entrySet()) {
                int prime = e.getKey();
                int freq = e.getValue();
                count.put(prime, count.get(prime) + freq);
            }
        }

        return count;
    }

    private Map<Integer, Integer> subtract(Map<Integer, Integer> a, Map<Integer, Integer> b) {
        Map<Integer, Integer> res = new HashMap<>(a);
        for (Map.Entry<Integer, Integer> e : b.entrySet()) {
            int key = e.getKey();
            res.put(key, Math.max(0, res.getOrDefault(key, 0) - e.getValue()));
        }
        return res;
    }

    private boolean isSubset(Map<Integer, Integer> need, Map<Integer, Integer> have) {
        for (Map.Entry<Integer, Integer> e : need.entrySet()) {
            if (have.getOrDefault(e.getKey(), 0) < e.getValue()) {
                return false;
            }
        }
        return true;
    }

    private int sumValues(Map<Integer, Integer> map) {
        int sum = 0;
        for (int v : map.values()) {
            sum += v;
        }
        return sum;
    }

    private Map<Integer, Integer> getFactorCount(Map<Integer, Integer> count) {
        Map<Integer, Integer> res = new HashMap<>();

        int two = count.getOrDefault(2, 0);
        int three = count.getOrDefault(3, 0);
        int five = count.getOrDefault(5, 0);
        int seven = count.getOrDefault(7, 0);

        int count8 = two / 3;
        int remain2 = two % 3;

        int count9 = three / 2;
        int count3 = three % 2;

        int count4 = remain2 / 2;
        int count2 = remain2 % 2;

        int count6 = 0;

        if (count2 == 1 && count3 == 1) {
            count2 = 0;
            count3 = 0;
            count6 = 1;
        }

        if (count3 == 1 && count4 == 1) {
            count2 = 1;
            count6 = 1;
            count3 = 0;
            count4 = 0;
        }

        res.put(2, count2);
        res.put(3, count3);
        res.put(4, count4);
        res.put(5, five);
        res.put(6, count6);
        res.put(7, seven);
        res.put(8, count8);
        res.put(9, count9);

        return res;
    }

    private String construct(Map<Integer, Integer> factors) {
        StringBuilder sb = new StringBuilder();

        for (int digit = 2; digit <= 9; digit++) {
            int cnt = factors.getOrDefault(digit, 0);
            while (cnt-- > 0) {
                sb.append(digit);
            }
        }

        return sb.toString();
    }
}