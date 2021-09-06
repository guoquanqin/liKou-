package com.example.demo;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 最近最少未使用
 *
 * @author gqq
 * @version 1.0, 2021/8/20 17:21
 */
public class LRUCache<K,V> extends LinkedHashMap<K,V> {

    private int CACHE_SIZE = 0;

    /**
     * 传递进来最多能缓存多少数据
     * @param cacheSize 缓存大小
     */
    public LRUCache(int cacheSize){
        // true 表示让linkedMap 按照访问顺序排序，最近访问放在头部，最老放在尾部
        super((int)Math.ceil(cacheSize / 0.75) + 1,0.75f,true);
        CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest){
        return size() > CACHE_SIZE;
    }

}
