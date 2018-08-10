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
public class ReverseString {

	public static String reverseString(String s) {
		StringBuilder bder = new StringBuilder(s.length());
		for (int i = s.length() - 1; i > -1; i--)
			bder.append(s.charAt(i));
		return bder.toString();
	}

	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		System.out.println(reverseString(s));
	}

	public String standard(String s) {
		char[] chars = s.toCharArray();
		int i = 0;
		int j = chars.length - 1;
		while (i < j) {
			char temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
			i++;
			j--;
		}
		return new String(chars);
	}
}
