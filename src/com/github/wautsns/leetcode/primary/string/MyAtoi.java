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
