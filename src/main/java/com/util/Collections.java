package com.util;

import java.util.HashMap;
import java.util.Map;

public class Collections<T> {
    private Map<Thread, T> map;
    private final Thread t1;
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

    public Collections() {
        map = new HashMap<>();
        t1 = Thread.currentThread();
    }

    public Collections(T object) {
        map = new HashMap<>();
        t1 = Thread.currentThread();
        map.put(t1, object);
    }

    public void Add(T object) {
        map.put(t1, object);
    }

    public T Get() {
        return map.get(t1);
    }

    public void Remove() {
        map.remove(t1);
    }
}
