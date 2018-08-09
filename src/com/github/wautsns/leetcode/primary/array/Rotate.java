/*
 * Copyright 2018 wautsns.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.wautsns.leetcode.primary.array;

import java.util.Arrays;

/**
 * <pre>
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * <strong>尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的原地算法。</strong>
 *
 * 题目详细见 https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/23/
 * </pre>
 *
 * @author wautsns →http://www.github.com/wautsns←
 *
 * @created 2018年8月9日
 */
public class Rotate {

    public static void rotate1(int[] nums, int k) {
        int len = (nums == null) ? 0 : nums.length;
        k = (len == 0) ? 0 : (k < len ? k : k % len);
        for (int i = 0; i < k; i++) {
            int last = nums[len - 1];
            for (int j = len - 1; j > 0; j--)
                nums[j] = nums[j - 1];
            nums[0] = last;
        }
    }

    public static void rotate2(int[] nums, int k) {
        int len = (nums == null) ? 0 : nums.length;
        k = (len == 0) ? 0 : (k < len ? k : k % len);
        if (k == 0)
            return;
        int last = nums[len - 1];
        for (int j = len - 1; j > 0; j--)
            nums[j] = nums[j - 1];
        nums[0] = last;
        rotate2(nums, k - 1);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {
                1, 2, 3, 4, 5, 6, 7
        };
        rotate2(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public void standard(int[] nums, int k) {
        if (nums.length == 0)
            return;
        k = k % nums.length;
        stdReverse(nums, 0, nums.length - k - 1);
        stdReverse(nums, nums.length - k, nums.length - 1);
        stdReverse(nums, 0, nums.length - 1);
    }

    private void stdReverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
