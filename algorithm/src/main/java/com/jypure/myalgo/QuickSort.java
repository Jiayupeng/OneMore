package com.jypure.myalgo;

/**
 * 快排
 * @author : jiayupeng
 * @date : 2019/11/30/17:21
 */
public class QuickSort {

    /**
     * a为数组，n为数组个数
     * @param a
     * @param n
     */
    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n - 1);
    }

    /**
     * 快速排序递归函数，p r 为下标
     * @param a
     * @param p
     * @param r
     */
    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = partition(a, p, r);
        quickSortInternally(a, p, q-1);
        quickSortInternally(a, q+1, r);
    }

    /**
     * 获取分区点
     * @param a
     * @param p
     * @param r
     * @return
     */
    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        return i;
    }

    public static void main(String[] args){
        int[] a = {3, 2, 65, 45, 23, 8, 99, 11};
        quickSort(a, 8);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);

        }
    }


}
