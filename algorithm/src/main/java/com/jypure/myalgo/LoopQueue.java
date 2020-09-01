package com.jypure.myalgo;

/**
 * 循环队列
 * @author : jiayupeng
 * @date : 2020/9/1/22:18
 */
public class LoopQueue {

    //关键是确定队列空和满的条件
    //队列为空，head == tail
    //队列为满，(tail+1)%c == head, 这里c为数组容量
    //当队列为满时，tail指向的位置是没有数据的，因此循环队列会浪费数组的一个位置的存储空间

    private String[] data;

    private int head = 0;
    private int tail = 0;
    private int n = 0;

    public LoopQueue(int capacity){
        data = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String item) {
        int index = (tail + 1) % n;
        if (index == head) {
            return false;
        }

        data[index] = item;
        tail = (tail + 1) % n;
        return true;
    }

    public String dequeue() {
        if (tail == head) {
            return null;
        }

        String result = data[head];
        head = (head+1) % n;
        return result;
    }

}
