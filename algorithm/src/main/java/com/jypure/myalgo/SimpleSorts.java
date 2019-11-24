package com.jypure.myalgo;

/**
 * 简单的排序，冒泡、插入、选择
 * @author : jiayupeng
 * @date : 2019/11/24/20:06
 */
public class SimpleSorts {

    /**
     * 冒泡排序
     * 原地排序算法
     * 稳定的排序算法
     * 最好的情况时间复杂度是On 最坏情况是On^2
     * 平均情况时间复杂度是On^2
     * @param a
     * @param n
     */
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            //提前退出冒泡排序的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 插入排序
     * 原地排序算法
     * 稳定的排序算法
     * 最好时间复杂度是On，最坏是On^2
     * 平均时间复杂度是On^2
     * @param a
     * @param n
     */
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j+1] = value;
        }
    }

    /**
     * 选择排序
     * @param a
     * @param n
     */
    public static void selectionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            //查找最小值
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            //交换
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }



}
