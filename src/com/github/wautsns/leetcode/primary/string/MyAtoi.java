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
package com.github.wautsns.leetcode.primary.string;

/**
 * <pre>
 * 实现 atoi，将字符串转为整数。
 *
 * 在找到第一个非空字符之前，需要移除掉字符串中的空格字符。
 * 如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。
 * 如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
 * 当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。
 * 若函数不能执行有效的转换，返回 0。
 *
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [-2<sup>31</sup>,  2<sup>31</sup>-1]。
 * 如果数值超过可表示的范围，则返回  INT_MAX (2<sup>31</sup>-1) 或 INT_MIN (-2<sup>31</sup>)。
 * </pre>
 * @author wautsns →http://www.github.com/wautsns←
 *
 * @created 2018年8月10日
 */
public class MyAtoi {

	public static int myAtoi(String str) {
		int index = 0;
		for (int i = 0, l = str.length(); i < l; i++) {
			char c = str.charAt(i);
			if (c == ' ')
				continue;
			if (c <= '9' && c >= '0')
				index = i;
			else if (c == '-')
				index = -(i + 1);
			else if (c == '+')
				index = i + 1;
			else
				return 0;
			break;
		}
		int criticalPositiveNum = Integer.MAX_VALUE / 10;
		int criticalPositiveMod = Integer.MAX_VALUE % 10;
		int criticalNegativeNum = Integer.MIN_VALUE / 10;
		int criticalNegativeMod = Math.abs(Integer.MIN_VALUE % 10);
		int num = 0;
		for (int i = Math.abs(index), l = str.length(); i < l; i++) {
			char c = str.charAt(i);
			if (c > '9' || c < '0')
				return num;
			int digit = c - '0';
			if (index >= 0) {
				if (num > criticalPositiveNum || num == criticalPositiveNum && digit > criticalPositiveMod)
					return Integer.MAX_VALUE;
			} else {
				if (num < criticalNegativeNum || num == criticalNegativeNum && digit > criticalNegativeMod)
					return Integer.MIN_VALUE;
				digit = -digit;
			}
			num = num * 10 + digit;
		}
		return num;
	}

	public static void main(String[] args) {
		String str = "-91283472332";
		System.out.println(myAtoi(str));
	}

	public int standard(String str) {
		int index = 0;
		long out = 0;
		boolean positive = true;
		while (index < str.length() && str.charAt(index) == ' ')
			++index;
		if (index < str.length() && str.charAt(index) == '-') {
			positive = false;
			++index;
		} else if (index < str.length() && str.charAt(index) == '+')
			++index;
		while (index < str.length() && Character.isDigit(str.charAt(index))) {
			out = out * 10 + str.charAt(index) - '0';
			if (out > Integer.MAX_VALUE)
				return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			++index;
		}
		return positive ? (int) out : (int) -out;
	}
}
