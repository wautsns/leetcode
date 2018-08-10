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
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 *
 * 题目详细见: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/29/
 * <pre>
 * @author wautsns →http://www.github.com/wautsns←
 *
 * @created 2018年8月10日
 */
public class TwoSum {

	public static int[] twoSum(int[] nums, int target) {
		int min = nums[0];
		int max = min;
		for (int i = 1, l = nums.length; i < l; i++)
			if (nums[i] < min)
				min = nums[i];
			else if (nums[i] > max)
				max = nums[i];
		for (int i = 0, l = nums.length - 1; i < l; i++) {
			int another = (int) ((long) target - nums[i]);
			if (another < min || another > max)
				continue;
			for (int j = i + 1; j <= l; j++)
				if (nums[j] == another)
					return new int[] {
						i, j
					};
		}
		return null;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {
			2, 7, 11, 15
		};
		System.out.println(Arrays.toString(twoSum(nums, 9)));
	}

	public int[] standard(int[] nums, int target) {
		int[] res = new int[2];
		if (nums == null || nums.length < 2)
			return res;
		int max = nums[0];
		int min = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (max < nums[i])
				max = nums[i];
			if (min > nums[i])
				min = nums[i];
		}
		int[] index = new int[max - min + 1];
		int other = 0;
		for (int i = 0; i < nums.length; i++) {
			other = target - nums[i];
			if (other < min || other > max)
				continue;
			if (index[other - min] > 0) {
				res[0] = index[other - min] - 1;
				res[1] = i;
				return res;
			}
			index[nums[i] - min] = i + 1;
		}
		return res;
	}
}
