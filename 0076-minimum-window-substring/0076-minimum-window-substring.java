class Solution {
    //frequency map in target string t
    HashMap<Character, Integer> freMap = new HashMap<>();
    // current window in S
    HashMap<Character, Integer> winMap = new HashMap<>();

    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;

        int minWinLength = Integer.MAX_VALUE;
        int minStart = 0; // add this near minWinLength declaration

        // Build Frequent map
        buildTargetFrequencyMap(t);

        while (right < s.length()) {
            winMap.put(s.charAt(right), winMap.getOrDefault(s.charAt(right), 0) + 1);
            right++;

            while (isWindowsValid(winMap, freMap)) {
                if (right - left < minWinLength) { // only record when strictly smaller
                    minWinLength = right - left;
                    minStart = left;
                }

                winMap.put(s.charAt(left), winMap.getOrDefault(s.charAt(left), 0) - 1);
                // move left pointer inward
                left++;
            }

        }

        if (minWinLength == Integer.MAX_VALUE)
            return "";

        return s.substring(minStart, minStart + minWinLength);

    }

    private Map<Character, Integer> buildTargetFrequencyMap(String t) {
        char[] array = t.toCharArray();
        for (char c : array) {
            freMap.put(c, freMap.getOrDefault(c, 0) + 1);
        }
        return freMap;
    }

    private boolean isWindowsValid(Map<Character, Integer> windowCounts, Map<Character, Integer> targetCounts) {

        for (Map.Entry<Character, Integer> entry : targetCounts.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();

            int windowCount = windowCounts.getOrDefault(c, 0);

            if (windowCount < count) {
                return false;
            }
        }
        return true;
    }

}