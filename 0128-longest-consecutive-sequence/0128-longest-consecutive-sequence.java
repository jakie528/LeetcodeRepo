class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longStreak = 0;

        // pick the consecutive sequence
        for (int num : set) {
            // Only start counting if 'num' is the FIRST number in a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentStreak += 1;
                    currentNum += 1;
                }

                longStreak = Math.max(currentStreak, longStreak);
            }
        }

        return longStreak;

    }
}