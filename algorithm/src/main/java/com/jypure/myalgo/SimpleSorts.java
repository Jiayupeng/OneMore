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
     * @param a 数组
     * @param n 数组大小
     */
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
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
     * 插入排序：数组中分成两部分，已排序区间和未排序区间，初始将第一个元素作为已排序区间，后面的每个元素经过比较插入到合适的位置
     * 核心思想是取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序
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
            for (; j >= 0; j--) {
                if (value < a[j]){
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            //j最后一次循环又减了1，所以要加1
            a[j + 1] = value;
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

    public static void main(String[] args){
        int[] a = new int[]{4,9,1,20,45,13,78,45,12};
        insertionSort(a, 9);
        for (int i : a) {
            System.out.println(i);
        }

    }


}
