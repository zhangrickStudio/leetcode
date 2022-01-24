/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] temp = mergeArrays(nums1, nums2);
        if (temp.length % 2 == 0) {
            return ((double) temp[temp.length / 2] + (double) temp[temp.length / 2 - 1]) / 2;
        }
        return temp[temp.length / 2];
    }

    /**
     * 合并两个已排序数组
     * 时间复杂度O(m+n); m = nums1.lenth n = nums2.lenth;
     * 
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] mergeArrays(int[] nums1, int[] nums2) {
        int[] temp = new int[nums1.length + nums2.length];

        int i = 0;
        int j = 0;
        while (i < nums1.length || j < nums2.length) {
            // 如果nums1 数组已经遍历完 直接把nums2数组剩下元素全部插入数组
            if (nums1.length == i) {
                while (j < nums2.length) {
                    temp[i + j] = nums2[j];
                    j++;
                }
                break;
            }
            // 如果nums2 数组已经遍历完 直接把nums1数组剩下元素全部插入数组
            if (nums2.length == j) {
                while (i < nums1.length) {
                    temp[i + j] = nums1[i];
                    i++;
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                temp[i + j] = nums1[i];
                i++;
            } else {
                temp[i + j] = nums2[j];
                j++;
            }

        }

        return temp;
    }
}
// @lc code=end
