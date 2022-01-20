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
        return baoli(s);
    }

    /**
     * 双重循环解题
     * @param s
     * @return
     */
    private int baoli(String s) {
        int max = 0;
        if ("".equals(s)) {
            return 0;
        }
        Set<Character> set = new HashSet<>();;
        for (int i = 0; i < s.length(); i++) {
            // 当重进循环时后续字符串长度比当前最大值小就没有必要再比对了
            if(s.length() - i + 1 < max){
                return max;
            }
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
            set.clear();
        }
        return max;
    }
}
// @lc code=end
