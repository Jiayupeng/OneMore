package com.jypure.leetcode;

/**
 * 剑指 Offer 05. 替换空格
 * https://leetcode.cn/problems/ti-huan-kong-ge-lcof/submissions/
 * @author : jiayupeng
 * @date : 2022/7/11/19:15
 */
public class Code15 {

    /**
     * 自己的
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (s.charAt(i) == ' '){
                sb.append("20%");
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();

    }

    /**
     * 双指针法
     * @param s
     * @return
     */
    public String replaceSpace1(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        //扩充空间，空格数量2倍
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                str.append("  ");
            }
        }
        //若是没有空格直接返回
        if(str.length() == 0){
            return s;
        }
        //有空格情况 定义两个指针
        int left = s.length() - 1;//左指针：指向原始字符串最后一个位置
        s += str.toString();
        int right = s.length()-1;//右指针：指向扩展字符串的最后一个位置
        char[] chars = s.toCharArray();
        while(left>=0){
            if(chars[left] == ' '){
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right] = '%';
            }else{
                chars[right] = chars[left];
            }
            left--;
            right--;
        }
        return new String(chars);




    }


}
