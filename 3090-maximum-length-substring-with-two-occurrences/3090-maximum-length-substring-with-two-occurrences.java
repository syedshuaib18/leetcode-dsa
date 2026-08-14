class Solution {
    public int maximumLengthSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, ans = 0;

        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            while (map.get(s.charAt(right)) > 2) {
                char c = s.charAt(left++);
                map.put(c, map.get(c) - 1);
            }

            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}