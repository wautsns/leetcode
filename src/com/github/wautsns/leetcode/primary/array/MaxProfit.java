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
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 题目详细见: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/22/
 * </pre>
 *
 * @author wautsns →http://www.github.com/wautsns←
 *
 * @created 2018年8月8日
 */
public class MaxProfit {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int profit = 0;
        // 买入的索引位置
        int buyIndex = 0;
        for (int i = 1, l = prices.length; i < l; i++)
            if (prices[i - 1] > prices[i]) { // 判断今日是否比昨日价格低
                // 今日比昨日价格低,则应该在昨日抛售,并尝试在今日买入
                profit += prices[i - 1] - prices[buyIndex];
                buyIndex = i;
            } // 今日比昨日价格高,则继续观望
        // 尝试最后一次买卖
        int lastTry = prices[prices.length - 1] - prices[buyIndex];
        return lastTry <= 0 ? profit : profit + lastTry;
    }

    public static void main(String[] args) {
        int[] prices = new int[] {
                7, 6, 4, 3, 1
        };
        System.out.println(maxProfit(prices));
    }

    public int standard(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++)
            if (i + 1 < prices.length && prices[i + 1] - prices[i] > 0)
                maxProfit += prices[i + 1] - prices[i];
        return maxProfit;
    }
}
