package com.jypure.leetcode;

/**
 * 122. 买卖股票的最佳时机 II
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
 * @author : jiayupeng
 * @date : 2022/8/8/10:41
 */
public class Code72 {

    /**
     * 把利润分解，计算每天的利润（第一天没利润），然后把正利润加起来，就是最后的最大盈利
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            if (profit > 0) {
                sum += profit;
            }
        }
        return sum;
    }

}
