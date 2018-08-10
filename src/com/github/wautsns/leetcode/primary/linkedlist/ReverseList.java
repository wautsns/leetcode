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
package com.github.wautsns.leetcode.primary.linkedlist;

import java.util.function.Consumer;

/**
 * <pre>
 * 反转一个单链表。
 *
 * 题目详细见: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/43/
 * </pre>
 * @author wautsns →http://www.github.com/wautsns←
 *
 * @created 2018年8月10日
 */
public class ReverseList {

	public static ListNode reverseList(ListNode head) {
		if (head == null)
			return null;
		ListNode front = null;
		ListNode curr = head;
		ListNode next;
		while ((next = curr.next) != null) {
			curr.next = front;
			front = curr;
			curr = next;
		}
		curr.next = front;
		return curr;
	}

	public static void main(String[] args) {
		ListNode la = ListNode.create(1, 2);
		System.out.println(reverseList(la));
	}

	public ListNode standard(ListNode head) {
		ListNode pre = null;
		ListNode next = head;
		while (next != null) {
			ListNode tmp = next.next;
			next.next = pre;
			pre = next;
			next = tmp;
		}
		return pre;
	}

	private static class ListNode {

		public static ListNode create(int... xs) {
			ListNode curr = null;
			for (int i = xs.length - 1; i > -1; i--)
				curr = new ListNode(xs[i], curr);
			return curr;
		}

		private int val;
		private ListNode next;

		public ListNode(int val, ListNode next) {
			super();
			this.val = val;
			this.next = next;
		}

		public void foreach(Consumer<ListNode> consumer) {
			ListNode curr = this;
			do {
				consumer.accept(curr);
				curr = curr.next;
			} while (curr != null);
		}

		@Override
		public String toString() {
			StringBuilder bder = new StringBuilder();
			foreach(node -> bder.append(node.val).append(','));
			return bder.toString();
		}
	}
}
