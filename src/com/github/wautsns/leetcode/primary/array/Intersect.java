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
 * 给定两个数组，写一个方法来计算它们的交集。
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果nums2的元素存储在磁盘上，内存是有限的，你不能一次加载所有的元素到内存中，你该怎么办？
 * </pre>
 *
 * @author wautsns →http://www.github.com/wautsns←
 *
 * @created 2018年8月9日
 */
public class Intersect {

	public static int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int[] rst = new int[Math.min(nums1.length, nums2.length)];
		int len = 0;
		for (int i = 0, j = 0, il = nums1.length, jl = nums2.length; i < il && j < jl;)
			if (nums1[i] > nums2[j])
				j++;
			else if (nums1[i] < nums2[j])
				i++;
			else {
				rst[len++] = nums1[i];
				i++;
				j++;
			}
		return Arrays.copyOf(rst, len);
	}

	public static void main(String[] args) {
		int[] nums1 = new int[] {
			1, 2, 2, 1
		};
		int[] nums2 = new int[] {
			2, 2
		};
		System.out.println(Arrays.toString(intersect(nums1, nums2)));
	}

	public int[] standard(int[] nums1, int[] nums2) {
		/*
		if(nums1.length == 0 && nums2.length != 0){
		    return new int[1];
		}else if(nums2.length == 0 && nums1.length !=0){
		    return new int[1];
		}else if(nums1.length == 0 && nums2.length == 0){
		    return new int[1];
		}
		*/
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int[] result;
		if (nums1.length > nums2.length)
			result = new int[nums2.length];
		else
			result = new int[nums1.length];
		int i = 0, j = 0, z = -1;
		while (i < nums1.length && j < nums2.length)
			if (nums1[i] == nums2[j]) {
				result[++z] = nums1[i];
				i++;
				j++;
			} else if (nums1[i] > nums2[j])
				j++;
			else
				i++;
		int[] result1 = new int[z + 1];
		for (int k = 0; k <= z; k++)
			result1[k] = result[k];
		return result1;
	}
}
