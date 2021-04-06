package com.chaka.algorithms.heap;

/**
 * @author chaka.hu
 * @date 2021/4/6 11:59 下午
 *
 *  父节点 ： n/2
 *  左孩子 : n * 2
 *  右孩子 : n * 2 + 1
 */
public class MaxHeap {

    int[] maxHeap;

    int heapSize;

    int realSize;

    public MaxHeap(int heapSize) {
        this.heapSize = heapSize;
        this.maxHeap = new int[heapSize + 1];
        maxHeap[0] = 0;
    }

    public void add(int val){
        if(realSize >= heapSize){
            throw new IllegalArgumentException("heap is full");
        }
        maxHeap[++realSize] = val;
        int idx = realSize;
        int parent = idx / 2;
        //添加的元素大于父节点，swap
        while (maxHeap[parent] < maxHeap[idx] && idx > 1){
            int tmp = maxHeap[parent];
            maxHeap[parent] = maxHeap[idx];
            maxHeap[idx] = tmp;
            idx = parent;
            parent = idx / 2;
        }
    }

    public int pop(){
        if (realSize < 1){
            throw new IllegalArgumentException("the heap is empty!");
        }
        int removeEle = maxHeap[1];
        //最后一个元素赋值给堆顶元素s
        maxHeap[1] = maxHeap[realSize];
        int idx = 1;
        while (idx < realSize && idx <= realSize / 2){
            int left = 2 * idx;
            int right = 2 * idx + 1;
            if (maxHeap[idx] < maxHeap[left] || maxHeap[idx] < maxHeap[right]){
                //确保换上去的节点是大于另外一个节点的
                if (maxHeap[left] > maxHeap[right]){
                    int tmp = maxHeap[left];
                    maxHeap[left] = maxHeap[idx];
                    maxHeap[idx] = tmp;
                    idx = left;
                }else {
                    int tmp = maxHeap[right];
                    maxHeap[right] = maxHeap[idx];
                    maxHeap[idx] = tmp;
                    idx = right;
                }
            }else {
                break;
            }
        }
        return removeEle;
    }

    //堆顶元素
    public int peek(){
        return maxHeap[1];
    }

}
