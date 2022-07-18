package com.jypure.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/sliding-window-maximum/
 * @author : jiayupeng
 * @date : 2022/7/13/19:23
 */
public class Code25 {

    /**
     * 优先级队列
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1]);
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;

    }


    //*****************************************//

    //解法一
    //自定义数组
    public static class MyQueue{
        Deque<Integer> deque = new LinkedList<>();
        //弹出元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
        //同时判断队列当前是否为空
        void poll(int val) {
            if (!deque.isEmpty() && val == deque.peek()) {
                deque.poll();
            }
        }

        //添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出
        //保证队列元素单调递减
        //比如此时队列元素3,1，2将要入队，比1大，所以1弹出，此时队列：3,2

        void add(int val) {
            while (!deque.isEmpty() && val > deque.getLast()) {
                deque.removeLast();
            }
            deque.add(val);
        }

        //队列队顶元素始终为最大值
        int peek() {
            return deque.peek();
        }

    }

    public static class Solution{
        public int[] maxSlidingWindow(int[] nums, int k){
            if (nums.length == 1) {
                return nums;
            }

            int len = nums.length - k + 1;
            //存放结果元素的数组
            int[] res = new int[len];
            int num = 0;
            MyQueue myQueue = new MyQueue();
            //先将前k的元素放入队列
            for (int i = 0; i < k; i++) {
                myQueue.add(nums[i]);
            }
            res[num++] = myQueue.peek();
            for (int i = k; i < nums.length; i++) {
                //滑动窗口移除最前面的元素，移除是判断该元素是否放入队列
                myQueue.poll(nums[i - k]);
                //滑动窗口加入最后面的元素
                myQueue.add(nums[i]);
                //记录对应的最大值
                res[num++] = myQueue.peek();
            }
            return res;
        }



        //解法二
        //利用双端队列手动实现单调队列
        /**
         * 用一个单调队列来存储对应的下标，每当窗口滑动的时候，直接取队列的头部指针对应的值放入结果集即可
         * 单调队列类似 （tail -->） 3 --> 2 --> 1 --> 0 (--> head) (右边为头结点，元素存的是下标)
         */
        public int[] maxSlidingWindow1(int[] nums, int k){
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            int n = nums.length;
            int[] res = new int[n - k + 1];
            int idx = 0;
            for (int i = 0; i < n; i++) {
                // 根据题意，i为nums下标，是要在[i - k + 1, i] 中选到最大值，只需要保证两点
                // 1.队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出
                while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                    deque.poll();
                }
                // 2.既然是单调，就要保证每次放进去的数字要比末尾的都大，否则也弹出
                while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.offer(i);

                // 因为单调，当i增长到符合第一个k范围的时候，每滑动一步都将队列头节点放入结果就行了
                if (i >= k - 1) {
                    res[idx++] = nums[deque.peek()];
                }
            }

            return res;
        }


    }
















}
