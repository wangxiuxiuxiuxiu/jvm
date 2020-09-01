package day05;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SynchronizedTest {

    static  int c= 5;
    public static void main(String[] args) {

        Map<String,Object> linkedHashMap = new LinkedHashMap<String,Object>(2);
        linkedHashMap.put("jack",19);
        linkedHashMap.put("luse",22);
        linkedHashMap.put("jack",19);
        linkedHashMap.put("xinfa",19);
        Object age = linkedHashMap.get("luse");


        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("la","89");
        concurrentHashMap.put("laa","89");


        /**
         * LRUCache 对象会以如下语句构造和调用:
         * LRUCache obj = new LRUCache(capacity);
         * int param_1 = obj.get(key);
         * obj.put(key,value);
         */
        LRUCache obj = new LRUCache(2);

        obj.put(22,33);
        int param_1 = obj.get(22);

        System.out.println(param_1);


        synchronized (SynchronizedTest.class){

            int i = c;
            int k = 66;
        }
    }
}

/*运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

        获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
        写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，
        则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，
        从而为新的数据值留出空间。
*/

class LRUCache extends LinkedHashMap<Integer, Integer>{
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    // 这个可不写
    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

