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
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 *
 * 题目详细见: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/34/
 * </pre>
 * @author wautsns →http://www.github.com/wautsns←
 *
 * @created 2018年8月10日
 */
public class FirstUniqChar {

	public static int firstUniqChar(String s) {
		byte[] sign = new byte[26];
		for (int i = 0, l = s.length(); i < l; i++) {
			int index = s.charAt(i) - 'a';
			if (sign[index] <= 1)
				sign[index]++;
		}
		for (int i = 0, l = s.length(); i < l; i++) {
			int index = s.charAt(i) - 'a';
			if (sign[index] == 1)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		String s = "loveleetcode";
		System.out.println(firstUniqChar(s));
	}

	public int standard(String s) {
		int result = -1;
		for (char c = 'a'; c <= 'z'; c++) {
			int index = s.indexOf(c);
			if (index != -1 && index == s.lastIndexOf(c))
				result = result != -1 ? Math.min(result, index) : index;
		}
		return result;
	}
}
