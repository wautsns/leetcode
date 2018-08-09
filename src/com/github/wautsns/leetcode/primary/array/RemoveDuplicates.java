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
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 题目详细见: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/21/
 * <pre>
 *
 * @author wautsns →http://www.github.com/wautsns←
 *
 * @created 2018年8月8日
 */
public class RemoveDuplicates {

	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int len = 1;
		for (int i = 1, l = nums.length, front = nums[0]; i < l; i++)
			if (front != nums[i]) {
				nums[len++] = nums[i];
				front = nums[i];
			}
		return len;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {
			0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 5
		};
		// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
		int len = removeDuplicates(nums);

		// 在函数里修改输入数组对于调用者是可见的。
		// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
		for (int i = 0; i < len; i++)
			System.out.println(nums[i]);
	}

	public int standard(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int count = 1;
		for (int i = 1; i < nums.length; i++)
			if (nums[i - 1] != nums[i])
				nums[count++] = nums[i];
		return count;
	}
}
