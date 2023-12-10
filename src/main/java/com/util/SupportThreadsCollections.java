package com.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 本类支持线程不同，数据也不一样
 */
public class SupportThreadsCollections<T> {
    private Map<Thread, T> map;
    private int counts;

    private int times;

    public void SetRuns(int counts) {
        this.counts = counts;
    }

    public void Start(Formation formation) {
        if (times < counts) {
            times++;
            formation.Run();
            times--;
        }
    }

    public boolean isNull() {
        return map.isEmpty();
    }

    public SupportThreadsCollections() {
        map = new HashMap<>();
    }

    public SupportThreadsCollections(T object) {
        map = new HashMap<>();
        map.put(Thread.currentThread(), object);
    }

    public void Add(T object) {
        map.put(Thread.currentThread(), object);
    }

    public T Get() {
        return map.get(Thread.currentThread());
    }

    public void Remove() {
        map.remove(Thread.currentThread());
    }
}
