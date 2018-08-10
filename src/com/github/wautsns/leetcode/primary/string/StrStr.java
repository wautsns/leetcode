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
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 *
 * 题目详细见: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/38/
 * </pre>
 * @author wautsns →http://www.github.com/wautsns←
 *
 * @created 2018年8月10日
 */
public class StrStr {

	public static int strStr(String haystack, String needle) {
		if (needle.length() == 0)
			return 0;
		int limit = haystack.length() - needle.length();
		if (limit < 0)
			return -1;
		for (int i = 0, cursor = 0, l = haystack.length(); i < l; i++) {
			char c = haystack.charAt(i);
			if (c != needle.charAt(cursor)) {
				if (i + needle.length() - cursor > haystack.length())
					return -1;
				i = i - cursor;
				cursor = 0;
				continue;
			}
			cursor++;
			if (cursor == needle.length())
				return i - cursor + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		String haystack = "aabaaabaaac";
		String needle = "aabaaac";
		System.out.println(strStr(haystack, needle));
	}

	public int standard(String haystack, String needle) {
		// 范例是直接用 API ???
		return haystack.indexOf(needle);
	}
}
