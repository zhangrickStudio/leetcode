import java.util.HashMap;
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
        return slideWindow(s);
    }

    /**
     * 双重循环解题
     * 时间复杂度O(n^2)
     * @param s
     * @return
     */
    private int baoli(String s) {
        int max = 0;
        if ("".equals(s)) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            // 当重进循环时后续字符串长度比当前最大值小就没有必要再比对了
            if (s.length() - i + 1 < max) {
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

    /**
     * 滑动窗口解法
     * 时间复杂度O(n)
     * @param s
     * @return
     */
    public int slideWindow(String s) {
        if (s.length() == 0)
            return 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int max = 0;
        // left 存的是符合条件的子串最左侧的下标(从0开始)
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                left = Math.max(left, hashMap.get(s.charAt(i)) + 1);    
            }
            hashMap.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
// @lc code=end
