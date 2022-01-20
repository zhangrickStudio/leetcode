import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        if ("".equals(s)) {
            return 0;
        }

        for (int i = 0; i < s.length(); i++) {

            Set<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                } else {
                    set.add(s.charAt(j));
                }
            }

            if (max < set.size()) {
                max = set.size();
            }

        }

        return max;

    }
}
// @lc code=end
