package com.chaka.algorithms.ratelimit;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * java简写版滑动窗口限流器
 */
public class SlideWindowRateLimit {

    private volatile static Map<String, List<Long>> map = new ConcurrentHashMap<>();

    public static boolean isGo(String key,int count,long timeWindow){
        long nowTime = System.currentTimeMillis();
        List<Long> list = map.computeIfAbsent(key, k -> new LinkedList<>());
        if (list.size() < count){
            list.add(0,nowTime);
            return true;
        }
        //队列已满，拿到最早的时间
        Long farTime = list.get(count - 1);
        if (nowTime - farTime <= timeWindow){
            //时间窗口内已经满了
            return false;
        }else {
            //移除最早的那个
            list.remove(count - 1);
            list.add(0,nowTime);
            return true;
        }
    }

    public static void main(String[] args) {
        while (true){
            //10 QPS
            boolean result = SlideWindowRateLimit.isGo("key", 2, 200);
            if (result){
                System.out.println("通过");
            }else {
                System.out.println("被限流住了");
            }
        }
    }

}
