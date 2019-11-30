package com.jypure.myalgo;

/**
 * 归并排序
 * @author : jiayupeng
 * @date : 2019/11/30/16:36
 */
public class MergeSort {

    /**
     * a是要排序的数组，n是元素个数
     * @param a
     * @param n
     */
    public static void mergeSort(int[] a, int n) {
        mergeSortInternally(a, 0, n - 1);
    }

    /**
     * @param a 要排序的数组
     * @param p 第一个元素下标
     * @param r 最后一个元素下标
     */
    public static void mergeSortInternally(int[] a, int p, int r) {
        //递归终止条件
        if (p >= r) {
            return;
        }

        //中间位置
        int q = p + (r - p) / 2;

        //分而治之
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q, r);

        //将A[p...q]和A[q+1...r]合并为A[p...r]
        merge(a, p, q, r);
    }

    /**
     * 合并
     * @param a 数组
     * @param p 第一个元素下标
     * @param q 中间元素下标
     * @param r 最后一个元素下标
     */
    private static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;
        int[] tmp = new int[r-p+1];

        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        //判断哪个子数组中还有剩余元素
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        while (start <= end) {
            tmp[k++] = a[start++];
        }

        //将tmp数组拷贝回a[p...r]
        for (int l = 0; l < r - p; l++) {
            a[p + l] = tmp[l];
        }
    }
}
