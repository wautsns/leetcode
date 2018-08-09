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
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 题目详细见: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/25/
 * </pre>
 *
 * @author wautsns →http://www.github.com/wautsns←
 *
 * @created 2018年8月9日
 */
public class SingleNumber {

	public static int singleNumber(int[] nums) {
		int single = 0;
		for (int num : nums)
			single ^= num;
		return single;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {
			4, 1, 2, 1, 2
		};
		System.out.println(singleNumber(nums));
	}

	public int standard(int[] nums) {
		int ans = 0;
		for (int i : nums)
			ans ^= i;
		return ans;
	}
}
