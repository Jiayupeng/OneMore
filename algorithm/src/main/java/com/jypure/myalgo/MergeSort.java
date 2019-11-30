package com.jypure.myalgo;

/**
 * 归并排序
 *
 * @author : jiayupeng
 * @date : 2019/11/30/16:36
 */
public class MergeSort {

    /**
     * a是要排序的数组，n是元素个数
     *
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
        // 递归终止条件
        if (p >= r) {
            return;
        }

        // 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值
        int q = p + (r - p) / 2;
        // 分治递归
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q + 1, r);

        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        mergeBySentry(a, p, q, r);
    }

    /**
     * 合并
     *
     * @param a 数组
     * @param p 第一个元素下标
     * @param q 中间元素下标
     * @param r 最后一个元素下标
     */
    private static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;
        int[] tmp = new int[r - p + 1];

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
        for (int l = 0; l <= r - p; l++) {
            a[p + l] = tmp[l];
        }
    }

    /**
     * 合并(哨兵)
     *
     * @param arr
     * @param p
     * @param q
     * @param r
     */
    private static void mergeBySentry(int[] arr, int p, int q, int r) {
        int[] leftArr = new int[q - p + 2];
        int[] rightArr = new int[r - q + 1];

        for (int i = 0; i <= q - p; i++) {
            leftArr[i] = arr[p + i];
        }
        // 第一个数组添加哨兵（最大值）
        leftArr[q - p + 1] = Integer.MAX_VALUE;

        for (int i = 0; i < r - q; i++) {
            rightArr[i] = arr[q + 1 + i];
        }
        // 第二个数组添加哨兵（最大值）
        rightArr[r - q] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int k = p;
        while (k <= r) {
            // 当左边数组到达哨兵值时，i不再增加，直到右边数组读取完剩余值，同理右边数组也一样
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 65, 45, 23, 8, 99, 11};
        mergeSort(a, 8);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);

        }
    }
}
