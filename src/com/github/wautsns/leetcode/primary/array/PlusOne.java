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
 * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 题目详细见: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/27/
 * </pre>
 * @author wautsns →http://www.github.com/wautsns←
 *
 * @created 2018年8月10日
 */
public class PlusOne {

	public static int[] plusOne(int[] digits) {
		boolean isAllNine = true;
		for (int digit : digits)
			if (digit != 9) {
				isAllNine = false;
				break;
			}
		if (isAllNine) {
			digits = new int[digits.length + 1];
			digits[0] = 1;
			for (int i = 1, l = digits.length; i < l; i++)
				digits[i] = 0;
			return digits;
		}
		boolean needCarry = true;
		for (int i = digits.length - 1; needCarry && i > -1; i--) {
			int temp = digits[i] + 1;
			needCarry = temp > 9;
			digits[i] = temp % 10;
		}
		return digits;
	}

	public static void main(String[] args) {
		int[] digits = new int[] {
			1, 0, 9
		};
		System.out.println(Arrays.toString(plusOne(digits)));
	}

	public int[] standard(int[] digits) {
		int len = digits.length;
		for (int i = len - 1; i > -1; i--)
			if (digits[i] == 9)
				digits[i] = 0;
			else {
				digits[i] += 1;
				return digits;
			}
		int[] newArray = new int[len + 1];
		newArray[0] = 1;
		return newArray;
	}
}
