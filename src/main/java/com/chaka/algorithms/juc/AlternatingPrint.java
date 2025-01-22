package com.chaka.algorithms.juc;

import java.util.ArrayList;
import java.util.List;

public class AlternatingPrint {

    private int cnt = 0;
    private final Object lock = new Object();

    public void print(int num) {
        List<Thread> threadList = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            final int flag = i;
            Thread thread = new Thread(() -> {
                while (true) {
                    synchronized (lock) {
                        // 当前标志
                        if (cnt % num == flag) {
                            System.out.println(flag);
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            cnt++;
                        } else {
                            lock.notifyAll();
                        }
                    }
                }
            });
            threadList.add(thread);
        }
        threadList.forEach(Thread::start);
    }

    public static void main(String[] args) {
        AlternatingPrint alternatingPrint = new AlternatingPrint();
        alternatingPrint.print(3);
    }
}