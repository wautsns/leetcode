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

/**
 * <pre>
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 题目详细见: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/24/
 * </pre>
 *
 * @author wautsns →http://www.github.com/wautsns←
 *
 * @created 2018年8月9日
 */
public class ContainsDuplicate {

    public static boolean containsDuplicate2(int[] nums) {
        for (int i = 0, l = nums.length - 1; i < l; i++)
            for (int j = i + 1; j <= l; j++)
                if (nums[i] == nums[j])
                    return true;
        return false;
    }

    /**
     * 该方法在提交时,运行超时
     */
    public static boolean containsDuplicate1(int[] nums) {
        if (nums == null || nums.length < 2)
            return false;
        for (int i = 0, l = nums.length - 1, min = l, max = l; i < l; i++) {
            if (i != 0 && (nums[i] < nums[min] || nums[i] > nums[max]))
                continue;
            if ((nums[i] == nums[min] && i != min) || (nums[i] == nums[max] && i != max))
                return true;
            for (int j = i + 1; j <= l; j++) {
                if (nums[i] == nums[j])
                    return true;
                if (nums[j] < nums[min])
                    min = j;
                else if (nums[j] > max)
                    max = j;
            }
            if (nums[max] - nums[min] + 1 < l - i)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {
                1, 2, 3, 0, 3
        };
        System.out.println(containsDuplicate2(nums));
    }

    /**
     * <pre>
     * <strong>注意:该范例无法通过测试用例 [1, 2, 3, 0, 3]
     * 我已向 leetcode 提交该测试用例,若有变动,会尽快更新的
     * </pre>
     */
    public boolean standard(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            for (int j = i - 1; j >= 0; j--)
                if (nums[i] > nums[j])
                    break;
                else if (nums[i] == nums[j])
                    return true;
        return false;
    }
}
