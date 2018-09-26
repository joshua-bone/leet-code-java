class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        Set<Character> seen = new HashSet<>();
        int start = 0;
        int end = 0;
        int max = 0;
        while (true) {
            while (seen.add(s.charAt(end))){
                end++;
                max = Math.max(max, end - start);
                if (end == s.length()) {
                    return max;
                }
            };
            do {
                seen.remove(s.charAt(start));
            } while (s.charAt(start++) != s.charAt(end));
        }
    }
}
