package com.jypure.leetcode;

/**
 * 134. 加油站
 * https://leetcode.cn/problems/gas-station/
 * @author : jiayupeng
 * @date : 2022/8/10/10:29
 */
public class Code76 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int min = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += (gas[i] - cost[i]);
            min = Math.min(sum, min);
        }

        //如果加的油不能大于等于要消耗的油，那肯定不能走一周。
        if (sum < 0) {
            return -1;
        }
        //如果从0开始，每走一站，剩余的油都大于等于0，那么从0开始就能走一周
        if (min >= 0) {
            return 0;
        }

        //从后往前，谁能把负值给抹平，从哪里开始就能航行一周。
        for (int i = gas.length - 1; i > 0; i--) {
            min += (gas[i] - cost[i]);
            if (min >= 0) {
                return i;
            }
        }

        return -1;
    }

}
