package com.jypure.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数
 * https://leetcode.cn/problems/happy-number/
 * @author : jiayupeng
 * @date : 2022/7/9/0:01
 */
public class Code7 {

    public static void main(String[] args){
        Code7 code7 = new Code7();
        boolean happy = code7.isHappy(19);
        System.out.println(happy);
    }


    public boolean isHappy(int n) {
        Set<Integer> sum = new HashSet<>();

        Integer curSum = n;
        while (true) {
            curSum = sum(curSum);
            if (sum.contains(curSum)) {
                return false;
            }
            if (curSum.equals(1)) {
                return true;
            }
            sum.add(curSum);
        }

    }

    public Integer sum(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }


}
